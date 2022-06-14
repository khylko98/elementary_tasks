package test.pow;

import main.pow.Pow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PowTest {
    @ParameterizedTest
    @DisplayName("Method must return like expected")
    @CsvSource({"25, 5, 5", "625, 25, 25", "3125, 625, 5"})
    void testPow(String expected, int x, int y) {
        assertEquals(Long.parseLong(expected), new Pow(x, y).pow());
    }
}