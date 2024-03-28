package utilities;

/**
 * An exception that is thrown when attempting to perform an operation on an empty queue.
 */
public class EmptyQueueException extends Exception {

    // Constructor without a detail message
    public EmptyQueueException() {
        super();
    }

    // Constructor with a detail message
    public EmptyQueueException(String message) {
        super(message);
    }
}