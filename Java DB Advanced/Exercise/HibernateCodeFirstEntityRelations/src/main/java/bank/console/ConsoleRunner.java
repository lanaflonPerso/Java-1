package bank.console;

import bank.annotations.Inject;
import bank.core.Executable;
import bank.services.AbstractAccountService;
import bank.services.CheckingAccountService;
import bank.services.SavingAccountService;
import bank.services.UserService;
import bank.ustilities.RandomAccountNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final String COMMAND_PATH = "bank.core.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private String[] params;
    private final UserService userService;
    private final AbstractAccountService abstractAccountService;
    private final SavingAccountService savingAccountService;
    private final CheckingAccountService checkingAccountService;
    private final RandomAccountNumber randomAccountNumber;

    @Autowired
    public ConsoleRunner(UserService userService, AbstractAccountService abstractAccountService, SavingAccountService savingAccountService, CheckingAccountService checkingAccountService, RandomAccountNumber randomAccountNumber) {
        this.userService = userService;
        this.abstractAccountService = abstractAccountService;
        this.savingAccountService = savingAccountService;
        this.checkingAccountService = checkingAccountService;
        this.randomAccountNumber = randomAccountNumber;
    }

    @Override
    public void run(String... strings) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] commandTokens = bufferedReader.readLine().split("\\s+");
            try {
                String result = dispatchCommand(commandTokens).execute();
                System.out.println(result);
                if (result.contains("successfully logged out")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Executable dispatchCommand(String[] commandTokens) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        if (commandTokens[0].equals("Add")) {
            this.params = Arrays.stream(commandTokens).skip(1).toArray(String[]::new);
            return dispatchCommand(this.params);
        }
        this.params = Arrays.stream(commandTokens).skip(1).toArray(String[]::new);
        Class<Executable> clazz = (Class<Executable>) Class.forName(COMMAND_PATH + commandTokens[0] + COMMAND_SUFFIX);
        Constructor<Executable> constructor = clazz.getDeclaredConstructor();
        Executable executable = constructor.newInstance();
        this.injectDependencies(executable);
        return executable;
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fields = executable.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();
                for (Field currentField : currentFields) {
                    if (field.getType().equals(currentField.getType())) {
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }
}