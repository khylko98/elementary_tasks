package test.fibonacci;

import main.fibonacci.Fibonacci;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @ParameterizedTest
    @DisplayName("Must throw IllegalArgumentException when max or min less than 0 or max < min")
    @CsvSource({"-1, 2", "8, 3"})
    void testFibonacci(int min, int max) {
        assertThrows(IllegalArgumentException.class, () -> new Fibonacci(min, max));
    }

    @ParameterizedTest
    @DisplayName("Метод должен вернуть результат как в CHESSBOARD4X6")
    @CsvSource({"'0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144', 0, 144"})
    void testFibonacci(String expected, int min, int max) {
        assertEquals(expected, new Fibonacci(min, max).fibonacci());
    }
}