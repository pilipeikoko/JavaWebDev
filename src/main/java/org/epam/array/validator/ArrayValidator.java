package org.epam.array.validator;

import org.epam.array.entity.ArrayEntity;

public class ArrayValidator {

    private static final String CORRECT_PATTERN = "(-?\\d+ ?)+";

    public static boolean validateString(String stringOfNumbers) {
        boolean isStringValid = stringOfNumbers.matches(CORRECT_PATTERN);

        return isStringValid;
    }

    public static boolean validateArray(ArrayEntity array) {
        boolean isArrayValid = array != null && array.getArray().length != 0;

        return isArrayValid;
    }
    //todo file path validator?
}
