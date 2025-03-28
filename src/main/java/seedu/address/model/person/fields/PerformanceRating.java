package seedu.address.model.person.fields;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's performance rating in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidValue(String)}
 */
public class PerformanceRating {

    public static final String MESSAGE_CONSTRAINTS =
            "Performance rating should be a number between 0 and 5.0 (inclusive).";

    /*
     * Regex validates that it looks like a number:
     * - Matches integers (0-5) or floats with optional decimals (e.g., 3.5)
     */
    public static final String VALIDATION_REGEX = "^(\\d+(\\.\\d{1})?)$";

    public final String value;

    /**
     * Constructs a {@code PerformanceRating}.
     *
     * @param rating A valid performance rating.
     */
    public PerformanceRating(String rating) {
        requireNonNull(rating);
        checkArgument(isValidValue(rating), MESSAGE_CONSTRAINTS);
        value = rating;
    }

    /**
     * Returns true if the given string is a valid performance rating between 0 and 5.0 inclusive.
     */
    public static boolean isValidValue(String test) {
        if (!test.matches(VALIDATION_REGEX)) {
            return false;
        }

        try {
            double number = Double.parseDouble(test);
            return number >= 0 && number <= 5.0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof PerformanceRating
                && value.equals(((PerformanceRating) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
