package app.io;

import org.springframework.stereotype.Component;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */

@Component
public class ConsoleWriter implements Writer {

    public ConsoleWriter() {
    }

    @Override
    public void println(String content) {
        System.out.println(content);
    }

    @Override
    public void println(String format, Object... args) {
        System.out.println(String.format(format, args));
    }
}
