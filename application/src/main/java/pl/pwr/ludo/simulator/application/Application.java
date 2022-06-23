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
        int nrOfPLayers = 0;
        try {
            nrOfPLayers = getNumberOfPlayers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Action> actions = Arrays.stream(Actions.values())
                .flatMap(action -> Stream.of(action.get()))
                .toList();
        Board board = new BoardInitializer(nrOfPLayers).initialize();
        Display display = new Display(board);
        Simulation simulation = new Simulation(board, actions, new Callback(display));
        simulation.start();
    }

    private static int getNumberOfPlayers() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadz liczbe graczy w przedziale 2-4: \n");
        System.out.print("Liczba graczy: ");
        int nrOfPLayers = scanner.nextInt();
        scanner.close();
        System.out.println("\n");
        if (nrOfPLayers > 4 || nrOfPLayers < 2) {
            throw new Exception("Nieprawidlowa liczba graczy");
        }
        return nrOfPLayers;
    }
}
