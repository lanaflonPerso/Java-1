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
    public void execute(List<Class<?>> classes, String springBootApplicationFilePackageName) throws IOException {
        createRepositories(classes, springBootApplicationFilePackageName);
    }

    private static void createRepositories(List<Class<?>> files, String springBootApplicationFilePackageName) throws IOException {
        File directoryRepository = new File(ROOT_PATH + springBootApplicationFilePackageName + "\\repositories");
        if (!directoryRepository.exists()) {
            boolean hasDirectoryRepository = directoryRepository.mkdir();
        }

        for (Class<?> clazz : files) {
            createRepositoryInterfaces(clazz, directoryRepository.getPath());
        }
    }

    private static void createRepositoryInterfaces(Class<?> clazz, String path) throws IOException {
        File repository = new File(path + "\\" + clazz.getSimpleName() + "Repository.java");
        if (repository.exists()) {
            return;
        }
        boolean hasFile = repository.createNewFile();

        try (PrintWriter printWriter = new PrintWriter(repository)) {

            printWriter.println(String.format(REPOSITORY_INTERFACE_TEMPLATE, getPackage(clazz.getName()), clazz.getName(), clazz.getSimpleName()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}