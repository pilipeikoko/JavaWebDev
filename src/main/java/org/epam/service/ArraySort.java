package org.epam.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.entity.ArrayEntity;

public class ArraySort {
    private final static Logger logger = LogManager.getLogger();

    public void bubbleSort(ArrayEntity arrayEntity) {
        //todo add validator
        int[] array = arrayEntity.getArray();
        int arrayLength = array.length;

        int tempElement;
        for (int i = 0; i < arrayLength; ++i) {
            for (int j = 1; j < arrayLength - i; ++j) {
                if (array[j - 1] > array[j]) {
                    tempElement = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tempElement;
                }
            }
        }
        //todo add logger
    }

    public void gnomeSort(ArrayEntity arrayEntity) {
        //todo add validator
        int[] array = arrayEntity.getArray();
        int arrayLength = array.length;

        int currentIndex = 0;

        while (currentIndex < arrayLength) {
            if (currentIndex == 0) {
                ++currentIndex;
            }
            if (array[currentIndex] >= array[currentIndex - 1]) {
                ++currentIndex;
            } else {
                int temp = array[currentIndex];
                array[currentIndex] = array[currentIndex - 1];
                array[currentIndex - 1] = temp;
                --currentIndex;
            }
        }
        //todo add logger
    }

    public void cocktailSort(ArrayEntity arrayEntity)
    {
        //todo add validator
        int[] array = arrayEntity.getArray();
        boolean elementSwapped = true;

        int startIndex = 0;
        int endIndex = array.length;

        while (elementSwapped)
        {
            elementSwapped = false;

            for (int i = startIndex; i < endIndex - 1; ++i)
            {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    elementSwapped = true;
                }
            }

            if (!elementSwapped)
                break;
            elementSwapped = false;

            endIndex = endIndex - 1;
            for (int i = endIndex - 1; i >= startIndex; i--)
            {
                if (array[i] > array[i + 1])
                {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    elementSwapped = true;
                }
            }

            startIndex = startIndex + 1;
        }
        //todo add logger
    }
}
