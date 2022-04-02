package main.java.com.solvd.animal.exceptions;

public class AnimalNotFoundException extends Exception {

    //In Lion.class

    public AnimalNotFoundException() {
    }

    public AnimalNotFoundException(String message) {
        super(message);
    }

}
