package org.epam.array.creator;

import org.epam.array.entity.ArrayEntity;
import org.epam.array.exception.ArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayCreatorTest {

    @Test
    public void arrayEntityCreateFromFileTest() throws ArrayException {
        String pathToFile = "src\\test\\resources\\arraysData\\arrays1.txt";
        ArrayCreator arrayCreator = new ArrayCreator();

        ArrayEntity arrayEntity = arrayCreator.createArrayEntityFromFile(pathToFile);
        int[] expectedArray = {-3, 231, 3, 2};
        int[] currentArray = arrayEntity.getArray();

        Assert.assertEquals(expectedArray, currentArray);
    }
}
