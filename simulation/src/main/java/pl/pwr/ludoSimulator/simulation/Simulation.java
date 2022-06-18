package pl.pwr.ludoSimulator.simulation;

import pl.pwr.ludoSimulator.logic.*;
import pl.pwr.ludoSimulator.logic.actions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Simulation {
    private final Board board;
    private final List<Action> actions;
    private final SimulationCallback simulationCallback;

    public Simulation(Board board, List<Action> actions, SimulationCallback simulationCallback) {
        this.board = board;
        this.actions = actions;
        this.simulationCallback = simulationCallback;
    }

    public int random(int scope) {
        return (int) (Math.random() * scope);
    }
    public void start() {
        while (board.hasAnyActivePlayer()) {
            for (Player player : board.getActivePlayers()) {
                int roll;
                do {
                    roll = Dice.roll();
                    executeRandomAction(board, player, roll);
                    simulationCallback.callbackAfterMove();
                } while (roll == 6);
            }
            simulationCallback.callbackAfterRound();
        }
        simulationCallback.callbackAfterEnd();
    }

    private List<Action> findPossibleActions(Board board, Player player, int roll) {
        return actions.stream()
                .filter(action -> action.isPossible(board, player, roll))
                .collect(Collectors.toList());
    }
    private void executeRandomAction(Board board, Player player, int roll) {
        List<Action> possibleActions = findPossibleActions(board, player, roll);
        boolean thereAreAnyActions = (possibleActions.size() != 0);
        if (thereAreAnyActions) {
            int actionToExecute = random(possibleActions.size());
            possibleActions.get(actionToExecute).execute(board, player, roll);
        }
    }
}
