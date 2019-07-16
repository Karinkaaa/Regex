package main.java.web.exceptions;

public class ApplicationLogicException extends Exception {

    public ApplicationLogicException() {
    }

    public ApplicationLogicException(String message) {
        super(message);
    }

    public ApplicationLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationLogicException(Throwable cause) {
        super(cause);
    }
}
