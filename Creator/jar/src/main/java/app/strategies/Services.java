package app.strategies;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static app.constants.ClassTemplates.SERVICE_IMPLEMENTATION_TEMPLATE;
import static app.constants.ClassTemplates.SERVICE_INTERFACE_TEMPLATE;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */
public class Services extends BaseCreateStrategy implements CreateStrategy {

    @Override
    public void execute(List<Class<?>> classes, String springBootApplicationFilePackageName) throws IOException {
        createServices(classes, springBootApplicationFilePackageName);
    }

    private static void createServices(List<Class<?>> files, String springBootApplicationFilePackageName) throws IOException {
        File directoryService = new File(ROOT_PATH + springBootApplicationFilePackageName + "\\services");
        if (!directoryService.exists()) {
            boolean hasDirectoryService = directoryService.mkdir();
        }

        for (Class<?> clazz : files) {
            createServiceInterfaces(clazz, directoryService.getPath());
            createServiceImplementation(clazz, directoryService.getPath());
        }
    }

    private static void createServiceImplementation(Class<?> clazz, String path) throws IOException {
        File service = new File(path + "\\" + clazz.getSimpleName() +  "ServiceImpl.java");
        if (service.exists()) {
            return;
        }
        boolean hasFile = service.createNewFile();

        try(PrintWriter printWriter = new PrintWriter (service)) {

            printWriter.println(String.format(SERVICE_IMPLEMENTATION_TEMPLATE, clazz.getSimpleName(), String.valueOf(clazz.getSimpleName().charAt(0)).toLowerCase() + clazz.getSimpleName().substring(1), getPackage(clazz.getName()), clazz.getName()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createServiceInterfaces(Class<?> clazz, String path) throws IOException {
        File service = new File(path + "\\" + clazz.getSimpleName() +  "Service.java");
        if (service.exists()) {
            return;
        }
        boolean hasFile = service.createNewFile();

        try(PrintWriter printWriter = new PrintWriter (service)) {

            printWriter.println(String.format(SERVICE_INTERFACE_TEMPLATE, getPackage(clazz.getName()), clazz.getName(), clazz.getSimpleName(), clazz.getSimpleName().toLowerCase()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}