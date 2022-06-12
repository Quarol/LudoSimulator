package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

import java.util.ArrayList;
import java.util.List;

public class MoveActivePawnAction implements Action {
    private boolean possible;
    private int steps;
    private Player player;
    private Board board;
    private List<Pawn> pawns = new ArrayList<>();
    private List<Integer> usedEndPositions = new ArrayList<>();

    public List<Pawn> getPawns() {
        return pawns;
    }

    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        this.player = player;
        this.steps = roll;
        this.board = board;
        for (Pawn pawn : player.getEndPawns()) {
            this.usedEndPositions.add(pawn.getPosition());
        }
        List<Integer> usedPositions = new ArrayList<>();
        List<Pawn> activePawnsWhichCanMove = new ArrayList<>();
        for (Pawn pawn : player.getActivePawns()) {
            usedPositions.add(pawn.getPosition());
        }
        for (Pawn pawn : player.getActivePawns()) {
            if (!usedPositions.contains((pawn.getPosition() + roll) % 40)) {
                if (pawn.getPosition() + roll < player.getEndPosition()) {
                    activePawnsWhichCanMove.add(pawn);
                } else if (pawn.getPosition() > player.getEndPosition()) {
                    activePawnsWhichCanMove.add(pawn);
                } else if (pawn.getPosition() < player.getEndPosition() && pawn.getPosition() + roll > player.getEndPosition()
                        && pawn.getPosition() + roll - player.getEndPosition() < 5
                        && !this.usedEndPositions.contains(pawn.getPosition() + roll - player.getEndPosition() - 1)) {
                    activePawnsWhichCanMove.add(pawn);
                }
            }
        }
        this.pawns = activePawnsWhichCanMove;
        return this.possible = activePawnsWhichCanMove.size() != 0;
    }

    @Override
    public Board execute(Pawn pawn) {
        int endPosition = player.getEndPosition();
        if (pawn.getPosition()+steps < endPosition || pawn.getPosition() > endPosition) {
            pawn.setPosition((pawn.getPosition()+steps)%40);
        } else if (pawn.getPosition() < endPosition && pawn.getPosition()+steps > endPosition) {
            if (pawn.getPosition()+steps-endPosition < 5 && !this.usedEndPositions.contains(pawn.getPosition()+steps-endPosition-1)) {
                this.player.removeActivePawn(pawn);
                this.player.addEndPawn(new Pawn(pawn.getPosition()+steps-endPosition-1));
            }
        }
        return this.board;
    }
}
