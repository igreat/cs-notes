package exam2023.problem4;

public class NoIntAvailableException extends Exception {
    public NoIntAvailableException() {
        super("No Integers available");
    }

    public NoIntAvailableException(String message) {
        super(message);
    }
}
