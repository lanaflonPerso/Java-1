package app.strategies;

import java.io.File;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */

abstract class BaseCreateStrategy implements CreateStrategy{

    protected BaseCreateStrategy() {
    }

    protected static String getPackage(File file) {
        return file.getParentFile().getPath()
                .replace(System.getProperty("user.dir") + "\\src\\main\\java\\", "")
                .replace("\\", ".");
    }
}
