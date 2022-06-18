package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

import java.util.ArrayList;
import java.util.List;

public class MoveEndPawnAction implements Action {
    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        return getPawns(board, player, roll).size() != 0;
    }

    private List<Pawn> getPawns(Board board, Player player, int roll) {
        List<Integer> usedPositions = new ArrayList<>();
        for (Pawn pawn : board.getPlayerPawns(player).getEndPawns()) {
            usedPositions.add(pawn.getPosition());
        }
        return board.getPlayerPawns(player).getEndPawns().stream()
                .filter(pawn -> (pawn.getPosition() + roll < 4 && !usedPositions.contains(pawn.getPosition() + roll))).toList();
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
