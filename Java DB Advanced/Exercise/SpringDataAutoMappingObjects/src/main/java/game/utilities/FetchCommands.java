package game.utilities;

import game.annotations.Command;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hristo Skipernov on 29/07/2017.
 */

@Component
public class FetchCommands {
    private static final String CONTROLLERS_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\SpringDataAutoMappingObjects\\src\\main\\java\\game\\controllers";
    private final Map<Class<?>, Map<String, Method>> commands = new HashMap<>();

    public FetchCommands() throws ClassNotFoundException {
        this.initCommands(new File(CONTROLLERS_PATH).listFiles());
    }

    public Map<Class<?>, Map<String, Method>> getCommands() {
        return this.commands;
    }

    private void initCommands(File[] files) throws ClassNotFoundException {
        String classPath;
        for (File file : files) {
            if (file.isDirectory()) {
                initCommands(file.listFiles());
            } else {
                if (file.getName().endsWith(".java")) {
                    classPath = file.getPath().split("\\\\src\\\\main\\\\java\\\\")[1].replace("\\", ".").replace(".java", "");
                    Class<?> clazz = Class.forName(classPath);
                    Method[] declaredMethods = clazz.getDeclaredMethods();
                    Map<String, Method> methods = new HashMap<>();
                    for (Method method : declaredMethods) {
                        if (method.isAnnotationPresent(Command.class)) {
                            methods.putIfAbsent(method.getAnnotation(Command.class).name(), method);
                        }
                    }
                    this.commands.putIfAbsent(clazz, methods);
                }
            }
        }
    }
}