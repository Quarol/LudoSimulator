package pl.pwr.ludoSimulator.application;

import pl.pwr.ludoSimulator.logic.actions.*;

public enum AllActions {
    ACTION1, ACTION2, ACTION3, ACTION4;
    public Action get() {
        return switch (this) {
            case ACTION1 -> new TakeOutPawnAction();
            case ACTION2 -> new MoveActivePawnAction();
            case ACTION3 -> new MoveEndPawnAction();
            case ACTION4 -> new KillPawnAction();
        };
    }
}