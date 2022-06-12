package pl.pwr.ludoSimulator.simulation;

import pl.pwr.ludoSimulator.logic.*;
import pl.pwr.ludoSimulator.logic.actions.*;
import pl.pwr.ludoSimulator.display.Display;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final Board board;
    private final SimulationCallback simulationCallback;
    public Simulation (Board board, List<Action> actions, SimulationCallback simulationCallback) {
        this.board = board;
        this.actions = actions;
        this.simulationCallback = simulationCallback;
    }
    public int random (int scope) {
        return (int) (Math.random()*scope);
    }
    private final List<Action> actions;
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
                        afterActionAccomplished(board, player, roll, possibleActions);
                        simulationCallback.callbackAfterMove();
                    }
                } while (roll == 6);
            }
            simulationCallback.callbackAfterRound();
        }
        simulationCallback.callbackAfterEnd();
    }
    private List<Action> findPossibleActions (Board board, Player player, int roll) {
        List <Action> possibleActions = new ArrayList<>();
        for (Action action : actions) {
            if (action.isPossible(board, player, roll))
                possibleActions.add(action);
        }
        return possibleActions;
    }
    private void afterActionAccomplished (Board board, Player player, int roll, List<Action> possibleActions) {
        int actionToExecute = random(possibleActions.size());
        possibleActions.get(actionToExecute).execute(board, player, roll);
    }
}
