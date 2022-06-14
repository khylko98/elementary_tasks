package main.triangle;

import java.text.DecimalFormat;

public class Triangle {
    private String name;
    private double side1;
    private double side2;
    private double side3;
    private double square;

    public Triangle(String name, double side1, double side2, double side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("Can't create triangle - side can't be less than 1!");
        } else if (side1 + side2 < side3 || side2 + side3 < side1 || side3 + side1 < side2) {
            throw new ArithmeticException("Sum of two side's can't be less than third side!");
        } else {
            this.name = name;
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    private double halfPerimeter() {
        return (side1 + side2 + side3) / 2;
    }

    private double calculateSquare() {
        return Math.sqrt(halfPerimeter() * (halfPerimeter() - side1) *
                (halfPerimeter() - side2) * (halfPerimeter() - side3));
    }

    public void setSquare() {
        square = calculateSquare();
    }

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        String format = new DecimalFormat("0.00").format(square);
        return "[Triangle " + name + "]: " + format + " cm";
    }
}
