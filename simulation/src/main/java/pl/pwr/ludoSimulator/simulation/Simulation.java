package pl.pwr.ludoSimulator.simulation;

import pl.pwr.ludoSimulator.logic.*;
import pl.pwr.ludoSimulator.logic.actions.*;
import pl.pwr.ludoSimulator.display.Display;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final Board board;
    public Simulation (Board board, List<Action> actions, SimulationCallback simulationCallback) {
        this.board = board;
        this.actions = actions;
    }
    public Board getBoard() {
        return board;
    }

    public int random () {
        return (int) Math.random();
    }
    private final List<Action> actions;
    private int nrOfMoves = 0;
    public void start () {
        Display display = new Display(board);
        display.display();
        while (board.getActivePlayers().size() > 1) {
            for (Player player : board.getActivePlayers()) {
                int roll;
                do {
                    roll = Dice.roll();
                    List<Action> possibleActions = findPossibleActions(board, player, roll);
                    boolean wasActionAccomplished =  (possibleActions.size() != 0);
                    if (wasActionAccomplished) {
                        afterActionAccomplished(board, player, roll, possibleActions, display);
                    }
                } while (roll == 6);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Nr of displays: " + nrOfMoves);
    }
    private List<Action> findPossibleActions (Board board, Player player, int roll) {
        List <Action> possibleActions = new ArrayList<>();
        for (Action action : actions) {
            if (action.isPossible(board, player, roll))
                possibleActions.add(action);
        }
        return possibleActions;
    }
    private void afterActionAccomplished (Board board, Player player, int roll, List<Action> possibleActions, Display display) {
        int actionToExecute = random() * possibleActions.size();
        possibleActions.get(actionToExecute).execute(board, player, roll);
        System.out.println();
        display.display();
        nrOfMoves++;
    }
}
