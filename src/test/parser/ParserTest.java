package test.parser;

import main.parser.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @ParameterizedTest
    @DisplayName("Must throw NullPointerException because file name or string to search can't be empty")
    @CsvSource({","})
    void testParserEmptyString(String pathToFile, String toSearch) {
        assertThrows(NullPointerException.class, () -> new Parser(pathToFile, toSearch));
    }

    @ParameterizedTest
    @DisplayName("Must throw FileNotFoundException because file can't be not found")
    @CsvSource({"src/test/parser/for_test.txt, text"})
    void testParserNoFile(String pathToFile, String toSearch) {
        assertThrows(FileNotFoundException.class, () -> new Parser(pathToFile, toSearch));
    }

    @ParameterizedTest
    @DisplayName("Must throw FileSystemException because file can't be empty")
    @CsvSource({"src/test/parser/for_test1.txt, Hello World!"})
    void testParserEmptyFile(String pathToFile, String toSearch) {
        assertThrows(FileSystemException.class, () -> new Parser(pathToFile, toSearch));
    }

    @ParameterizedTest
    @DisplayName("Must return 3 line")
    @CsvSource({"3, src/test/parser/for_test2.txt, Hello World!"})
    void testLineCounter(int expected, String pathToFile, String toSearch) throws IOException {
        assertEquals(expected, new Parser(pathToFile, toSearch).lineCounter());
    }

    @ParameterizedTest
    @DisplayName("Must change 'Hello' to 'World'")
    @CsvSource({"src/test/parser/for_test3.txt, Hello, World"})
    void testLineChanger(String pathToFile, String toChange, String toReplace) throws IOException {
        assertTrue(new Parser(pathToFile, toChange, toReplace).lineChanger());
    }
}