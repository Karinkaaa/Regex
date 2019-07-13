package main.java.date_time.exceptions;

public class InvalidFiscalDateFormatException extends Exception {

    public InvalidFiscalDateFormatException() {
    }

    public InvalidFiscalDateFormatException(String message) {
        super(message);
    }

    public InvalidFiscalDateFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFiscalDateFormatException(Throwable cause) {
        super(cause);
    }
}
