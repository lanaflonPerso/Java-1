package cars.utilities;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */
public final class RandomNumber {

    private RandomNumber() {}

    public static int getRandomNumber(int bound) {
        return (int) (Math.random() * (bound + 1));
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (min + (Math.random() * (max - min)));
    }
}
