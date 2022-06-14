package main.fibonacci;

public class Fibonacci {
    private int min;
    private int max;

    public Fibonacci(int min, int max) {
        if (max <= min || min < 0) {
            throw new IllegalArgumentException("Max can't be less or equal than min and max&min can't be less than 0!");
        } else {
            this.min = min;
            this.max = max;
        }
    }

    public String fibonacci() {
        StringBuilder result = new StringBuilder();
        int num_0 = 0;
        int num_1 = 1;
        int num_2 = 0;
        if (min == 0 && max == 0) result.append(num_0);
        if (min <= 1 && max != 0) result.append(num_0).append(" ").append(num_1);
        while (num_2 != max) {
            num_2 = num_0 + num_1;
            if (num_2 >= min) result.append(" ").append(num_2);
            num_0 = num_1;
            num_1 = num_2;
        }
        return result.toString().replaceAll(" ", ", ");
    }
}
