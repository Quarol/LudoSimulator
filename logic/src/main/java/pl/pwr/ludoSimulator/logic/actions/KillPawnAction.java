package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.*;

import java.util.ArrayList;
import java.util.List;
public class KillPawnAction implements Action{
    private boolean possible;
    private int steps;
    private Player player;
    private Board board;
    private List<Pawn> pawns = new ArrayList<>();
    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        this.player = player;
        player = (Player) player.clone();
        this.steps = roll;
        this.board = board;
        List<Integer> usedPositions = new ArrayList<>();
        List<Integer> otherPlayersUsedPositions = new ArrayList<>();
        List<Pawn> activePawnsWhichCanKill = new ArrayList<>();
        for (Player p : board.getPlayers()) {
            if (p.getId() != player.getId()) {
                for (Pawn pawn : p.getActivePawns()) {
                    otherPlayersUsedPositions.add(pawn.getPosition());
                }
            }
        }
        for (Pawn pawn : player.getActivePawns()) {
            if (!usedPositions.contains((pawn.getPosition() + roll) % 40) && otherPlayersUsedPositions.contains((pawn.getPosition() + roll) % 40)) {
                if (pawn.getPosition() + roll < player.getEndPosition()) {
                    activePawnsWhichCanKill.add(pawn);
                } else if (pawn.getPosition() > player.getEndPosition()) {
                    activePawnsWhichCanKill.add(pawn);
                }
            }
        }
        this.pawns = activePawnsWhichCanKill;
        return this.possible = activePawnsWhichCanKill.size() != 0;
    }

    public List<Pawn> getPawns() {
        return pawns;
    }

    @Override
    public Board execute(Pawn pawn) {
        int endPosition = player.getEndPosition();
        if (pawn.getPosition()+steps < endPosition || pawn.getPosition() > endPosition) {
            int position = (pawn.getPosition()+steps)%40;
            for (Player player : board.getActivePlayers()) {
                for (Pawn p : player.getActivePawns()) {
                    if (p.getPosition() == position) {
                        player.removeActivePawn(p);
                        player.addBasePawn(new Pawn());
                        break;
                    }
                }
            }
            pawn.setPosition((pawn.getPosition()+steps)%40);
        }
        return this.board;
    }
}
