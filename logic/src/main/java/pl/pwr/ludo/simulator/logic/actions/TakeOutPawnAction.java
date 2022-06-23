package pl.pwr.ludo.simulator.logic.actions;

import java.util.List;
import java.util.Optional;

import pl.pwr.ludo.simulator.logic.Board;
import pl.pwr.ludo.simulator.logic.Pawn;
import pl.pwr.ludo.simulator.logic.Player;

public class TakeOutPawnAction implements Action {
    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        if (roll != 6 || player.getPawns().getActivePawns().stream()
                .anyMatch(pawn -> pawn.getPosition() == player.getStartPosition())
        ) {
            return false;
        }
        return player.getPawns().getBasePawns().size() != 0;
    }

    @Override
    public Board execute(Board board, Player player, int roll) {
        if (isPossible(board, player, roll)) {
            player.getPawns().removeBasePawn();
            player.getPawns().addActivePawn(new Pawn(player.getStartPosition()));
            List<Player> otherPlayers = board.getPlayers().stream()
                    .filter(p -> !p.equals(player))
                    .toList();
            for (Player currentPlayer : otherPlayers) {
                Optional<Pawn> otherPawn = currentPlayer.getPawns().getActivePawns().stream()
                        .filter(pawn -> player.getStartPosition() == pawn.getPosition())
                        .findFirst();
                if (otherPawn.isPresent()) {
                    currentPlayer.getPawns().removeActivePawn(otherPawn.get());
                    currentPlayer.getPawns().addBasePawn(new Pawn());
                }
            }
        }
        return board;
    }
}
