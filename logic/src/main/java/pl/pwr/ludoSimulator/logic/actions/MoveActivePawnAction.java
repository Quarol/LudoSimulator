package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

import java.util.ArrayList;
import java.util.List;

public class MoveActivePawnAction implements Action {
    private List<Pawn> getPawns(Board board, Player player, int roll) {
        List<Integer> usedEndPositions = getUsedEndPositions(board, player);
        for (Pawn pawn : board.getPlayerPawns(player).getEndPawns()) {
            usedEndPositions.add(pawn.getPosition());
        }
        List<Integer> usedPositions = new ArrayList<>();
        List<Pawn> activePawnsWhichCanMove = new ArrayList<>();
        for (Pawn pawn : board.getPlayerPawns(player).getActivePawns()) {
            usedPositions.add(pawn.getPosition());
        }
        for (Pawn pawn : board.getPlayerPawns(player).getActivePawns()) {
            if (!usedPositions.contains((pawn.getPosition() + roll) % 40)) {
                if (pawn.getPosition() + roll < player.getEndPosition()) {
                    activePawnsWhichCanMove.add(pawn);
                } else if (pawn.getPosition() > player.getEndPosition()) {
                    activePawnsWhichCanMove.add(pawn);
                } else if (pawn.getPosition() < player.getEndPosition() && pawn.getPosition() + roll > player.getEndPosition()
                        && pawn.getPosition() + roll - player.getEndPosition() < 5
                        && !usedEndPositions.contains(pawn.getPosition() + roll - player.getEndPosition() - 1)) {
                    activePawnsWhichCanMove.add(pawn);
                }
            }
        }
        return activePawnsWhichCanMove;
    }

    private List<Integer> getUsedEndPositions (Board board, Player player) {
        List<Integer> usedEndPositions = new ArrayList<>();
        for (Pawn pawn : board.getPlayerPawns(player).getEndPawns()) {
            usedEndPositions.add(pawn.getPosition());
        }
        return usedEndPositions;
    }
    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        return getPawns(board, player, roll).size() != 0;
    }

    @Override
    public Board execute(Board board, Player player, int roll) {
        int endPosition = player.getEndPosition();
        List<Integer> usedEndPositions = getUsedEndPositions(board, player);
        List<Pawn> pawns = getPawns(board, player, roll);
        if (pawns.size() != 0) {
            Pawn pawn = pawns.get(0);
        if (pawn.getPosition() + roll < endPosition || pawn.getPosition() > endPosition) {
            pawn.setPosition((pawn.getPosition() + roll) % 40);
        } else if (pawn.getPosition() < endPosition && pawn.getPosition() + roll > endPosition) {
            if (pawn.getPosition() + roll - endPosition < 5 && !usedEndPositions.contains(pawn.getPosition() + roll - endPosition - 1)) {
                board.getPlayerPawns(player).removeActivePawn(pawn);
                board.getPlayerPawns(player).addEndPawn(new Pawn(pawn.getPosition() + roll - endPosition - 1));
            }
        }
        }
        return board;
    }
}
