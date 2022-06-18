package pl.pwr.ludoSimulator.application;

import pl.pwr.ludoSimulator.display.Display;
import pl.pwr.ludoSimulator.simulation.SimulationCallback;

public class Callback implements SimulationCallback {
    private final Display display;

    public Callback(Display display) {
        this.display = display;
    }

    private int counter = 0;

    public void callbackAfterMove() {
        counter++;
        display.display();
    }

    public void callbackAfterRound() {

    }

    public void callbackAfterEnd() {
        System.out.println(counter);
    }
}
