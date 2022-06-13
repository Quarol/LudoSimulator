package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

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
    @Override
    public Board execute(Board board, Player player, int roll) {
        if (isPossible(board, player, roll)) {
            board.getPlayerPawns(player).removeBasePawn();
            board.getPlayerPawns(player).addActivePawn(new Pawn(player.getStartPosition()));
            for (Player currentPlayer : board.getActivePlayers()) {
                if (currentPlayer.getId() != player.getId()) {
                    for (Pawn pawn : board.getPlayerPawns(currentPlayer).getActivePawns()) {
                        if (player.getStartPosition() == pawn.getPosition()) {
                            board.getPlayerPawns(currentPlayer).removeActivePawn(pawn);
                            board.getPlayerPawns(currentPlayer).addBasePawn(new Pawn());
                            break;
                        }
                    }
                }
            }
        }
        return board;
    }
}
