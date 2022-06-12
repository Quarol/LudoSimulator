package pl.pwr.ludoSimulator.simulation;

import pl.pwr.ludoSimulator.logic.*;
import pl.pwr.ludoSimulator.logic.actions.*;
import pl.pwr.ludoSimulator.display.Display;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final Board board;
    public Simulation (Board board, List<Action> actions) {
        this.board = board;
        this.actions = actions;
    }
    public Board getBoard() {
        return board;
    }

    public int random () {
        return (int) Math.random();
    }
    private List<Action> actions;
    public void start () {
        int nrOfMoves = 0;
        Display display = new Display(board);
        display.display();

        while (board.getActivePlayers().size() > 1) {
            for (Player player : board.getActivePlayers()) {

                int roll;
                List<Action> possibleActions;
                do {
                    roll = Dice.roll();
                    List<Action> actions = new ArrayList<>();
                    actions.add(new TakeOutPawnAction());
                    actions.add(new MoveActivePawnAction());
                    actions.add(new MoveEndPawnAction());
                    actions.add(new KillPawnAction());
                    possibleActions = new ArrayList<>();

                    for (Action action : actions) {
                        if (action.isPossible(board, player, roll))
                            possibleActions.add(action);
                    }

                    boolean wasActionAccomplished =  (possibleActions.size() != 0);
                    if (wasActionAccomplished) {
                        int actionToExecute = random() * possibleActions.size();
                        possibleActions.get(actionToExecute).execute(board, player, roll);
                        System.out.println();
                        display.display();
                        nrOfMoves++;
                    }
                } while (roll == 6);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Nr of displays: " + nrOfMoves);
    }
}
