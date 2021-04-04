package org.epam.array.reader;

import org.epam.array.exception.ArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayReaderTest {

    @Test
    public void arrayReaderTest() throws ArrayException {
        String pathToFile = "src\\test\\resources\\arraysData\\arrays2.txt";

        ArrayReader arrayReader = new ArrayReader();
        List<String> currentListOfArrays = arrayReader.readArraysFromFile(pathToFile);

        List<String> expectedListOfArrays = new ArrayList<>();
        expectedListOfArrays.add("1a 2 3");
        expectedListOfArrays.add("-2 3 4");
        expectedListOfArrays.add("t -2 f");

        Assert.assertEquals(expectedListOfArrays,currentListOfArrays);
    }

    @Test(description = "Wrong path",expectedExceptions = ArrayException.class,expectedExceptionsMessageRegExp = "File not found")
    public void arrayReaderThrowsTest() throws ArrayException{
        String pathToFile = "src\\test\\resources\\arraysData\\wrongPath.txt";

        ArrayReader arrayReader = new ArrayReader();
        List<String> currentListOfArrays = arrayReader.readArraysFromFile(pathToFile);
    }
}
