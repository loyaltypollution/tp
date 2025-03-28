package seedu.address.model.person.fields;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Customer's Total Spent in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidValue(String)}
 */
public class TotalSpent {

    public static final String MESSAGE_CONSTRAINTS =
            "Total spent should be a non-negative number with 1 or 2 decimal places (e.g., 10.0, 100.55).";

    /*
     * Regex validates:
     * - Non-negative numbers with exactly 1 or 2 decimal places
     * Examples: 0.0, 5.5, 12.34, 100.00
     */
    public static final String VALIDATION_REGEX = "^\\d+(\\.\\d{1,2})?$";

    public final String value;

    /**
     * Constructs a {@code TotalSpent}.
     *
     * @param totalSpent A valid total spent value.
     */
    public TotalSpent(String totalSpent) {
        requireNonNull(totalSpent);
        checkArgument(isValidValue(totalSpent), MESSAGE_CONSTRAINTS);
        value = totalSpent;
    }

    /**
     * Returns true if the given string is a valid total spent value with 1 or 2 decimal places.
     */
    public static boolean isValidValue(String test) {
        if (!test.matches(VALIDATION_REGEX)) {
            return false;
        }

        try {
            double number = Double.parseDouble(test);
            return number >= 0;
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
                || (other instanceof TotalSpent
                && value.equals(((TotalSpent) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
