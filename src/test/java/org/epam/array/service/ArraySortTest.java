package org.epam.array.service;

import org.epam.array.entity.ArrayEntity;
import org.epam.array.exception.ArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraySortTest {

    @Test
    public void bubbleSortTest() throws ArrayException {
        int[] arrayToSort = {1,-2,5,7,-1,10,12};

        ArrayEntity arrayEntity = new ArrayEntity(arrayToSort);

        ArraySort arraySort = new ArraySort();
        arraySort.bubbleSort(arrayEntity);

        int[] expectedArray = {-2,-1,1,5,7,10,12};
        int[] actualArray = arrayEntity.getArray();

        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void gnomeSortTest() throws ArrayException {
        int[] arrayToSort = {1,-2,5,7,-1,10,12};

        ArrayEntity arrayEntity = new ArrayEntity(arrayToSort);

        ArraySort arraySort = new ArraySort();
        arraySort.gnomeSort(arrayEntity);

        int[] expectedArray = {-2,-1,1,5,7,10,12};
        int[] actualArray = arrayEntity.getArray();

        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void cocktailSortTest() throws ArrayException {
        int[] arrayToSort = {1,-2,5,7,-1,10,12};

        ArrayEntity arrayEntity = new ArrayEntity(arrayToSort);

        ArraySort arraySort = new ArraySort();
        arraySort.cocktailSort(arrayEntity);

        int[] expectedArray = {-2,-1,1,5,7,10,12};
        int[] actualArray = arrayEntity.getArray();

        Assert.assertEquals(expectedArray,actualArray);
    }
}
