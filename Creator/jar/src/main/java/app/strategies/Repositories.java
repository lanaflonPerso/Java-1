package app.strategies;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static app.constants.ClassTemplates.REPOSITORY_INTERFACE_TEMPLATE;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */
public class Repositories extends BaseCreateStrategy {
    @Override
    public void execute(List<Class<?>> classes, String destinationPackagePath) throws IOException {
        createRepositories(classes, destinationPackagePath);
    }

    private static void createRepositories(List<Class<?>> files, String destinationPackagePath) throws IOException {
        File file = new File(destinationPackagePath + File.separator + "repositories");
        if (!file.exists()) {
            file.mkdirs();
        }

        for (Class<?> clazz : files) {
            createRepositoryInterfaces(clazz, file.getPath());
        }
    }

    private static void createRepositoryInterfaces(Class<?> clazz, String path) throws IOException {
        File repository = new File(path + File.separator + clazz.getSimpleName() + "Repository.java");
        if (repository.exists()) {
            return;
        }
        repository.createNewFile();

        try (PrintWriter printWriter = new PrintWriter(repository)) {

            printWriter.println(String.format(REPOSITORY_INTERFACE_TEMPLATE,
                    getPackage(repository),
                    clazz.getName(),
                    clazz.getSimpleName()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}