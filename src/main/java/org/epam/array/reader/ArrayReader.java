package org.epam.array.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.array.exception.ArrayException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readArraysFromFile(String path) throws ArrayException {

        List<String> listOfArrays = new ArrayList<>();

        File file = new File(path);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String array = scanner.nextLine();
                listOfArrays.add(array);
            }

            scanner.close();
        } catch(FileNotFoundException exception){
            throw new ArrayException("File not found");
        }

        return listOfArrays;
    }
}
