package main.ticket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ticket {
    private File file;
    private String indicator;

    public Ticket(String pathToFile, String indicator) throws FileNotFoundException, FileSystemException {
        if (pathToFile.isEmpty() || indicator.isEmpty()) {
            throw new NullPointerException("Name of file or indicator can't be empty!");
        } else {
            file = new File(String.valueOf(Paths.get(pathToFile)));
            if (!file.isFile()) throw new FileNotFoundException("File with this name not found!");
            if (isFileEmpty()) throw new FileSystemException("File empty");
            if (!indicator.equals("Moskow") && !indicator.equals("Piter"))
                throw new IllegalArgumentException("Indicator can be only 'Moskow' or 'Piter'!");
            this.indicator = indicator;
        }
    }

    private boolean isFileEmpty() {
        return file.length() == 0;
    }

    public int ticketCounter() throws IOException {
        if (indicator.equals("Moskow")) return Moskow();
        else return Piter();
    }

    private String fileReader() throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

    private boolean selectionForMoskow(int x) {
        int[] array = new int[6];
        array[0] = x / 100000;
        array[1] = (x / 10000) % 10;
        array[2] = (x / 1000) % 10 % 10;
        array[3] = (x / 100) % 10 % 10 % 10;
        array[4] = (x / 10) % 10 % 10 % 10 % 10;
        array[5] = x % 10 % 10 % 10 % 10;
        return array[0] + array[1] + array[2] == array[3] + array[4] + array[5];
    }

    private boolean selectionForPiter(int x) {
        int[] array = new int[6];
        int sum1 = 0;
        int sum2 = 0;
        array[0] = x / 100000;
        array[1] = (x / 10000) % 10;
        array[2] = (x / 1000) % 10 % 10;
        array[3] = (x / 100) % 10 % 10 % 10;
        array[4] = (x / 10) % 10 % 10 % 10 % 10;
        array[5] = x % 10 % 10 % 10 % 10;
        for (int i : array) {
            if (i % 2 == 0) sum1 = sum1 + i;
            else sum2 = sum2 + i;
        }
        return sum1 == sum2;
    }

    private int Moskow() throws IOException {
        String[] numbers = fileReader().split("\\r?\\n|\\r");
        int counter = 0;
        for (String string : numbers) if (selectionForMoskow(Integer.parseInt(string))) counter++;
        return counter;
    }

    private int Piter() throws IOException {
        String[] numbers = fileReader().split("\\r?\\n|\\r");
        int counter = 0;
        for (String string : numbers) if (selectionForPiter(Integer.parseInt(string))) counter++;
        return counter;
    }
}
