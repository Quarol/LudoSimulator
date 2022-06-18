package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

import java.util.List;
import java.util.Optional;

public class TakeOutPawnAction implements Action {
    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        if (roll != 6 || board.getPlayerPawns(player).getActivePawns().stream().anyMatch(pawn -> pawn.getPosition() == player.startPosition())) {
            return false;
        }
        return board.getPlayerPawns(player).getBasePawns().size() != 0;
    }

    @Override
    public Board execute(Board board, Player player, int roll) {
        if (isPossible(board, player, roll)) {
            board.getPlayerPawns(player).removeBasePawn();
            board.getPlayerPawns(player).addActivePawn(new Pawn(player.startPosition()));
            List<Player> otherPlayers = board.getPlayers().stream().filter(p -> !p.equals(player)).toList();
            for (Player currentPlayer : otherPlayers) {
                Optional<Pawn> otherPawn = board.getPlayerPawns(currentPlayer).getActivePawns().stream().filter(pawn -> player.startPosition() == pawn.getPosition()).findFirst();
                if (otherPawn.isPresent()) {
                    board.getPlayerPawns(currentPlayer).removeActivePawn(otherPawn.get());
                    board.getPlayerPawns(currentPlayer).addBasePawn(new Pawn());
                }
            }
        }
        return board;
    }
}
