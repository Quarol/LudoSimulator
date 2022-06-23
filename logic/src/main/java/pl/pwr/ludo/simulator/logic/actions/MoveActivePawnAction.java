package pl.pwr.ludo.simulator.logic.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.pwr.ludo.simulator.logic.Board;
import pl.pwr.ludo.simulator.logic.Pawn;
import pl.pwr.ludo.simulator.logic.Player;

public class MoveActivePawnAction implements Action {
    private List<Pawn> getPawns(Board board, Player player, int roll) {
        List<Integer> usedEndPositions = getUsedEndPositions(board, player);
        List<Integer> usedPositions = getUsedActivePositions(board, player);
        List<Pawn> possiblePawns = player.getPawns().getActivePawns().stream()
                .filter(pawn -> !usedPositions.contains((pawn.getPosition() + roll) % 40))
                .toList();
        List<Pawn> activePawnsWhichCanMove = new ArrayList<>();
        for (Pawn pawn : possiblePawns) {
            if (pawn.getPosition() + roll < player.getEndPosition()) {
                activePawnsWhichCanMove.add(pawn);
            } else if (pawn.getPosition() > player.getEndPosition()) {
                activePawnsWhichCanMove.add(pawn);
            } else if (pawn.getPosition() < player.getEndPosition() && pawn.getPosition() + roll > player.getEndPosition()
                    && pawn.getPosition() + roll - player.getEndPosition() < 5
                    && !usedEndPositions.contains(pawn.getPosition() + roll - player.getEndPosition() - 1)
            ) {
                activePawnsWhichCanMove.add(pawn);
            }
        }
        return activePawnsWhichCanMove;
    }

    private List<Integer> getUsedEndPositions(Board board, Player player) {
        return player.getPawns().getEndPawns().stream()
                .flatMap(pawn -> Stream.of(pawn.getPosition()))
                .collect(Collectors.toList());
    }

    private List<Integer> getUsedActivePositions(Board board, Player player) {
        return player.getPawns().getActivePawns().stream()
                .flatMap(pawn -> Stream.of(pawn.getPosition()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        return getPawns(board, player, roll).size() != 0;
    }

    @Override
    public Board execute(Board board, Player player, int roll) {
        int getEndPosition = player.getEndPosition();
        List<Integer> usedEndPositions = getUsedEndPositions(board, player);
        List<Pawn> pawns = getPawns(board, player, roll);
        if (pawns.size() != 0) {
            Pawn pawn = pawns.get(0);
            if (pawn.getPosition() + roll < getEndPosition || pawn.getPosition() > getEndPosition) {
                pawn.setPosition((pawn.getPosition() + roll) % 40);
            } else if (pawn.getPosition() < getEndPosition && pawn.getPosition() + roll > getEndPosition) {
                if (pawn.getPosition() + roll - getEndPosition < 5
                        && !usedEndPositions.contains(pawn.getPosition() + roll - getEndPosition - 1)) {
                    player.getPawns().removeActivePawn(pawn);
                    player.getPawns().addEndPawn(
                            new Pawn(pawn.getPosition() + roll - getEndPosition - 1)
                    );
                }
            }
        }
        return board;
    }
}
