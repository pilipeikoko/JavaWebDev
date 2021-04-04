package org.epam.array.entity;

import org.epam.array.exception.ArrayException;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayEntityTest {

    @Test
    public void createArrayTest() {
        int[] array = {1, 2, 3};
        ArrayEntity arrayEntity = new ArrayEntity(array);

        Assert.assertNotNull(arrayEntity);
    }

    @Test
    public void getElementTest() throws ArrayException {
        int[] array = {10, -2, 5};
        int expectedValue = array[1];

        ArrayEntity arrayEntity = new ArrayEntity(array);

        int currentValue = arrayEntity.getElement(1);

        Assert.assertEquals(expectedValue,currentValue);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void getElementThrowsTest() throws ArrayException {
        int[] array = {10, -2, 5};
        ArrayEntity arrayEntity = new ArrayEntity(array);

        int currentValue = arrayEntity.getElement(-1);
    }

    @Test
    public void getLengthTest() throws ArrayException {
        int[] array = {10, -2, 5};
        ArrayEntity arrayEntity = new ArrayEntity(array);

        int expectedLength = 3;
        int currentLength = arrayEntity.getLength();

        Assert.assertEquals(expectedLength,currentLength);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void getLengthThrowsTest() throws ArrayException {
        int[] array = {};
        ArrayEntity arrayEntity = new ArrayEntity(array);
        int currentLength = arrayEntity.getLength();
    }




}
