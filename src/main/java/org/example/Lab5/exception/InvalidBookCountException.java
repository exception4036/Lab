package org.example.Lab5.exception;

public class InvalidBookCountException extends IllegalArgumentException {
    public InvalidBookCountException(String message) {
        super(message);
    }
}
