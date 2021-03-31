package org.epam.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.entity.ArrayEntity;
import org.epam.exception.ArrayException;
import org.epam.validator.ArrayValidator;

import java.util.stream.IntStream;
//todo замена элементов массива по условию
public class ArraySearch {
    private static final Logger logger = LogManager.getLogger();

    public int findMinimalElement(ArrayEntity arrayEntity) throws ArrayException {

        if (!ArrayValidator.validateArray(arrayEntity)) {
            throw new ArrayException("Empty or null array");
        }

        int minimalElement = arrayEntity.getElement(0);

        for (int i = 1; i < arrayEntity.getLength(); ++i) {
            int currentElement = arrayEntity.getElement(i);

            if (currentElement < minimalElement) {
                minimalElement = currentElement;
            }
        }

        logger.info("Minimal element is " + minimalElement);
        return minimalElement;
    }

    public int findMinimalElementByStream(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.validateArray(array)) {
            throw new ArrayException("Empty or null array");
        }

        int minimalElement = array.getElement(0);
        IntStream intStream = IntStream.of(array.getArray());

        minimalElement = intStream.reduce(minimalElement,
                (x, y) -> {
                    if (y < x) {
                        return y;
                    } else
                        return x;
                });

        //todo add logger
        return minimalElement;
    }

    public int findMaximalElement(ArrayEntity array) throws ArrayException {
        if (!ArrayValidator.validateArray(array)) {
            throw new ArrayException("Empty or null array");
        }

        int maximalElement = array.getElement(0);

        for (int i = 1; i < array.getLength(); ++i) {
            int currentElement = array.getElement(i);

            if (currentElement < maximalElement) {
                maximalElement = currentElement;
            }
        }

        logger.info("Maximal element is " + maximalElement);
        return maximalElement;
    }

    public int findMaximalElementByStream(ArrayEntity array) throws ArrayException {
        if (!ArrayValidator.validateArray(array)) {
            throw new ArrayException("Empty or null array");
        }

        int maximalElement = array.getElement(0);
        IntStream intStream = IntStream.of(array.getArray());

        maximalElement = intStream.reduce(maximalElement,
                (x, y) -> {
                    if (y > x) {
                        return y;
                    } else
                        return x;
                });
        //todo add logger

        return maximalElement;
    }

    public double findAverage(ArrayEntity array) throws ArrayException {
        int sum = findSum(array);
        int size = array.getLength();

        double averageValue = (double) sum / size;

        logger.info("Average value is " + averageValue);
        return averageValue;
    }

    public double findAverageByStream(ArrayEntity array) throws ArrayException {
        int sum = findSumByStream(array);
        int size = array.getLength();

        double averageValue = (double) sum / size;

        logger.info("Average value is " + averageValue);
        return averageValue;
    }

    public int findSum(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.validateArray(array)) {
            throw new ArrayException("Empty or null array");
        }

        int sum = 0;
        for (int i = 0; i < array.getLength(); i++) {
            int element = array.getElement(i);
            sum += element;
        }
        logger.info("Sum of array element is " + sum);
        return sum;
    }

    public int findSumByStream(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.validateArray(array)) {
            throw new ArrayException("Empty or null array");
        }

        int sum = IntStream.of(array.getArray())
                .reduce(Integer::sum)
                .getAsInt();
        //todo add logger

        return sum;
    }

    public int findAmountOfPositiveNumbers(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.validateArray(array)) {
            throw new ArrayException("Empty or null array");
        }

        int amountOfPositiveNumbers = 0;
        int length = array.getLength();

        for (int i = 0; i < length; ++i) {
            int currentElementValue = array.getElement(i);

            if (currentElementValue > 0) {
                ++amountOfPositiveNumbers;
            }
        }
        return amountOfPositiveNumbers;
    }

    public int findAmountOfNegativeNumbers(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.validateArray(array)) {
            throw new ArrayException("Empty or null array");
        }

        int amountOfNegativeNumbers = 0;
        int length = array.getLength();

        for (int i = 0; i < length; ++i) {
            int currentElementValue = array.getElement(i);

            if (currentElementValue < 0) {
                ++amountOfNegativeNumbers;
            }
        }
        return amountOfNegativeNumbers;
    }

    public int findAmountOfPositiveNumbersByStream(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.validateArray(array)) {
            throw new ArrayException("Empty or null array");
        }

        int amountOfPositiveNumbers = (int) IntStream.of(array.getArray()).
                filter(x -> x > 0).count();

        //todo add logger
        return amountOfPositiveNumbers;
    }

    public int findAmountOfNegativeNumbersByStream(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.validateArray(array)) {
            throw new ArrayException("Empty or null array");
        }

        int amountOfNegativeNumbers = (int) IntStream.of(array.getArray()).
                filter(x -> x < 0).count();
        //todo add logger
        return amountOfNegativeNumbers;
    }
}
