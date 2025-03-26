package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's shift timing in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidShiftTiming(String)}
 */
public class ShiftTiming {

    public static final String MESSAGE_CONSTRAINTS =
            "Shift timing can take any values, and it should not be blank";

    /*
     * The shift timing must not be blank.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs a {@code ShiftTiming}.
     *
     * @param shiftTiming A valid shift timing.
     */
    public ShiftTiming(String shiftTiming) {
        requireNonNull(shiftTiming);
        checkArgument(isValidShiftTiming(shiftTiming), MESSAGE_CONSTRAINTS);
        value = shiftTiming;
    }

    /**
     * Returns true if a given string is a valid shift timing.
     */
    public static boolean isValidShiftTiming(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof ShiftTiming
                && value.equals(((ShiftTiming) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
