package pl.pwr.ludoSimulator.simulation;

import pl.pwr.ludoSimulator.logic.*;
import pl.pwr.ludoSimulator.logic.actions.*;
import pl.pwr.ludoSimulator.logic.pawns.Pawn;
import pl.pwr.ludoSimulator.display.Display;

import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings("ALL")
public class Simulation {
    private final Board board;
    public Simulation (Board board) {
        this.board = board;
    }
    public Board getBoard() {
        return board;
    }

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
                    KillPawnAction killPawnBy = new KillPawnAction();

                    boolean canPawnKill = killPawnBy.isPossible(board, player, roll);
                    List<Pawn> pawnsWhichCanKill = killPawnBy.getPawns();
                    possibleActions = new ArrayList<>();

                    for (Action action : actions) {
                        if (action.isPossible(board, player, roll))
                            possibleActions.add(action);
                    }

                    boolean wasActionAccomplished =  (possibleActions.size() != 0);
                    if (wasActionAccomplished) {
                        int actionToExecute = (int) (Math.random() * possibleActions.size());
                        List<Pawn> avaiblePawns = possibleActions.get(actionToExecute).getPawns();
                        int pawnToPerformAction = (int) (Math.random() * avaiblePawns.size());
                        possibleActions.get(actionToExecute).execute(avaiblePawns.get(pawnToPerformAction));
                    }

                    if (canPawnKill) {
                        int pawnWhichKills = (int) (Math.random() * pawnsWhichCanKill.size());
                        killPawnBy.execute(pawnsWhichCanKill.get(pawnWhichKills));
                    }

                    if (wasActionAccomplished) {
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
