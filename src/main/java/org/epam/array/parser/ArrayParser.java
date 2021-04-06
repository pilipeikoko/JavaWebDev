package org.epam.array.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.array.exception.ArrayException;
import org.epam.array.validator.ArrayValidator;

import java.util.ArrayList;
import java.util.List;

public class ArrayParser {
    private static final Logger LOGGER = LogManager.getLogger();

    public int[] findCorrectArray(List<String> listOfArrays) throws ArrayException {
        List<Integer> correctArray = new ArrayList<>();

        int indexOfCurrentElement = 0;

        do {
            String currentArray = listOfArrays.get(indexOfCurrentElement);
            if (ArrayValidator.isArrayStringValid(currentArray)) {
                String[] splittedArray = currentArray.split(" ");

                for (String value : splittedArray) {
                    Integer intValue = Integer.parseInt(value);
                    correctArray.add(intValue);
                }
                break;
            }
            ++indexOfCurrentElement;
        } while (indexOfCurrentElement < listOfArrays.size());

        if (correctArray.isEmpty()) {
            throw new ArrayException("Correct array not found");
        }

        LOGGER.info("Correct array found. Index: " + indexOfCurrentElement);

        int[] result = correctArray.
                stream().
                mapToInt(i -> i).
                toArray();

        return result;
    }
}
