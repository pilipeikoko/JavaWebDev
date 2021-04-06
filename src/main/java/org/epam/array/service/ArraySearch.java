package org.epam.array.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.array.exception.ArrayException;
import org.epam.array.entity.ArrayEntity;
import org.epam.array.validator.ArrayValidator;

import java.util.stream.IntStream;

public class ArraySearch {
    private static final Logger LOGGER = LogManager.getLogger();

    public int minimalElement(ArrayEntity arrayEntity) throws ArrayException {

        if (!ArrayValidator.isArrayEntityValid(arrayEntity)) {
            throw new ArrayException("Empty or null array");
        }

        int minimalElement = arrayEntity.getElement(0);

        for (int i = 1; i < arrayEntity.getLength(); ++i) {
            int currentElement = arrayEntity.getElement(i);

            if (currentElement < minimalElement) {
                minimalElement = currentElement;
            }
        }

        LOGGER.info("Minimal element is " + minimalElement);
        return minimalElement;
    }

    public int minimalElementByStream(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.isArrayEntityValid(array)) {
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

        LOGGER.info("Minimal element is " + minimalElement);

        return minimalElement;
    }

    public int maximalElement(ArrayEntity array) throws ArrayException {
        if (!ArrayValidator.isArrayEntityValid(array)) {
            throw new ArrayException("Empty or null array");
        }

        int maximalElement = array.getElement(0);

        for (int i = 1; i < array.getLength(); ++i) {
            int currentElement = array.getElement(i);

            if (currentElement > maximalElement) {
                maximalElement = currentElement;
            }
        }

        return maximalElement;
    }

    public int maximalElementByStream(ArrayEntity array) throws ArrayException {
        if (!ArrayValidator.isArrayEntityValid(array)) {
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
        LOGGER.info("Maximal element is " + maximalElement);

        return maximalElement;
    }

    public double average(ArrayEntity array) throws ArrayException {
        int sum = sum(array);
        int size = array.getLength();

        double averageValue = (double) sum / size;

        LOGGER.info("Average value is " + averageValue);
        return averageValue;
    }

    public double averageByStream(ArrayEntity array) throws ArrayException {
        int sum = sumByStream(array);
        int size = array.getLength();

        double averageValue = (double) sum / size;

        LOGGER.info("Average value is " + averageValue);
        return averageValue;
    }

    public int sum(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.isArrayEntityValid(array)) {
            throw new ArrayException("Empty or null array");
        }

        int sum = 0;
        for (int i = 0; i < array.getLength(); i++) {
            int element = array.getElement(i);
            sum += element;
        }
        LOGGER.info("Sum of array elements is " + sum);
        return sum;
    }

    public int sumByStream(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.isArrayEntityValid(array)) {
            throw new ArrayException("Empty or null array");
        }

        int sum = IntStream.of(array.getArray())
                .reduce(Integer::sum)
                .getAsInt();
        LOGGER.info("Sum of array elements is " + sum);

        return sum;
    }

    public int amountOfPositiveNumbers(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.isArrayEntityValid(array)) {
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

        LOGGER.info("Amount of positive numbers is " + amountOfPositiveNumbers);

        return amountOfPositiveNumbers;
    }

    public int amountOfPositiveNumbersByStream(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.isArrayEntityValid(array)) {
            throw new ArrayException("Empty or null array");
        }

        int amountOfPositiveNumbers = (int) IntStream.of(array.getArray()).
                filter(x -> x > 0).count();

        LOGGER.info("Amount of positive numbers is " + amountOfPositiveNumbers);

        return amountOfPositiveNumbers;
    }

    public int amountOfNegativeNumbers(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.isArrayEntityValid(array)) {
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

        LOGGER.info("Amount of negative numbers is " + amountOfNegativeNumbers);

        return amountOfNegativeNumbers;
    }

    public int amountOfNegativeNumbersByStream(ArrayEntity array) throws ArrayException {

        if (!ArrayValidator.isArrayEntityValid(array)) {
            throw new ArrayException("Empty or null array");
        }

        int amountOfNegativeNumbers = (int) IntStream.of(array.getArray()).
                filter(x -> x < 0).count();

        LOGGER.info("Amount of negative numbers is " + amountOfNegativeNumbers);

        return amountOfNegativeNumbers;
    }
}
