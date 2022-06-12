package pl.pwr.ludoSimulator.application;

import pl.pwr.ludoSimulator.logic.actions.*;
import pl.pwr.ludoSimulator.simulation.*;
import pl.pwr.ludoSimulator.logic.*;
import pl.pwr.ludoSimulator.display.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nrOfPLayers;

        /*System.out.println("Wpisz dane do symulacji");
        System.out.print("Liczba graczy: ");
        nrOfPLayers = scanner.nextInt();
        System.out.println("\n");*/
        nrOfPLayers = 2;
        List<Action> actions = new ArrayList<>();
        actions.add(new TakeOutPawnAction());
        actions.add(new MoveActivePawnAction());
        actions.add(new MoveEndPawnAction());
        actions.add(new KillPawnAction());

        Simulation simulation = new Simulation(new BoardInitializer(4).initialize(), actions);
        simulation.start();
        Display display = new Display(simulation.getBoard());
        display.display();
    }
}
