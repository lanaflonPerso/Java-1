package photographers.exceptions;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */

public class InvalidDataProvidedException extends RuntimeException {

    public InvalidDataProvidedException(String message) {
        super(message);
    }
}
