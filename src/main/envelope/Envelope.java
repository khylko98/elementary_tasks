package main.envelope;

public class Envelope implements Comparable<Envelope> {
    private double height;
    private double length;

    public void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("Height can't be less than 1!");
        else this.height = height;
    }

    public void setLength(double length) {
        if (length <= 0) throw new IllegalArgumentException("Length can't be less than 1!");
        else this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    @Override
    public int compareTo(Envelope envelope) {
        if (getHeight() > envelope.getHeight() && getLength() > envelope.getLength()) return 1;
        else if (getHeight() < envelope.getHeight() && getLength() < envelope.getLength()) return -1;
        else return 0;
    }
}
