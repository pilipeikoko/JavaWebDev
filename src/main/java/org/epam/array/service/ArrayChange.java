package org.epam.array.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.array.entity.ArrayEntity;
import org.epam.array.exception.ArrayException;
import org.epam.array.validator.ArrayValidator;

public class ArrayChange {
    private static final Logger LOGGER = LogManager.getLogger();

    public void changePrimeElementsToNewValue(ArrayEntity arrayEntity, int newValue) throws ArrayException {
        if (!ArrayValidator.validateArray(arrayEntity)) {
            throw new ArrayException("Empty or null array");
        }

        int amountOfChangedElements = 0;
        int length = arrayEntity.getLength();

        for (int i = 0; i < length; ++i) {
            int currentElement = arrayEntity.getElement(i);
            if (isPrime(currentElement)) {
                ++amountOfChangedElements;
                arrayEntity.setElement(i, newValue);
            }
        }

        LOGGER.info("Changed " + amountOfChangedElements + " elements to " + newValue);
    }

    private boolean isPrime(int number) {
        int currentIndex = 2;
        boolean flag = true;

        while (currentIndex <= number / 2) {

            if (number % currentIndex == 0) {
                flag = false;
                break;
            }

            ++currentIndex;
        }

        return flag;
    }

}
