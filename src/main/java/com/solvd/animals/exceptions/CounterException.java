package main.java.com.solvd.animal.exceptions;

public class CounterException extends Exception {

    // In Zoo.class

    public CounterException() {
    }

    public CounterException(String message) {
        super(message);
    }
}
