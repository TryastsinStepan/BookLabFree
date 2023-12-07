package org.example.Lab5.exception;

public class InvalidBookPriceException extends IllegalArgumentException {
    public InvalidBookPriceException(String message) {
        super(message);
    }
}