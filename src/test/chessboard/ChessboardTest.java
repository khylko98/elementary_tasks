package test.chessboard;

import main.chessboard.Chessboard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {
    @ParameterizedTest
    @DisplayName("Must throw new IllegalArgumentException when height or width less than 2")
    @CsvSource({"-1, 4", "0, 3", "1, 1"})
    void testChessboard(int height, int width) {
        assertThrows(IllegalArgumentException.class, () -> new Chessboard(height, width));
    }

    @ParameterizedTest
    @DisplayName("Must build chessboard like CHESSBOARD4X6")
    @CsvSource({"4, 6"})
    void testBuildChessboard(int height, int width) {
        String CHESSBOARD4X6 =  "* * * * * * \n" +
                                " * * * * * *\n" +
                                "* * * * * * \n" +
                                " * * * * * *\n";
        assertEquals(CHESSBOARD4X6, new Chessboard(height, width).buildChessboard());
    }
}