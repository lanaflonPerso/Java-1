package app.factories;

import app.strategies.CreateStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */

@SuppressWarnings("unchecked")
public final class StrategyFactory {
    private StrategyFactory() {}

    public static CreateStrategy getStrategy(String strategyClassPath) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchMethodException {
        Class<CreateStrategy> classStrategy = (Class<CreateStrategy>) Class.forName(strategyClassPath);
        Constructor<CreateStrategy> strategyConstructor = classStrategy.getDeclaredConstructor();
        return strategyConstructor.newInstance();
    }

    public static List<CreateStrategy> getStrategies(String multipleStrategyName, String strategyClassPath) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchMethodException {
        String[] strategiesNames = multipleStrategyName.split("And");
        if (strategiesNames[0].equals("Exam")) {
            strategiesNames = new String[]{"ControllersExam", "Repositories", "ServicesExam"};
        }
        List<CreateStrategy> strategies = new ArrayList<>();
        for (String strategiesName : strategiesNames) {
            Class<CreateStrategy> classStrategy = (Class<CreateStrategy>) Class.forName(strategyClassPath + "." +  strategiesName);
            Constructor<CreateStrategy> strategyConstructor = classStrategy.getDeclaredConstructor();
            strategies.add(strategyConstructor.newInstance());
        }
        return strategies;
    }
}