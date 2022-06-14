package main.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Parser {
    private File file;
    private String toSearch;
    private String toChange;
    private String toReplace;

    public Parser(String pathToFile, String toSearch) throws FileNotFoundException, FileSystemException {
        if (pathToFile.isEmpty() || toSearch.isEmpty()) {
            throw new NullPointerException("Name of file (or path to file) or string to search can't be empty!");
        } else {
            file = new File(String.valueOf(Paths.get(pathToFile)));
            if (!file.isFile()) throw new FileNotFoundException("File not found!");
            if (isFileEmpty()) throw new FileSystemException("File is empty!");
            this.toSearch = toSearch;
        }
    }

    public Parser(String pathToFile, String toChange, String toReplace) throws FileNotFoundException,
            FileSystemException {
        if (pathToFile.isEmpty() || toChange.isEmpty()) {
            throw new NullPointerException("Name of file (or path to file) or string to search can't be empty!");
        } else {
            file = new File(String.valueOf(Paths.get(pathToFile)));
            if (!file.isFile()) throw new FileNotFoundException("File not found!");
            if (isFileEmpty()) throw new FileSystemException("File is empty!");
            this.toChange = toChange;
            this.toReplace = toReplace;
        }
    }

    private boolean isFileEmpty() {
        return file.length() == 0;
    }

    private String fileReader() throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

    public int lineCounter() throws IOException {
        return (int) Arrays.stream(fileReader().split("\\n")).filter(word -> word.contains(toSearch)).count();
    }

    public boolean lineChanger() throws IOException {
        Files.write(file.toPath(), fileReader().replaceAll(toChange, toReplace).getBytes());
        return !fileReader().contains(toChange);
    }
}
