package pl.pwr.ludo.simulator.application;

import pl.pwr.ludo.simulator.display.Display;
import pl.pwr.ludo.simulator.simulation.SimulationCallback;

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
