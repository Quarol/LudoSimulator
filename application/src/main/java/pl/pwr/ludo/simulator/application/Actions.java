package pl.pwr.ludo.simulator.application;

import pl.pwr.ludo.simulator.logic.actions.*;

public enum Actions {
    ACTION1 (new TakeOutPawnAction()),
    ACTION2 (new MoveActivePawnAction()),
    ACTION3 (new MoveEndPawnAction()),
    ACTION4 (new KillPawnAction());
    private final Action a;
    Actions(Action a) {
        this.a = a;
    }
    public Action get () {
        return a;
    }
}