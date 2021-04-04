package org.epam.array.parser;

import org.epam.array.exception.ArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayParserTest {
    @Test
    public void findCorrectArrayTest() throws ArrayException {
        List<String> listOfArrays = new ArrayList<>();
        listOfArrays.add("a 2 ,3");
        listOfArrays.add("1 2 321 sf");
        listOfArrays.add("3 2 -1");

        ArrayParser arrayParser = new ArrayParser();
        int[] foundArray = arrayParser.findCorrectArray(listOfArrays);
        int[] expectedArray = {3,2,-1};

        Assert.assertEquals(expectedArray,foundArray);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void findCorrectArrayThrowsTest() throws ArrayException{
        List<String> listOfArrays = new ArrayList<>();
        listOfArrays.add("a 2 ,3");
        listOfArrays.add("1 2 321 sf");
        listOfArrays.add("3 2 -1 -");

        ArrayParser arrayParser = new ArrayParser();
        int[] foundArray = arrayParser.findCorrectArray(listOfArrays);
    }
}
