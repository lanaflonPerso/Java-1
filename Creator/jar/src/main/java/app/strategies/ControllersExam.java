package app.strategies;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static app.constants.ClassTemplates.CONTROLLER_TEMPLATE_DB_ADVANCED_EXAM;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */
public class ControllersExam extends BaseCreateStrategy {
    @Override
    public void execute(List<Class<?>> classes, String destinationPackagePath) throws IOException {
        createControllers(classes, destinationPackagePath);
    }

    private static void createControllers(List<Class<?>> files, String destinationPackagePath) throws IOException {
        File file = new File(destinationPackagePath + File.separator + "controllers");
        if (!file.exists()) {
            file.mkdirs();
        }

        for (Class<?> clazz : files) {
            createControllerClass(clazz, file.getPath());
        }
    }

    private static void createControllerClass(Class<?> clazz, String path) throws IOException {
        File controller = new File(path + File.separator + clazz.getSimpleName() + "Controller.java");
        if (controller.exists()) {
            return;
        }
        controller.createNewFile();

        try (PrintWriter printWriter = new PrintWriter(controller)) {

            printWriter.println(String.format(CONTROLLER_TEMPLATE_DB_ADVANCED_EXAM,
                    getPackage(controller),
                    getPackage(controller.getParentFile()),
                    clazz.getSimpleName(),
                    String.valueOf(clazz.getSimpleName().charAt(0)).toLowerCase() + clazz.getSimpleName().substring(1)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}