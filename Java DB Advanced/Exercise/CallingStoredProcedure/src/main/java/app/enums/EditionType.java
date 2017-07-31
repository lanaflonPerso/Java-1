package app.enums;

/**
 * Created by Hristo Skipernov on 20/07/2017.
 */
public enum EditionType {
    NORMAL(1),
    PROMO(0),
    GOLD(2);

    private final int value;

    EditionType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}