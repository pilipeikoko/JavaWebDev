package org.epam.array.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayValidatorTest {
    @Test
    public void stringValidatorTest(){
        String stringArray = "3 2 -2";

        boolean isStringCorrect = ArrayValidator.isArrayStringValid(stringArray);

        Assert.assertTrue(isStringCorrect);
    }

    @Test
    public void stringValidatorIncorrectTest(){
        String stringArray = "3 2 -a";

        boolean isStringCorrect = ArrayValidator.isArrayStringValid(stringArray);

        Assert.assertFalse(isStringCorrect);
    }
}
