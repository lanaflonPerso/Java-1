package app.strategies;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static app.constants.ClassTemplates.SERVICE_IMPLEMENTATION_TEMPLATE_DB_ADVANCED_EXAM;
import static app.constants.ClassTemplates.SERVICE_INTERFACE_TEMPLATE_DB_ADVANCED_EXAM;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */
public class ServicesExam extends BaseCreateStrategy implements CreateStrategy {

    @Override
    public void execute(List<Class<?>> classes, String destinationPackagePath) throws IOException {
        createServices(classes, destinationPackagePath);
    }

    private static void createServices(List<Class<?>> files, String destinationPackagePath) throws IOException {
        File directoryService = new File(destinationPackagePath + File.separator + "services");
        if (!directoryService.exists()) {
            directoryService.mkdirs();
        }

        for (Class<?> clazz : files) {
            createServiceInterfaces(clazz, directoryService.getPath());
            createServiceImplementation(clazz, directoryService.getPath());
        }
    }

    private static void createServiceImplementation(Class<?> clazz, String path) throws IOException {
        File service = new File(path + File.separator + clazz.getSimpleName() + "ServiceImpl.java");
        if (service.exists()) {
            return;
        }
        service.createNewFile();

        try (PrintWriter printWriter = new PrintWriter(service)) {
            printWriter.println(String.format(SERVICE_IMPLEMENTATION_TEMPLATE_DB_ADVANCED_EXAM,
                    clazz.getSimpleName(),
                    String.valueOf(clazz.getSimpleName().charAt(0)).toLowerCase() + clazz.getSimpleName().substring(1),
                    getPackage(service),
                    clazz.getName(),
                    getPackage(service.getParentFile())));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createServiceInterfaces(Class<?> clazz, String path) throws IOException {
        File service = new File(path + File.separator + clazz.getSimpleName() + "Service.java");
        if (service.exists()) {
            return;
        }
        service.createNewFile();

        try (PrintWriter printWriter = new PrintWriter(service)) {

            printWriter.println(String.format(SERVICE_INTERFACE_TEMPLATE_DB_ADVANCED_EXAM,
                    getPackage(service),
                    clazz.getName(),
                    clazz.getSimpleName(),
                    clazz.getSimpleName().toLowerCase()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}