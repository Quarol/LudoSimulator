package pl.pwr.ludo.simulator.logic.actions;

import pl.pwr.ludo.simulator.logic.Board;
import pl.pwr.ludo.simulator.logic.Player;

public interface Action {
    boolean isPossible(Board board, Player player, int roll);
    Board execute(Board board, Player player, int roll);
}
