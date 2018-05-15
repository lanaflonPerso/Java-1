package hospital.io;

import hospital.api.OutputWriter;
import org.springframework.stereotype.Component;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */

@Component
public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
