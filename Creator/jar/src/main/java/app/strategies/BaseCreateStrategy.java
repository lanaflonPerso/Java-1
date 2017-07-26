package app.strategies;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */

abstract class BaseCreateStrategy implements CreateStrategy{

    protected BaseCreateStrategy() {
    }

    protected static String getPackage(String fileName) {
        String[] fileNameTokens = fileName.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileNameTokens.length - 2; i++) {
            sb.append(fileNameTokens[i]);
            if (i < fileNameTokens.length - 3) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
