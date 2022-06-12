package pl.pwr.ludoSimulator.simulation;

public interface SimulationCallback {
    void callbackAfterMove();
    void callbackAfterRound ();
    void callbackAfterEnd();
}
