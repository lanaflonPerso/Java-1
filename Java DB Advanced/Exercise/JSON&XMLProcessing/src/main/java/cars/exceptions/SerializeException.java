package cars.exceptions;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */

public class SerializeException extends RuntimeException {

    public SerializeException(String message) {
        super(message);
    }

    public SerializeException(String message, Throwable cause) {
        super(message, cause);
    }
}
