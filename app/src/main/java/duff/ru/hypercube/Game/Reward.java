package duff.ru.hypercube.Game;

/**
 * Created by maks on 15.03.18.
 */

public class Reward {

    int pixels;
    int diaphragms;
    int hexes;
    int fortune;

    public Reward(int pixels, int diaphragms, int hexes, int fortune) {
        this.pixels = pixels;
        this.diaphragms = diaphragms;
        this.hexes = hexes;
        this.fortune = fortune;
    }

    public int getPixels() {
        return pixels;
    }

    public int getDiaphragms() {
        return diaphragms;
    }

    public int getFortune() {
        return fortune;
    }

    public int getHexes() {
        return hexes;
    }
}
