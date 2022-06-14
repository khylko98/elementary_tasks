package main;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        System.out.print(   "MENU\n" +
                            "1.CHESSBOARD\n" +
                            "2.ENVELOPE\n" +
                            "3.TRIANGLE\n" +
                            "4.PARSER\n" +
                            "5.NUMBER\n" +
                            "6.TICKET\n" +
                            "7.SEQUENCE\n" +
                            "8.FIBONACCI\n" +
                            "9.POW\n" +
                            "10.STORAGE\n" +
                "Your choose is (enter num from 1 to 10): ");
        try {
            int userChoose = scanner.nextInt();
            if (userChoose < 1 || userChoose > 10) throw new IllegalArgumentException();
            Implementer implementer = new Implementer();
            switch (userChoose) {
                case 1: implementer.startChessboard(); break;
                case 2: implementer.startEnvelope(); break;
                case 3: implementer.startTriangle(); break;
                case 4: implementer.startParser(); break;
                case 5: implementer.startNumber(); break;
                case 6: implementer.startTicket(); break;
                case 7: implementer.startSequence(); break;
                case 8: implementer.startFibonacci(); break;
                case 9: implementer.startPow(); break;
                case 10: implementer.startStorage(); break;
            }
        } catch (IllegalArgumentException | InputMismatchException | NullPointerException exception) {
            System.out.println( "INSTRUCTION\n" +
                                "You need to specify which function you would like to play and enter the function " +
                                "number indicated in the menu list (example: 1.CHESSBOARD).\n" +
                                "Do not leave a blank line or enter a number outside the range 0 < n < 11!");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
