package pl.pwr.ludo.simulator.application;

import pl.pwr.ludo.simulator.display.Display;
import pl.pwr.ludo.simulator.simulation.SimulationCallback;

public class Callback implements SimulationCallback {
    private final Display display;

    public Callback(Display display) {
        this.display = display;
    }

    private int numberOfDiceRolls = 0;
    private int numberOfRounds = 0;

    public void callbackAfterMove() {
        numberOfDiceRolls++;
        display.display();
    }

    public void callbackAfterRound() {
        numberOfRounds++;
    }

    public void callbackAfterEnd() {
        System.out.println("Laczna liczba rzutow kosta: " + numberOfDiceRolls);
        System.out.println("Laczna liczba rund w grze: " + numberOfRounds);
    }
}
