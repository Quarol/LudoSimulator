package pl.pwr.ludo.simulator.logic;

public record Player(int id, int startPosition, int endPosition) {

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Player player = (Player) o;
        return id == player.id;
    }

}