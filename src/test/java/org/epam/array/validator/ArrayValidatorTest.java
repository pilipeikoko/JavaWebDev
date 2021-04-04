package org.epam.array.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.validation.Validator;

public class ArrayValidatorTest {
    @Test
    public void stringValidatorTest(){
        String stringArray = "3 2 -2";

        boolean isStringCorrect = ArrayValidator.validateString(stringArray);

        Assert.assertTrue(isStringCorrect);
    }

    @Test
    public void stringValidatorIncorrectTest(){
        String stringArray = "3 2 -a";

        boolean isStringCorrect = ArrayValidator.validateString(stringArray);

        Assert.assertFalse(isStringCorrect);
    }
}
