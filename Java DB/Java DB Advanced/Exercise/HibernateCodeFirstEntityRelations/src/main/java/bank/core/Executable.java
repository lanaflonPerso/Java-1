package bank.core;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */
public interface Executable {
    String execute() throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException;
}
