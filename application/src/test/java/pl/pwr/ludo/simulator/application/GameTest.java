package pl.pwr.ludo.simulator.application;

import org.junit.jupiter.api.Test;

import pl.pwr.ludo.simulator.display.Display;
import pl.pwr.ludo.simulator.logic.*;
import pl.pwr.ludo.simulator.logic.actions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class GameTest {
    @Test
    void mainTest() {
        Board board = new BoardInitializer(4).initialize();
        Display display = new Display(board);
        for (Player player : board.getPlayers()) {
            int roll = 6;
            Action action = new TakeOutPawnAction();
            if (action.isPossible(board, player, roll)) {
                action.execute(board, player, roll);
            }
        }
        for (int i = 0; i < 7; i++) {
            for (Player player : board.getPlayers()) {
                Action action = new MoveActivePawnAction();
                if (action.isPossible(board, player, 6)) {
                    action.execute(board, player, 6);
                }
            }
        }
        Action action = new TakeOutPawnAction();
        action.isPossible(board, board.getPlayer(0), 6);
        action.execute(board, board.getPlayer(0), 6);
        action = new MoveActivePawnAction();
        action.isPossible(board, board.getPlayer(0), 6);
        action.execute(board, board.getPlayer(0), 6);

        action = new MoveActivePawnAction();
        action.isPossible(board, board.getPlayer(0), 6);
        action.execute(board, board.getPlayer(0), 6);

        action = new MoveActivePawnAction();
        action.isPossible(board, board.getPlayer(0), 6);
        action.execute(board, board.getPlayer(0), 6);

        action = new MoveActivePawnAction();
        action.isPossible(board, board.getPlayer(0), 6);
        action.execute(board, board.getPlayer(0), 6);

        action = new MoveActivePawnAction();
        action.isPossible(board, board.getPlayer(0), 6);
        action.execute(board, board.getPlayer(0), 6);

        action = new MoveActivePawnAction();
        action.isPossible(board, board.getPlayer(0), 6);
        action.execute(board, board.getPlayer(0), 6);

        action = new MoveActivePawnAction();
        action.isPossible(board, board.getPlayer(0), 5);
        action.execute(board, board.getPlayer(0), 5);

        action = new MoveEndPawnAction();
        if (action.isPossible(board, board.getPlayer(0), 1)) {
            action.execute(board, board.getPlayer(0), 1);
        }
        action = new TakeOutPawnAction();
        action.isPossible(board, board.getPlayer(0), 6);
        action.execute(board, board.getPlayer(0), 6);
        action = new TakeOutPawnAction();
        action.isPossible(board, board.getPlayer(1), 6);
        action.execute(board, board.getPlayer(1), 6);
        action = new MoveActivePawnAction();
        action.isPossible(board, board.getPlayer(0), 6);
        action.execute(board, board.getPlayer(0), 6);

        action = new KillPawnAction();
        action.isPossible(board, board.getPlayer(0), 4);
        action.execute(board, board.getPlayer(0), 4);

        action = new MoveActivePawnAction();
        action.isPossible(board, board.getPlayer(0), 4);
        action.execute(board, board.getPlayer(0), 4);
        //display.display();
        assertEquals("""

                1       O O V      22\s
                        O X O      2 \s
                        O X O        \s
                        O 2 O        \s
                > O O O O X 1 O O O O\s
                O X 1 X 1   X 3 X X O\s
                O O O O O X O O O O <\s
                        O 4 O        \s
                        O X O        \s
                44      O X O      33\s
                4       ^ O O      3 \s
                """, display.toString());
    }
}
