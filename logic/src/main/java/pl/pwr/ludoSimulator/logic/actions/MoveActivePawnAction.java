package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveActivePawnAction implements Action {
    private List<Pawn> getPawns(Board board, Player player, int roll) {
        List<Integer> usedEndPositions = getUsedEndPositions(board, player);
        List<Integer> usedPositions = getUsedActivePositions(board, player);
        List<Pawn> possiblePawns = board.getPlayerPawns(player).getActivePawns().stream()
                .filter(pawn -> !usedPositions.contains((pawn.getPosition() + roll) % 40))
                .toList();
        List<Pawn> activePawnsWhichCanMove = new ArrayList<>();
        for (Pawn pawn : possiblePawns) {
            if (pawn.getPosition() + roll < player.endPosition()) {
                activePawnsWhichCanMove.add(pawn);
            } else if (pawn.getPosition() > player.endPosition()) {
                activePawnsWhichCanMove.add(pawn);
            } else if (pawn.getPosition() < player.endPosition() && pawn.getPosition() + roll > player.endPosition()
                    && pawn.getPosition() + roll - player.endPosition() < 5
                    && !usedEndPositions.contains(pawn.getPosition() + roll - player.endPosition() - 1)
            ) {
                activePawnsWhichCanMove.add(pawn);
            }
        }
        return activePawnsWhichCanMove;
    }

    private List<Integer> getUsedEndPositions(Board board, Player player) {
        return board.getPlayerPawns(player).getEndPawns().stream()
                .flatMap(pawn -> Stream.of(pawn.getPosition()))
                .collect(Collectors.toList());
    }

    private List<Integer> getUsedActivePositions(Board board, Player player) {
        return board.getPlayerPawns(player).getActivePawns().stream()
                .flatMap(pawn -> Stream.of(pawn.getPosition()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        return getPawns(board, player, roll).size() != 0;
    }

    @Override
    public Board execute(Board board, Player player, int roll) {
        int endPosition = player.endPosition();
        List<Integer> usedEndPositions = getUsedEndPositions(board, player);
        List<Pawn> pawns = getPawns(board, player, roll);
        if (pawns.size() != 0) {
            Pawn pawn = pawns.get(0);
            if (pawn.getPosition() + roll < endPosition || pawn.getPosition() > endPosition) {
                pawn.setPosition((pawn.getPosition() + roll) % 40);
            } else if (pawn.getPosition() < endPosition && pawn.getPosition() + roll > endPosition) {
                if (pawn.getPosition() + roll - endPosition < 5
                        && !usedEndPositions.contains(pawn.getPosition() + roll - endPosition - 1)) {
                    board.getPlayerPawns(player).removeActivePawn(pawn);
                    board.getPlayerPawns(player).addEndPawn(
                            new Pawn(pawn.getPosition() + roll - endPosition - 1)
                    );
                }
            }
        }
        return board;
    }
}
