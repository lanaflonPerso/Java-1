package photography.io;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */
public interface Writer {

    void println(String content);

    void println(String format, Object... args);
}
