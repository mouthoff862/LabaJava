package main.java.com.laba.exceptions;

public class BooleanException extends Exception{

    // In Zookeeper.class

    public BooleanException() {
    }

    public BooleanException(String message) {
        super(message);
    }

    public BooleanException(String message, Throwable cause) {
        super(message, cause);
    }

}
