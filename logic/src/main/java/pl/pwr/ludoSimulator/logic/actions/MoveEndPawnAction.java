package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.pawns.ActivePawn;
import pl.pwr.ludoSimulator.logic.pawns.EndPawn;
import pl.pwr.ludoSimulator.logic.pawns.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

import java.util.ArrayList;
import java.util.List;

public class MoveEndPawnAction implements Action{
    private boolean possible;
    private List<Pawn> pawns;
    private int steps;
    private Board board;
    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        this.board = board;
        this.steps = roll;
        List<Integer> usedPositions = new ArrayList<>();
        List<Pawn> endPawnsWhichCanMove = new ArrayList<>();
        for (EndPawn pawn : player.getEndPawns()) {
            usedPositions.add(pawn.getPosition());
        }
        for (EndPawn pawn : player.getEndPawns()) {
            if (pawn.getPosition()+roll < 4 && !usedPositions.contains(pawn.getPosition()+roll)) {
                endPawnsWhichCanMove.add(pawn);
            }
        }
        this.pawns = endPawnsWhichCanMove;
        return this.possible = endPawnsWhichCanMove.size() != 0;
    }
    public List<Pawn> getPawns () {
        return pawns;
    }
    @Override
    public Board execute(Pawn pawn) {
        pawn = pawns.get(0);
        if (possible) {
            ((EndPawn) pawn).move(steps);
        }
        return this.board;
    }
}
