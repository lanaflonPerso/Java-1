package app.utilities;

import app.enums.StrategyType;
import app.factories.StrategyFactory;
import app.strategies.CreateStrategy;

import javax.persistence.Entity;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static app.strategies.CreateStrategy.ROOT_PATH;

/**
 * Created by Hristo Skipernov on 18/05/2017.
 */

public final class Creator {
    private static final String STRATEGY_PATH = "app.strategies.";

    private Creator() {
    }

    @SuppressWarnings("unchecked")
    public static void create(StrategyType strategyType, Class<?> mainClass) {
        String springBootApplicationFilePackage = mainClass.getPackage().getName().replace(".", "\\");
        String springBootApplicationFilePath = ROOT_PATH + springBootApplicationFilePackage;

        List<Class<?>> files = new ArrayList();

        try {
            List<Class<?>> classes = getFilesClasses(new File(springBootApplicationFilePath).listFiles(), files);
            String strategyClassPath = STRATEGY_PATH + strategyType.toString();
            CreateStrategy strategy = StrategyFactory.getStrategy(strategyClassPath);
            strategy.execute(classes, springBootApplicationFilePackage);

        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static List<Class<?>> getFilesClasses(File[] files, List<Class<?>> classes) throws IOException, ClassNotFoundException {
        String classPath;
        for (File file : files) {
            if (file.isDirectory()) {
                getFilesClasses(file.listFiles(), classes);
            } else {
                if (file.getName().endsWith(".java")) {
                    classPath = file.getPath().split("\\\\src\\\\main\\\\java\\\\")[1].replace("\\", ".").replace(".java", "");
                    Class<?> clazz = Class.forName(classPath);
                    if (clazz.isAnnotationPresent(Entity.class)) {
                        classes.add(clazz);
                    }
                }
            }
        }
        return classes;
    }
}