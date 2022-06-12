package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

import java.util.List;


public interface Action {
    List<Pawn> getPawns();
    boolean isPossible(Board board, Player player, int roll);
    Board execute(Pawn pawn);
}
