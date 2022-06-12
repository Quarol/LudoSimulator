package pl.pwr.ludoSimulator.application;

import org.junit.jupiter.api.Test;
import pl.pwr.ludoSimulator.display.Display;
import pl.pwr.ludoSimulator.logic.*;
import pl.pwr.ludoSimulator.logic.actions.*;

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
        display.display();
        assertEquals("\n" +
                "1       O O V      22 \n" +
                "        O X O      2  \n" +
                "        O X O         \n" +
                "        O 2 O         \n" +
                "> O O O O X 1 O O O O \n" +
                "O X 1 X 1   X 3 X X O \n" +
                "O O O O O X O O O O < \n" +
                "        O 4 O         \n" +
                "        O X O         \n" +
                "44      O X O      33 \n" +
                "4       ^ O O      3  \n", display.toString());
    }
}
