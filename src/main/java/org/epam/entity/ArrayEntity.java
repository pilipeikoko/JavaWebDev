package org.epam.entity;

import org.epam.exception.ArrayEntityException;

import java.util.Arrays;

public class ArrayEntity {
    int[] array;

    public ArrayEntity(){

    }

    public ArrayEntity(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public int getElement(int index) throws ArrayEntityException {
        if (index > array.length || index < 0) {
            throw new ArrayEntityException("Out of range exception");
        }
        return array[index];
    }

    //todo move to service
    public void changeElement(int index, int newValue) throws ArrayEntityException {
        if (index > array.length || index < 0) {
            throw new ArrayEntityException("Out of range exception");
        }
        array[index] = newValue;
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

        ArrayEntity guest = (ArrayEntity) obj;
        
        return id == guest.id
                && (firstName == guest.firstName
                || (firstName != null && firstName.equals(guest.getFirstName())))
                && (lastName == guest.lastName
                || (lastName != null && lastName .equals(guest.getLastName())));
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        for (int element : array) {
            string.append(element).append(" ");
        }
        return string.toString();
    }
}
