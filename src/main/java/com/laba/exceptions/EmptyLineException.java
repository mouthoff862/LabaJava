package main.java.com.laba.exceptions;

public class EmptyLineException extends Exception {

    //In Zoo.class

    public EmptyLineException() {
    }

    public EmptyLineException(String errorMessage) {
        super(errorMessage);
    }

}
