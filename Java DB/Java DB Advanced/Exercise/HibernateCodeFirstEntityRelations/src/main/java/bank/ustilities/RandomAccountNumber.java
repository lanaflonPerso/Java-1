package bank.ustilities;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Component
public final class RandomAccountNumber {
    private static final String SALT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public String get() {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALT_CHARS.length());
            salt.append(SALT_CHARS.charAt(index));
        }
        return salt.toString();
    }
}
