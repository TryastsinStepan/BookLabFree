package org.example.Lab6.exception;

public class InvalidBookCountException extends IllegalArgumentException {
    public InvalidBookCountException(String message) {
        super(message);
    }
}
