package exam2011.problem2;

public class SortedStringQueueException extends Exception {
    public SortedStringQueueException(String message) {
        super(message);
    }

    public SortedStringQueueException() {
        super("Sorted String queue error");
    }
}