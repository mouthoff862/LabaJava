package main.java.com.solvd.exceptions;

public class EmptyLineException extends Exception {

    //In Zoo.class

    public EmptyLineException() {
    }

    public EmptyLineException(String errorMessage) {
        super(errorMessage);
    }

}
