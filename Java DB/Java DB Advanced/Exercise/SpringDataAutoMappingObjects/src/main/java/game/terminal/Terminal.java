package game.terminal;

import game.controllers.GameController;
import game.controllers.OrderController;
import game.controllers.UserController;
import game.utilities.FetchCommands;
import game.utilities.Tokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Hristo Skipernov on 27/07/2017.
 */

@Component
public class Terminal implements CommandLineRunner {

    private final UserController userController;
    private final FetchCommands fetchCommands;
    private final Tokens tokens;
    private final GameController gameController;
    private final OrderController orderController;

    @Autowired
    public Terminal(UserController userController, FetchCommands fetchCommands, Tokens tokens, GameController gameController, OrderController orderController) {
        this.userController = userController;
        this.fetchCommands = fetchCommands;
        this.tokens = tokens;
        this.gameController = gameController;
        this.orderController = orderController;
    }

    @Override
    public void run(String... strings) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final Map<Class<?>, Map<String, Method>> commands = this.fetchCommands.getCommands();

        while (true) {
            String line = bufferedReader.readLine();
            String[] tokens = line.split("\\|");
            String commandName = tokens[0];
            String[] commandTokens = new String[tokens.length - 1];
            if (tokens.length > 1) {
                commandTokens = Arrays.stream(tokens).skip(1).toArray(String[]::new);
            }
            this.tokens.setCommandTokens(commandTokens);

            if (commands.values().stream().filter(x -> x.containsKey(commandName)).count() > 0) {
                Map<String, Method> map = null;
                for (Map<String, Method> methodMap : commands.values()) {
                    if (methodMap.containsKey(commandName)) {
                        map = methodMap;
                        break;
                    }
                }
                Class<?> clazz = this.getKey(commands, map);
                Field[] fields = this.getClass().getDeclaredFields();
                try {
                    for (Field field : fields) {
                        if (clazz != null && map != null && field.getType().getName().equals(clazz.getTypeName())) {
                            System.out.println(map.get(commandName).invoke(field.get(this)));
                            break;
                        }
                    }
                } catch (InvocationTargetException ite) {
                    ite.printStackTrace();
                }
            } else {
                System.out.println("Invalid command");
            }

            if (commandName.equals("end")) {
                break;
            }
        }
    }

    private Class<?> getKey(Map<Class<?>, Map<String, Method>> commands, Map<String, Method> value) {
        for (Class<?> key : commands.keySet()) {
            if (commands.get(key).equals(value)) {
                return key;
            }
        }
        return null;
    }
}
