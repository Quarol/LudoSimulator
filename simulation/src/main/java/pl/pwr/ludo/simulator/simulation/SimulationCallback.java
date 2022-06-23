package pl.pwr.ludo.simulator.simulation;

public interface SimulationCallback {
    void callbackAfterMove();
    void callbackAfterRound ();
    void callbackAfterEnd();
}
