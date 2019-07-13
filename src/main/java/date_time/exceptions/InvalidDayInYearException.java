package main.java.date_time.exceptions;

public class InvalidDayInYearException extends Exception {

    public InvalidDayInYearException() {
    }

    public InvalidDayInYearException(String message) {
        super(message);
    }

    public InvalidDayInYearException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDayInYearException(Throwable cause) {
        super(cause);
    }
}
