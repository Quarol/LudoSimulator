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
    // potrzeba sprawdzić, czy tam nie stoi pionek innego gracza i analogicznie w KillPawnAction sprawdzić, czy wyciągając pionek nie zabijemy kogoś
    @Override
    public Board execute(Board board, Player player, int roll) {
        if (isPossible(board, player, roll)) {
            board.getPlayerPawns(player).removeBasePawn();
            board.getPlayerPawns(player).addActivePawn(new Pawn(player.getStartPosition()));
        }
        return board;
    }
}
