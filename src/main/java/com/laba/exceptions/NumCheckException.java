package main.java.com.laba.exceptions;

public class NumCheckException extends Exception {

    public NumCheckException(String message) {
        super(message);
    }

    public NumCheckException (String message, Throwable cause) {
        super(message, cause);
    }
}
