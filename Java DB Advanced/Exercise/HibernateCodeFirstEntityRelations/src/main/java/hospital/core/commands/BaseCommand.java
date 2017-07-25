package hospital.core.commands;

import hospital.api.Executable;
import hospital.api.InputReader;
import hospital.api.OutputWriter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */
public abstract class BaseCommand implements Executable {

    private OutputWriter writer;
    private InputReader reader;

    @Autowired
    protected OutputWriter getWriter() {
        return this.writer;
    }

    @Autowired
    protected InputReader getReader() {
        return this.reader;
    }
}
