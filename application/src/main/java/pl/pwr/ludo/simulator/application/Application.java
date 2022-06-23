package pl.pwr.ludo.simulator.application;

import pl.pwr.ludo.simulator.display.*;
import pl.pwr.ludo.simulator.logic.*;
import pl.pwr.ludo.simulator.logic.actions.*;
import pl.pwr.ludo.simulator.simulation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args)  {
        int nrOfPLayers = getNumberOfPlayers();

        List<Action> actions = Arrays.stream(Actions.values())
                .flatMap(action -> Stream.of(action.get()))
                .toList();
        Board board = new BoardInitializer(nrOfPLayers).initialize();
        Display display = new Display(board);
        Simulation simulation = new Simulation(board, actions, new Callback(display));
        simulation.start();
    }

    private static int getNumberOfPlayers() {
        int nrOfPlayers = -1;
        Scanner scanner = new Scanner(System.in);
        while (nrOfPlayers > 4 || nrOfPlayers < 2) {
            System.out.println("Wprowadz liczbe graczy w przedziale 2-4:");
            System.out.print("Liczba graczy: ");
            nrOfPlayers = scanner.nextInt();
            if (nrOfPlayers > 4 || nrOfPlayers < 2) {
                System.out.println("Nieprawidlowa liczba graczy");
            }
        }
        scanner.close();
        return nrOfPlayers;
    }
}
