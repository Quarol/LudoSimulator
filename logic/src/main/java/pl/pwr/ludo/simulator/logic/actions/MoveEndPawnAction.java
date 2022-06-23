package pl.pwr.ludo.simulator.logic.actions;

import java.util.List;
import java.util.stream.Stream;

import pl.pwr.ludo.simulator.logic.Board;
import pl.pwr.ludo.simulator.logic.Pawn;
import pl.pwr.ludo.simulator.logic.Player;
import pl.pwr.ludo.simulator.logic.PlayerPawns;

public class MoveEndPawnAction implements Action {
    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        return getPawns(board, player, roll).size() != 0;
    }

    private List<Pawn> getPawns(Board board, Player player, int roll) {
        List<Pawn> playerEndPawns = board.getPlayerPawns(player).getEndPawns();
        List<Integer> usedPositions = playerEndPawns.stream()
                .flatMap(pawn -> Stream.of(pawn.getPosition()))
                .toList();
        return playerEndPawns.stream()
                .filter(pawn -> pawn.getPosition() + roll < 4)
                .filter(pawn -> !usedPositions.contains(pawn.getPosition() + roll))
                .toList();
    }

    @Override
    public Board execute(Board board, Player player, int roll) {
        List<Pawn> pawns = getPawns(board, player, roll);
        if (pawns.size() != 0) {
            pawns.get(0).move(roll);
        }
        return board;
    }
}
