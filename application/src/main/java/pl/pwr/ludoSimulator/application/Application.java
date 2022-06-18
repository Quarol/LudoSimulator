package pl.pwr.ludoSimulator.application;

import pl.pwr.ludoSimulator.logic.actions.*;
import pl.pwr.ludoSimulator.simulation.*;
import pl.pwr.ludoSimulator.logic.*;
import pl.pwr.ludoSimulator.display.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz dane do symulacji");
        System.out.print("Liczba graczy: ");
        int nrOfPLayers = scanner.nextInt();
        System.out.println("\n");

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
}
