package pl.pwr.ludo.simulator.logic;

import java.util.List;
import java.util.ArrayList;

public class BoardInitializer {

    private final int numberOfPlayers;

    public BoardInitializer(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Board initialize() {
        List<Player> players = createRandomPlayers();

        return new Board(players);
    }

    private List<Player> createRandomPlayers() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new PlayerInitializer().initialize(i));
        }
        return players;
    }
}
