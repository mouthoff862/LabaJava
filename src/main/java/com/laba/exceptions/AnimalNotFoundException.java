package main.java.com.laba.exceptions;

public class AnimalNotFoundException extends Exception {

    //In Lion.class

    public AnimalNotFoundException() {
    }

    public AnimalNotFoundException(String message) {
        super(message);
    }

}
