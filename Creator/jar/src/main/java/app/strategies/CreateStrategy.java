package app.strategies;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */
public interface CreateStrategy {
    String ROOT_PATH = new File(".").getAbsolutePath().replace(".", "") + "src\\main\\java\\";
    String RESOURCES = new File(".").getAbsolutePath().replace(".", "") + "src\\main\\resources\\";

    void execute(List<Class<?>> classes, String springBootApplicationFilePackageName) throws IOException, InvocationTargetException, ClassNotFoundException, InstantiationException, NoSuchMethodException, IllegalAccessException;
}
