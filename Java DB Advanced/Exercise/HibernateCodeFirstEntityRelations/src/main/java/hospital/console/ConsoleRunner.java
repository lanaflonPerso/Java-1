package hospital.console;

import hospital.annotations.Command;
import hospital.api.Executable;
import hospital.api.InputReader;
import hospital.api.OutputWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final String TERMINATE_COMMAND = "End";
    private static final String COMMAND_CLASS_PATH = "hospital.core.commands.";
    private static final String COMMAND_FILE_PATH = "H:\\SoftUni\\Java\\Java DB Fundamentals\\Databases Advanced - Hibernate\\HibernateCodeFirstEntityRelations\\src\\main\\java\\hospital\\core\\commands";

    private final InputReader reader;
    private final OutputWriter writer;
    private Map<String, Executable> executables;

    @Autowired
    public ConsoleRunner(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.executables = new HashMap<>();
    }

    @Override
    public void run(String... strings) throws Exception {
        while (true) {
            this.writer.writeLine("Please insert command:");
            String command = this.reader.readLine();
            try {
                this.dispatchCommand(command);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }

            if (TERMINATE_COMMAND.equals(command)) {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void dispatchCommand(String command) throws Exception {
        try {
            File[] files = new File(COMMAND_FILE_PATH).listFiles();
            assert files != null;
            for (File file : files) {
                String fileName = file.getName().replace(".java", "");
                Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_CLASS_PATH + fileName);
                if (commandClass.isAnnotationPresent(Command.class)) {
                    Command annotation = commandClass.getDeclaredAnnotation(Command.class);
                    String commandAlias = annotation.name();
                    if (commandAlias.equals(command.toLowerCase())) {
                        Executable executable;
                        if(this.executables.containsKey(commandAlias)) {
                            executable = executables.get(commandAlias);
                        } else {
                            Constructor<Executable> declaredConstructor = commandClass.getDeclaredConstructor();
                            declaredConstructor.setAccessible(true);
                            executable = declaredConstructor.newInstance();
                        }
                        executable.execute();
                    }
                }
            }
        } catch (Exception e) {
            this.run();
        }
    }
}
