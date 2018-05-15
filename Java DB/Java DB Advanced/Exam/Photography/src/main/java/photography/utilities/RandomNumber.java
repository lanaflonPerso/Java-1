package photography.utilities;

import java.util.Random;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */
public final class RandomNumber {
    private static Random rnd = new Random();

    private RandomNumber() {}

    public static int getRandomNumber(int bound) {
        return rnd.nextInt(bound);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (min + (Math.random() * (max - min)));
    }
}
