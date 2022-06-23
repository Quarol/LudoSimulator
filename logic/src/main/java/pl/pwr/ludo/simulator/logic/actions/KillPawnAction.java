package pl.pwr.ludo.simulator.logic.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import pl.pwr.ludo.simulator.logic.*;

public class KillPawnAction implements Action {
    private List<Integer> getPositionsOccupiedByAnotherPlayers(Board board, Player actionPerformer) {
        List<Integer> otherPlayersUsedPositions = new ArrayList<>();
        List<Player> otherPlayers = board.getPlayers().stream()
                .filter(p -> !p.equals(actionPerformer))
                .toList();
        for (Player player : otherPlayers) {
            otherPlayersUsedPositions
                    .addAll(board.getPlayerPawns(player).getActivePawns().stream()
                            .flatMap(p -> Stream.of(p.getPosition()))
                            .toList());
        }
        return otherPlayersUsedPositions;
    }

    private List<Pawn> findPawnsWhichCanKill(Board board, Player actionPerformer, int roll, List<Integer> positionsOccupiedByAnotherPlayers) {
        return board.getPlayerPawns(actionPerformer).getActivePawns().stream()
                .filter(pawn -> positionsOccupiedByAnotherPlayers.contains((pawn.getPosition() + roll) % 40))
                .filter(pawn -> (pawn.getPosition() + roll < actionPerformer.endPosition() || pawn.getPosition() > actionPerformer.endPosition()))
                .toList();
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
                List<Player> otherPlayers = board.getPlayers().stream()
                        .filter(p -> !p.equals(player))
                        .toList();
                for (Player currentPlayer : otherPlayers) {
                    Optional<Pawn> otherPawn = board.getPlayerPawns(currentPlayer).getActivePawns().stream()
                            .filter(p -> p.getPosition() == position)
                            .findFirst();
                    if (otherPawn.isPresent()) {
                        board.getPlayerPawns(currentPlayer).removeActivePawn(otherPawn.get());
                        board.getPlayerPawns(currentPlayer).addBasePawn(new Pawn());
                    }
                }
                pawn.setPosition((pawn.getPosition() + roll) % 40);
            }
        }
        return board;
    }
}
