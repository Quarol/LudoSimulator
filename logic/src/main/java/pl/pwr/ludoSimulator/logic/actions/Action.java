package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.Player;

public interface Action {
    boolean isPossible(Board board, Player player, int roll);
    Board execute(Board board, Player player, int roll);
}
