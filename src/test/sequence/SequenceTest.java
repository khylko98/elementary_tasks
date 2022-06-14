package test.sequence;

import main.sequence.Sequence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTest {
    @ParameterizedTest
    @DisplayName("Must throw IllegalArgumentException when number less than 2")
    @CsvSource({"-10", "0", "1"})
    void testSequence(int number) {
        assertThrows(IllegalArgumentException.class, () -> new Sequence(number));
    }

    @ParameterizedTest
    @DisplayName("Method must return string like expected")
    @CsvSource({"'1, 2, 3, 4, 5, 6, 7, 8, 9, 10', 121"})
    void testGetSequence(String expected, int number) {
        assertEquals(expected, new Sequence(number).getSequence());
    }
}