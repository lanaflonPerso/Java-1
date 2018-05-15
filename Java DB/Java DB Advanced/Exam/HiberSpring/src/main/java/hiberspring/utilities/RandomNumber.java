package hiberspring.utilities;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */
public final class RandomNumber {

    private RandomNumber() {}

	/*
		return random number in range (0 ≤ x < bound)
	*/
    public static long getRandomNumber(int bound) {
        return ThreadLocalRandom.current().nextLong(bound);
    }

	/*
		return random number in range (min ≤ x < max)
	*/
    public static long getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }
}
