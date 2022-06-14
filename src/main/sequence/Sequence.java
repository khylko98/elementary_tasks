package main.sequence;

public class Sequence {
    private int number;

    public Sequence(int number) {
        if (number < 2) throw new IllegalArgumentException("Number can't be less than 2!");
        else this.number = number;
    }

    public String getSequence() {
        StringBuilder result = new StringBuilder();
        int i = 1;
        while ((i * i) < number) {
            if (i == 1) result.append(i);
            else result.append(", ").append(i);
            i++;
        }
        return result.toString();
    }
}
