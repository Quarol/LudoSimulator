package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.*;

import java.util.ArrayList;
import java.util.List;

public class KillPawnAction implements Action {
    private List<Integer> getPositionsOccupiedByAnotherPlayers(Board board, Player actionPerformer) {
        List<Integer> otherPlayersUsedPositions = new ArrayList<>();
        for (Player player : board.getPlayers()) {
            if (!player.equals(actionPerformer)) {
                for (Pawn pawn : board.getPlayerPawns(player).getActivePawns()) {
                    otherPlayersUsedPositions.add(pawn.getPosition());
                }
            }
        }
        return otherPlayersUsedPositions;
    }

    private List<Pawn> findPawnsWhichCanKill(Board board, Player actionPerformer, int roll, List<Integer> positionsOccupiedByAnotherPlayers) {
        List<Pawn> activePawnsWhichCanKill = new ArrayList<>();
        List<Pawn> actionPerformerPawns = board.getPlayerPawns(actionPerformer).getActivePawns();
        for (Pawn pawn : actionPerformerPawns) {
            if (positionsOccupiedByAnotherPlayers.contains((pawn.getPosition() + roll) % 40)) {
                if (pawn.getPosition() + roll < actionPerformer.endPosition()) {
                    activePawnsWhichCanKill.add(pawn);
                } else if (pawn.getPosition() > actionPerformer.endPosition()) {
                    activePawnsWhichCanKill.add(pawn);
                }
            }
        }
        return activePawnsWhichCanKill;
    }

    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        return getPawns(board, player, roll).size() != 0;
    }

    private List<Pawn> getPawns(Board board, Player player, int roll) {
        List<Integer> otherPlayersUsedPositions = getPositionsOccupiedByAnotherPlayers(board, player);
        return findPawnsWhichCanKill(board, player, roll, otherPlayersUsedPositions);
    }

    @Override
    public Board execute(Board board, Player player, int roll) {
        int endPosition = player.endPosition();
        List<Pawn> pawns = getPawns(board, player, roll);
        if (pawns.size() != 0) {
            Pawn pawn = pawns.get(0);
            if (pawn.getPosition() + roll < endPosition || pawn.getPosition() > endPosition) {
                int position = (pawn.getPosition() + roll) % 40;
                for (Player currentPlayer : board.getActivePlayers()) {
                    for (Pawn p : board.getPlayerPawns(currentPlayer).getActivePawns()) {
                        if (p.getPosition() == position) {
                            board.getPlayerPawns(currentPlayer).removeActivePawn(p);
                            board.getPlayerPawns(currentPlayer).addBasePawn(new Pawn());
                            break;
                        }
                    }
                }
                pawn.setPosition((pawn.getPosition() + roll) % 40);
            }
        }
        return board;
    }
}
