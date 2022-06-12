package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

import java.util.ArrayList;
import java.util.List;

public class TakeOutPawnAction implements Action {
    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        if (roll != 6) {
            return false;
        }
        boolean possible = board.getPlayerPawns(player).getBasePawns().size() != 0;

        for (Pawn pawn : board.getPlayerPawns(player).getActivePawns()) {
            if (pawn.getPosition() == player.getStartPosition()) {
                return false;
            }
        }
        return possible;
    }
    private List<Pawn> getPawns (Board board, Player player, int roll) {
        List<Pawn> list = new ArrayList<>();
        list.add(new Pawn(player.getStartPosition()));
        return list;
    }
    @Override
    public Board execute(Board board, Player player, int roll) {
        List<Pawn> pawns = getPawns(board, player, roll);
        if (pawns.size() != 0) {
            board.getPlayerPawns(player).removeBasePawn();
            board.getPlayerPawns(player).setBasePawns(board.getPlayerPawns(player).getBasePawns());
            board.getPlayerPawns(player).addActivePawn(pawns.get(0));
        }
        return board;
    }
}
