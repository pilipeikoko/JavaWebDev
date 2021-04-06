package org.epam.array.creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.array.entity.ArrayEntity;
import org.epam.array.exception.ArrayException;
import org.epam.array.parser.ArrayParser;
import org.epam.array.reader.ArrayReader;
import org.epam.array.validator.ArrayValidator;

import java.util.List;

public class ArrayCreator {
    private static final Logger LOGGER = LogManager.getLogger();

    public ArrayEntity createArrayEntityFromFile(String pathToFile) throws ArrayException {
        ArrayReader arrayReader = new ArrayReader();
        List<String> listOfArrays = arrayReader.readArraysFromFile(pathToFile);

        ArrayParser arrayParser = new ArrayParser();
        int[] correctArray = arrayParser.findCorrectArray(listOfArrays);
        ArrayEntity correctArrayEntity = new ArrayEntity(correctArray);

        LOGGER.info("Array created: " + correctArrayEntity.toString());
        return correctArrayEntity;
    }
}
