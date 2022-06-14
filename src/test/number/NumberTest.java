package test.number;

import main.number.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    @ParameterizedTest
    @DisplayName("Must throw IllegalArgumentException when number less than 0 or larger than 1000")
    @CsvSource({"-1", "10000"})
    void testNumber(int number) {
        assertThrows(IllegalArgumentException.class, () -> new Number(number));
    }

    @ParameterizedTest
    @DisplayName("Must return correct result")
    @CsvSource({"12 - двенадцать, 12", "41 - сорок один, 41", "308 - триста восемь, 308"})
    void testConverter(String expected, int number) {
        assertEquals(expected, new Number(number).converter());
    }
}