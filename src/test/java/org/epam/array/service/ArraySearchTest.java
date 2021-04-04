package org.epam.array.service;

import org.epam.array.entity.ArrayEntity;
import org.epam.array.exception.ArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraySearchTest {

    @Test
    public void minimalElementTest() throws ArrayException {
        int[] array = {5, 10, -4, 8};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        int foundMinimalElement = arraySearch.minimalElement(arrayEntity);
        int expectedMinimalElement = -4;

        Assert.assertEquals(foundMinimalElement, expectedMinimalElement);
    }

    @Test
    public void minimalElementByStreamTest() throws ArrayException {
        int[] array = {5, 10, -4, 8, -10};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        int foundMinimalElement = arraySearch.minimalElementByStream(arrayEntity);
        int expectedMinimalElement = -10;

        Assert.assertEquals(foundMinimalElement, expectedMinimalElement);
    }

    @Test
    public void maximalElementTest() throws ArrayException {
        int[] array = {5, 10, -4, 8};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        int foundMaximalElement = arraySearch.maximalElement(arrayEntity);
        int expectedMaximalElement = 10;

        Assert.assertEquals(foundMaximalElement, expectedMaximalElement);
    }

    @Test
    public void maximalElementByStreamTest() throws ArrayException {
        int[] array = {5, 10, -4, 8, -10, 93};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        int foundMaximalElement = arraySearch.maximalElementByStream(arrayEntity);
        int expectedMaximalElement = 93;

        Assert.assertEquals(foundMaximalElement, expectedMaximalElement);
    }

    @Test
    public void averageTest() throws ArrayException {
        int[] array = {5, 10, -4, 8, -10, 93};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        double actualAverage = arraySearch.average(arrayEntity);
        double expectedAverage = 17d;

        Assert.assertEquals(expectedAverage, actualAverage);
    }

    @Test
    public void averageByStreamTest() throws ArrayException {
        int[] array = {5, 10, -4, 8, -10, 5};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        double actualAverage = arraySearch.averageByStream(arrayEntity);
        double expectedAverage = (14 / 6d);

        Assert.assertEquals(expectedAverage, actualAverage);
    }

    @Test
    public void sumTest() throws ArrayException {
        int[] array = {5, 10, -4, 8, -10, 5};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        int actualSum = arraySearch.sum(arrayEntity);
        int expectedSum = 14;

        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void sumByStreamTest() throws ArrayException {
        int[] array = {1, 2, 4, 6, -5};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        int actualSum = arraySearch.sumByStream(arrayEntity);
        int expectedSum = 8;

        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void amountOfPositiveNumbersTest() throws ArrayException {
        int[] array = {1, 2, 4, 6, -5};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        int actualAmountOfPositiveNumbers = arraySearch.amountOfPositiveNumbers(arrayEntity);
        int expectedAmountOfPositiveNumbers = 4;

        Assert.assertEquals(actualAmountOfPositiveNumbers, expectedAmountOfPositiveNumbers);
    }

    @Test
    public void amountOfPositiveNumbersByStreamTest() throws ArrayException {
        int[] array = {1, 2, -4, 6, -5};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        int actualAmountOfPositiveNumbers = arraySearch.amountOfPositiveNumbersByStream(arrayEntity);
        int expectedAmountOfPositiveNumbers = 3;

        Assert.assertEquals(actualAmountOfPositiveNumbers, expectedAmountOfPositiveNumbers);
    }

    @Test
    public void amountOfNegativeNumbersTest() throws ArrayException {
        int[] array = {1, -2, -4, 6, -5};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        int actualAmountOfNegativeNumbers = arraySearch.amountOfNegativeNumbers(arrayEntity);
        int expectedAmountOfNegativeNumbers = 3;

        Assert.assertEquals(actualAmountOfNegativeNumbers, expectedAmountOfNegativeNumbers);
    }

    @Test
    public void amountOfNegativeNumbersByStreamTest() throws ArrayException {
        int[] array = {1, -2, -4, -6, -5, 0};

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArraySearch arraySearch = new ArraySearch();

        int actualAmountOfNegativeNumbers = arraySearch.amountOfNegativeNumbersByStream(arrayEntity);
        int expectedAmountOfNegativeNumbers = 4;

        Assert.assertEquals(actualAmountOfNegativeNumbers, expectedAmountOfNegativeNumbers);
    }
}
