package pl.pwr.ludoSimulator.application;

import pl.pwr.ludoSimulator.logic.actions.*;
import pl.pwr.ludoSimulator.simulation.*;
import pl.pwr.ludoSimulator.logic.*;
import pl.pwr.ludoSimulator.display.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception {
        int nrOfPLayers = getNumberOfPlayers();

        /*AllActions[] allActions = AllActions.values();
        List<Action> actions = */

        List<Action> actions = new ArrayList<>();
        actions.add(new TakeOutPawnAction());
        actions.add(new MoveActivePawnAction());
        actions.add(new MoveEndPawnAction());
        actions.add(new KillPawnAction());
        Board board = new BoardInitializer(nrOfPLayers).initialize();
        Display display = new Display(board);
        Simulation simulation = new Simulation(board, actions, new Callback(display));
        simulation.start();
    }

    private static int getNumberOfPlayers() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz dane do symulacji");
        System.out.print("Liczba graczy: ");
        int nrOfPLayers = scanner.nextInt();
        System.out.println("\n");
        if (nrOfPLayers > 4 || nrOfPLayers < 2) {
            throw new Exception("Wprowadź liczbę graczy w przedziale 2-4");
        }

        return nrOfPLayers;
    }
}
