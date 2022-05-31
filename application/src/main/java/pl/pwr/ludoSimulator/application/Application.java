package pl.pwr.ludoSimulator.application;

import pl.pwr.ludoSimulator.simulation.*;
import pl.pwr.ludoSimulator.logic.*;
import pl.pwr.ludoSimulator.display.*;

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

        Simulation simulation = new Simulation(new Board(nrOfPLayers));
        simulation.start();
        Display display = new Display(simulation.getBoard());
        display.display();
    }
}
