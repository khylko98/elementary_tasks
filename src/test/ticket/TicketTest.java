package test.ticket;

import main.ticket.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    @ParameterizedTest
    @DisplayName("Must throw NullPointerException because file name or indicator can't be empty")
    @CsvSource({","})
    void testTicketEmptyString(String pathToFile, String indicator) {
        assertThrows(NullPointerException.class, () -> new Ticket(pathToFile, indicator));
    }

    @ParameterizedTest
    @DisplayName("Must throw FileNotFoundException because file can't be not found")
    @CsvSource({"text.txt, Moskow"})
    void testTicketNoFile(String pathToFile, String indicator) {
        assertThrows(FileNotFoundException.class, () -> new Ticket(pathToFile, indicator));
    }

    @ParameterizedTest
    @DisplayName("Must throw FileSystemException because file can't be empty")
    @CsvSource({"src/test/ticket/for_test1.txt, Piter"})
    void testTicketEmptyFile(String pathToFile, String indicator) {
        assertThrows(FileSystemException.class, () -> new Ticket(pathToFile, indicator));
    }

    @ParameterizedTest
    @DisplayName("Must throw IllegalArgumentException for choosing wrong method name")
    @CsvSource({"src/test/ticket/for_test2.txt, Hello"})
    void testTicketWrongNameMethod(String pathToFile, String indicator) {
        assertThrows(IllegalArgumentException.class, () -> new Ticket(pathToFile, indicator));
    }

    @ParameterizedTest
    @DisplayName("Must return sum = 2")
    @CsvSource({"2, src/test/ticket/for_test3.txt, Moskow"})
    void testTicketMoskowCounter(int expected, String pathToFile, String indicator) throws IOException {
        assertEquals(expected, new Ticket(pathToFile, indicator).ticketCounter());
    }

    @ParameterizedTest
    @DisplayName("Must return sum = 2")
    @CsvSource({"2, src/test/ticket/for_test3.txt, Piter"})
    void testTicketPiterCounter(int expected, String pathToFile, String indicator) throws IOException {
        assertEquals(expected, new Ticket(pathToFile, indicator).ticketCounter());
    }
}