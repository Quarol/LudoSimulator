package pl.pwr.ludo.simulator.logic;

public class Dice {
    public static int roll () {
        return (int)(Math.random()*6+1);
    }
    private Dice () {}
}
