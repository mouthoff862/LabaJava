package main.java.com.laba.exceptions;

public class CounterException extends Exception {

    // In Zoo.class

    public CounterException() {
    }

    public CounterException(String message, Throwable cause) {
        super(message, cause);
    }

    public CounterException(String message) {
        super(message);
    }
}
