package org.epam.array.service;

import org.epam.array.entity.ArrayEntity;
import org.epam.array.exception.ArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayChangeTest {

    @Test
    public void changePrimeElementsToNewValueTest() throws ArrayException {
        int[] array = {7, 3, 4, 10, 13, 8, 5};
        int newValue = 2;

        ArrayEntity arrayEntity = new ArrayEntity(array);

        ArrayChange arrayChange = new ArrayChange();

        arrayChange.changePrimeElementsToNewValue(arrayEntity, newValue);

        int[] expectedArray = {2, 2, 4, 10, 2, 8, 2};
        int[] actualArray = arrayEntity.getArray();

        Assert.assertEquals(expectedArray,actualArray);


    }
}
