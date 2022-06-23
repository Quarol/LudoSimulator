package pl.pwr.ludo.simulator.simulation;

import java.util.List;
import java.util.stream.Collectors;

import pl.pwr.ludo.simulator.logic.*;
import pl.pwr.ludo.simulator.logic.actions.*;

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
                int diceRoll;
                do {
                    diceRoll = Dice.roll();
                    if (board.hasAnyActivePlayer()) {
                        executeRandomAction(board, player, diceRoll);
                        simulationCallback.callbackAfterMove();
                    }
                } while (diceRoll == 6);
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
    private void executeRandomAction(Board board, Player player, int diceRoll) {
        List<Action> possibleActions = findPossibleActions(board, player, diceRoll);
        boolean areThereAnyActions = (possibleActions.size() != 0);
        if (areThereAnyActions) {
            int actionToExecute = random(possibleActions.size());
            possibleActions.get(actionToExecute).execute(board, player, diceRoll);
        }
    }
}
