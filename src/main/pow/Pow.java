package main.pow;

public class Pow {
    private int x;
    private int y;

    public Pow(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public long pow() {
        return (long) x * y;
    }
}
