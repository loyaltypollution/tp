package seedu.address.model.person.fields;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Customer's Reward Points in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidValue(String)}
 */
public class RewardPoints {

    public static final String MESSAGE_CONSTRAINTS =
            "Reward points should be a non-negative integer (e.g., 0, 50, 1000)";

    /*
     * The reward points must be a non-negative integer (at least 0).
     */
    public static final String VALIDATION_REGEX = "\\d+";

    public final String value;

    /**
     * Constructs a {@code RewardPoints}.
     *
     * @param points A valid reward points string.
     */
    public RewardPoints(String points) {
        requireNonNull(points);
        checkArgument(isValidValue(points), MESSAGE_CONSTRAINTS);
        this.value = points;
    }

    /**
     * Returns true if a given string is a valid non-negative integer.
     */
    public static boolean isValidValue(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RewardPoints // instanceof handles nulls
                && value.equals(((RewardPoints) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
