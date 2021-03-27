package org.epam.exception;

public class ArrayEntityException extends Exception{
    public ArrayEntityException(String message) {
        super(message);
    }

    public ArrayEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
