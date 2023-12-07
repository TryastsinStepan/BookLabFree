package org.example.Lab6.exception;

public class InvalidBookPriceException extends IllegalArgumentException {
    public InvalidBookPriceException(String message) {
        super(message);
    }
}