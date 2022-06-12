package pl.pwr.ludoSimulator.application;

import pl.pwr.ludoSimulator.display.Display;
import pl.pwr.ludoSimulator.simulation.SimulationCallback;
public class Callback implements SimulationCallback {
    private Display display;
    public Callback (Display display) {
        this.display = display;
    }
    public void callbackAfterMove() {
        display.display();
    }
    public void callbackAfterRound () {

    }
    public void callbackAfterEnd() {

    }
}
