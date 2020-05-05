package com.bridgelabz.greetingapp.exception;

public class GreetingAppException extends Exception {
    public enum ExceptionType {
        INVALID_ID
    }

    ExceptionType type;

    public GreetingAppException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
