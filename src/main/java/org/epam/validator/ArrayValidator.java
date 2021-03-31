package org.epam.validator;

import org.epam.entity.ArrayEntity;

public class ArrayValidator {

    private static final String CORRECT_PATTERN = "[0-9\\s\\-]*";

    public static boolean validateString(String string) {
        boolean isStringCorrect = string.matches(CORRECT_PATTERN);

        return isStringCorrect;
    }

    public static boolean validateArray(ArrayEntity array) {
        boolean isValid = array != null && array.getArray().length != 0;

        return isValid;
    }
}
