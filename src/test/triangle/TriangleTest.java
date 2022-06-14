package test.triangle;

import main.triangle.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private static Triangle triangle;

    @ParameterizedTest
    @DisplayName("Must throw ArithmeticException when sum of two side's less than third side")
    @CsvSource({"name1, 2, 3, 10", "name2, 10, 2, 3", "name3, 3, 10, 2"})
    void testTriangle1(String name, double side1, double side2, double side3) {
        assertThrows(ArithmeticException.class, () -> new Triangle(name, side1, side2, side3));
    }

    @ParameterizedTest
    @DisplayName("Must throw IllegalArgumentException when side less than 1")
    @CsvSource({"name4, 0, 0, 0", "name5, -5, 8, 1", "name6, -10.4, -73.782, 100"})
    void testTriangle2(String name, double side1, double side2, double side3) {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(name, side1, side2, side3));
    }

    @ParameterizedTest
    @DisplayName("Must return square like expected")
    @CsvSource({"82.57, name7, 15.5, 17.2, 10.84"})
    void testTriangleSquare(double expected, String name, double side1, double side2, double side3) {
        triangle = new Triangle(name, side1, side2, side3);
        triangle.setSquare();
        assertEquals(expected, (double) Math.round(triangle.getSquare() * 100) / 100);
    }

    @ParameterizedTest
    @DisplayName("Must return string like expected")
    @CsvSource({"'[Triangle name7]: 82,57 cm'"})
    void testToString(String expected) {
        assertEquals(expected, triangle.toString());
    }
}