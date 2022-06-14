package main;

import main.chessboard.Chessboard;
import main.envelope.Envelope;
import main.fibonacci.Fibonacci;
import main.number.Number;
import main.parser.Parser;
import main.pow.Pow;
import main.sequence.Sequence;
import main.ticket.Ticket;
import main.triangle.Triangle;
import main.user.User;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.sql.SQLException;
import java.util.*;

public class Implementer {
    private Scanner scanner = new Scanner(System.in);

    public void startChessboard() {
        int height;
        int width;
        try {
            System.out.print("Enter height for chessboard: ");
            height = scanner.nextInt();
            System.out.print("Enter width for chessboard: ");
            width = scanner.nextInt();
            Chessboard chessboard = new Chessboard(height, width);
            System.out.print(chessboard.buildChessboard());
        } catch (InputMismatchException exception) {
            System.out.println("Height/Width must be numeric!");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void startEnvelope() {
        String userChoose;
        do {
            Envelope envelope1 = new Envelope();
            Envelope envelope2 = new Envelope();
            System.out.println("FIRST ENVELOPE");
            setEnvelope(envelope1);
            System.out.println("SECOND ENVELOPE");
            setEnvelope(envelope2);
            int comparisonResult = envelope1.compareTo(envelope2);
            switch (comparisonResult) {
                case 1: System.out.println("YOUR RESULT\nSecond envelope can be put into the first envelope"); break;
                case -1: System.out.println("YOUR RESULT\nFirst envelope can be put into the second envelope"); break;
                case 0: System.out.println("YOUR RESULT\nEnvelopes can't put into each other"); break;
            }
            scanner.nextLine();
            System.out.print("Do you want to continue?\nEnter your choose (y/yes or n/no): ");
            userChoose = scanner.nextLine();
        } while (userChoose.equalsIgnoreCase("y") || userChoose.equalsIgnoreCase("yes"));
    }

    private void setEnvelope(Envelope envelope) {
        do {
            try {
                System.out.print("Enter height for envelope: ");
                envelope.setHeight(scanner.nextDouble());
                System.out.print("Enter length for envelope: ");
                envelope.setLength(scanner.nextDouble());
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input! Height/Length must be numeral!");
                scanner.next();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        } while (envelope.getHeight() <= 0 || envelope.getLength() <= 0);
    }

    public void startTriangle() {
        String userChoose;
        Triangle triangle;
        List<Triangle> triangleList = new ArrayList<>();
        do {
            String[] triangleToStrings = new String[4];
            boolean continueProcess = true;
            do {
                System.out.print("Enter triangle (<name>,<side>,<side>,<side>): ");
                String userTriangle = scanner.nextLine();
                int counter = 0;
                for (String string : userTriangle.split(",")) {
                    triangleToStrings[counter++] = string;
                }
                try {
                    triangle = new Triangle(triangleToStrings[0], Double.parseDouble(triangleToStrings[1]),
                            Double.parseDouble(triangleToStrings[2]), Double.parseDouble(triangleToStrings[3]));
                    triangle.setSquare();
                    triangleList.add(triangle);
                    continueProcess = false;
                } catch (IllegalArgumentException | ArithmeticException exception) {
                    System.out.println(exception.getMessage());
                } catch (NullPointerException exception) {
                    System.out.println( "Instructions for using this application:\n" +
                                        "1. You must enter the name and sides of the triangle in the given order " +
                                        "(<name>, <side>, <side>, <side>);\n" +
                                        "2. Then, if You wish, You can answer the question \"Do you want continue?\" " +
                                        "in the affirmative and introduce a few more triangles;\n" +
                                        "3. Finally, when You have entered all the desired triangles, answer the question " +
                                        "\"Do you want continue?\" negative and the results will be displayed.");
                }
            } while (continueProcess);
            System.out.print("Do you want add another triangle?\nEnter your choose (y/yes or n/no): ");
            userChoose = scanner.nextLine();
        } while (userChoose.equalsIgnoreCase("y") || userChoose.equalsIgnoreCase("yes"));
        triangleList.sort(Comparator.comparing(Triangle::getSquare).reversed());
        for (Triangle showTriangle : triangleList) {
            System.out.println(showTriangle);
        }
    }

    public void startParser() throws IOException {
        try {
            Parser parser;
            short userChoose;
            System.out.print("FILE PARSER\nMode ¹1 - counter line (enter - 1)\nMode ¹2 - change line (enter - 2)" +
                    "\nWhat mode you choose?\nYour choose: ");
            userChoose = scanner.nextShort();
            scanner.nextLine();
            if (userChoose == 1) {
                String[] parserToStrings = new String[2];
                System.out.print("Enter info to parser (<path to file (example: src/main...)>,<line to count>): ");
                String userInfo = scanner.nextLine();
                int counter = 0;
                for (String string : userInfo.split(",")) {
                    parserToStrings[counter++] = string;
                }
                try {
                    parser = new Parser(parserToStrings[0], parserToStrings[1]);
                    System.out.println("RESULT = " + parser.lineCounter());
                } catch (NullPointerException | FileSystemException | FileNotFoundException exception) {
                    System.out.println(exception.getMessage());
                }
            } else if (userChoose == 2) {
                String[] parserToStrings = new String[3];
                System.out.print("Enter info to parser (<path to file (example: src/main...)>,<line to change>," +
                        "<line to replace>): ");
                String userInfo = scanner.nextLine();
                int counter = 0;
                for (String string : userInfo.split(",")) {
                    parserToStrings[counter++] = string;
                }
                try {
                    parser = new Parser(parserToStrings[0], parserToStrings[1], parserToStrings[2]);
                    System.out.println("RESULT = " + parser.lineChanger());
                } catch (NullPointerException | FileSystemException | FileNotFoundException exception) {
                    System.out.println(exception.getMessage());
                }
            } else {
                System.out.println(("Only enter 1 or 2!"));
            }
        } catch (InputMismatchException exception) {
            System.out.println("Mode must be numeric!");
        }
    }

    public void startNumber() {
        int num;
        try {
            System.out.print("Enter number: ");
            num = scanner.nextInt();
            Number number = new Number(num);
            System.out.print(number.converter());
        } catch (InputMismatchException exception) {
            System.out.println("Number must be numeric!");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void startTicket() {
        String path;
        String mode;
        System.out.print("TICKET\nEnter path to file (example: src/main...): ");
        path = scanner.nextLine();
        System.out.print("Enter mode for you ('Moskow' or 'Piter'): ");
        mode = scanner.nextLine();
        try {
            Ticket ticket = new Ticket(path, mode);
            System.out.println("Your result = " + ticket.ticketCounter());
        } catch (NullPointerException | FileNotFoundException |
                 FileSystemException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Unexpected error!");
        }
    }

    public void startSequence() {
        try {
            int number;
            System.out.print("Please enter number: ");
            number = scanner.nextInt();
            Sequence sequence = new Sequence(number);
            System.out.println("Result = " + sequence.getSequence());
        } catch (InputMismatchException exception) {
            System.out.println("Number must be numeric!");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void startFibonacci() {
        try {
            int min;
            int max;
            System.out.print("Please enter min: ");
            min = scanner.nextInt();
            System.out.print("Please enter max: ");
            max = scanner.nextInt();
            Fibonacci fibonacci = new Fibonacci(min, max);
            System.out.println("Result: " + fibonacci.fibonacci());
        } catch (InputMismatchException exception) {
            System.out.println("Number must be numeric!");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void startPow() {
        try {
            int x;
            int y;
            System.out.print("Please enter x: ");
            x = scanner.nextInt();
            System.out.print("Please enter y: ");
            y = scanner.nextInt();
            Pow pow = new Pow(x, y);
            System.out.println("Your result: " + pow.pow());
        } catch (InputMismatchException exception) {
            System.out.println("Number must be numeric!");
        }
    }

    public void startStorage() {
        try {
            User user;
            short userChoose;
            System.out.print(   "STORAGE\n" +
                                "Mode ¹1 - save new user to 'users' database PostgreSQL (enter - 1)\n" +
                                "Mode ¹2 - update user info in 'users' database PostgreSQL (enter - 2)\n" +
                                "Mode ¹3 - delete user in 'users' database PostgreSQL (enter - 3)\n" +
                                "\nWhat mode you choose?\nYour choose: ");
            userChoose = scanner.nextShort();
            scanner.nextLine();
            if (userChoose == 1) {
                String[] saveUser = new String[4];
                System.out.print("Enter user info (<name>,<surname>,<age>,<email>): ");
                String userInfo = scanner.nextLine();
                int counter = 0;
                for (String string : userInfo.split(",")) {
                    saveUser[counter++] = string;
                }
                try {
                    user = new User(saveUser[0], saveUser[1], Integer.parseInt(saveUser[2]), saveUser[3]);
                    Storage<User> storage = new Storage<>();
                    storage.save("jdbc:postgresql://127.0.0.1:5432/storage", "postgres",
                            "spider1998", user);
                } catch (NullPointerException | IllegalArgumentException | SQLException exception) {
                    System.out.println(exception.getMessage());
                }
            } else if (userChoose == 2) {
                String[] saveUser = new String[4];
                System.out.print("Enter user info (<name_field_for_replacement>,<value_for_replacement>," +
                        "<name_field_for_search>,<value_for_search>): ");
                String userInfo = scanner.nextLine();
                int counter = 0;
                for (String string : userInfo.split(",")) {
                    saveUser[counter++] = string;
                }
                try {
                    user = new User(saveUser[0], saveUser[1], saveUser[2], saveUser[3]);
                    Storage<User> storage = new Storage<>();
                    storage.update("jdbc:postgresql://127.0.0.1:5432/storage", "postgres",
                            "spider1998", user);
                } catch (NullPointerException | IllegalArgumentException | SQLException exception) {
                    System.out.println(exception.getMessage());
                }
            } else if (userChoose == 3) {
                String[] saveUser = new String[2];
                System.out.print("Enter user info (<name_field_for_search>,<value_for_search>): ");
                String userInfo = scanner.nextLine();
                int counter = 0;
                for (String string : userInfo.split(",")) {
                    saveUser[counter++] = string;
                }
                try {
                    user = new User(saveUser[0], saveUser[1]);
                    Storage<User> storage = new Storage<>();
                    storage.delete("jdbc:postgresql://127.0.0.1:5432/storage", "postgres",
                            "spider1998", user);
                } catch (NullPointerException | IllegalArgumentException | SQLException exception) {
                    System.out.println(exception.getMessage());
                }
            } else {
                System.out.println(("Only enter 1, 2 or 3!"));
            }
        } catch (InputMismatchException exception) {
            System.out.println("Mode must be numeric!");
        }
    }
}
