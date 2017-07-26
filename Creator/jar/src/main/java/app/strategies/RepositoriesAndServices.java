package app.strategies;

import app.factories.StrategyFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */
public class RepositoriesAndServices implements CreateStrategy {

    @Override
    public void execute(List<Class<?>> classes, String springBootApplicationFilePackageName) throws IOException, InvocationTargetException, ClassNotFoundException, InstantiationException, NoSuchMethodException, IllegalAccessException {
        List<CreateStrategy> strategies = StrategyFactory.getStrategies(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
        for (CreateStrategy strategy : strategies) {
            strategy.execute(classes, springBootApplicationFilePackageName);
        }
    }
}