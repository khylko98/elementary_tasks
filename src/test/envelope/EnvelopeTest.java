package test.envelope;

import main.envelope.Envelope;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopeTest {
    private Envelope envelope = new Envelope();

    @ParameterizedTest
    @DisplayName("Must throw new IllegalArgumentException when height less than 1")
    @CsvSource({"0", "-1", "-10.5"})
    void testSetHeight(double height) {
        assertThrows(IllegalArgumentException.class, () -> envelope.setHeight(height));
    }

    @ParameterizedTest
    @DisplayName("Must throw new IllegalArgumentException when length less than 1")
    @CsvSource({"0", "-1", "-10.5"})
    void testSetLength(double length) {
        assertThrows(IllegalArgumentException.class, () -> envelope.setLength(length));
    }

    @ParameterizedTest
    @DisplayName("Must return height like expected")
    @CsvSource({"15, 15"})
    void testGetHeight(double expected, double height) {
        envelope.setHeight(height);
        assertEquals(expected, envelope.getHeight());
    }

    @ParameterizedTest
    @DisplayName("Must return length like expected")
    @CsvSource({"25, 25"})
    void testGetLength(double expected, double length) {
        envelope.setLength(length);
        assertEquals(expected, envelope.getLength());
    }

    @ParameterizedTest
    @DisplayName("Must testing compareTo method")
    @CsvSource({"1, 15, 20, 8, 10", "-1, 4, 6, 8, 12", "0, 5, 6, 6, 5"})
    void testCompareTo(int expected, double height1, double length1, double height2, double length2) {
        Envelope envelope1 = new Envelope();
        Envelope envelope2 = new Envelope();
        envelope1.setHeight(height1);
        envelope1.setLength(length1);
        envelope2.setHeight(height2);
        envelope2.setLength(length2);
        assertEquals(expected, envelope1.compareTo(envelope2));
    }
}