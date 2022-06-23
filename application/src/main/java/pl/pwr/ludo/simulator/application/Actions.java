package pl.pwr.ludo.simulator.application;

import pl.pwr.ludo.simulator.logic.actions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum Actions {
    ACTION1(new TakeOutPawnAction()),
    ACTION2(new MoveActivePawnAction()),
    ACTION3(new MoveEndPawnAction()),
    ACTION4(new KillPawnAction());
    private final Action a;

    Actions(Action a) {
        this.a = a;
    }

    public Action get() {
        return a;
    }

    public static List<Action> getAll() {
        return Arrays.stream(Actions.values())
                .flatMap(action -> Stream.of(action.get()))
                .toList();
    }
}