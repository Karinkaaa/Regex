package main.java.birds.my_exceptions;

public class DeletingNonexistentObjectException extends Exception {

    public DeletingNonexistentObjectException(String message) {
        super(message);
    }
}
