package pl.pwr.ludoSimulator.simulation;

public interface SimulationCallback {
    public void callbackAfterMove();
    public void callbackAfterRound ();
    public void callbackAfterEnd();
}
