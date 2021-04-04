package org.epam.array.entity;

import org.epam.array.exception.ArrayException;

import java.util.Arrays;

public class ArrayEntity {

    private int[] array;

    public ArrayEntity(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public int getElement(int index) throws ArrayException {
        if (index >= array.length || index < 0) {
            throw new ArrayException("Out of range exception. Index: " + index);
        }
        int currentElement = array[index];
        return currentElement;
    }

    public void setElement(int index, int newValue) throws ArrayException {
        if (index > array.length || index < 0) {
            throw new ArrayException("Out of range exception");
        }
        array[index] = newValue;
    }

    public int getLength() throws ArrayException {
        if (this.array.length == 0) {
            throw new ArrayException("Array is empty");
        }
        int size = array.length;

        return size;
    }

    @Override
    public int hashCode() {
        if (array == null)
            return 0;

        int result = 1;
        for (int element : array)
            result = 31 * result + element;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ArrayEntity arrayEntity = (ArrayEntity) obj;

        boolean isEqual = Arrays.equals(arrayEntity.array, this.array);

        return isEqual;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int element : array) {
            stringBuilder.append(element).append(" ");
        }
        String result = stringBuilder.toString();
        return result;
    }
}
