package app;

import app.enums.StrategyType;
import app.utilities.Creator;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

public class Main {
    public static void main(String[] args) {
        Creator.create(StrategyType.EXAM, "H:\\SoftUni\\Java\\Tools\\My first library creator\\jar\\src\\main\\java\\app\\entities", "H:\\SoftUni\\Java\\Tools\\My first library creator\\jar\\src\\main\\java\\app");
    }
}