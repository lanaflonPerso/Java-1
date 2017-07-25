package bookshop.enums;

/**
 * Created by Hristo Skipernov on 20/07/2017.
 */
public enum AgeRestriction {
    MINOR(0),
    TEEN(1),
    ADULT(2);

    private final int value;

    AgeRestriction(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
