package p02vehiclesExtension;

public class ValidationException extends Exception {

    ValidationException(String message) {
        super(message);
    }

    ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}