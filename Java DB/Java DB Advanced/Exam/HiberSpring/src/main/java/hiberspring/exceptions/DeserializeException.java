package hiberspring.exceptions;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */

public class DeserializeException extends RuntimeException {

    public DeserializeException(String message) {
        super(message);
    }

    public DeserializeException(String message, Throwable cause) {
        super(message, cause);
    }
}
