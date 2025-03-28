package seedu.address.model.person.fields;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Customer's Visit Count in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidValue(String)}
 */
public class VisitCount {

    public static final String MESSAGE_CONSTRAINTS =
            "Visit count should be a non-negative integer (e.g., 0, 1, 10)";

    /*
     * The visit count must be a non-negative integer (at least 0).
     */
    public static final String VALIDATION_REGEX = "\\d+";

    public final String value;

    /**
     * Constructs a {@code VisitCount}.
     *
     * @param visitCount A valid visit count string.
     */
    public VisitCount(String visitCount) {
        requireNonNull(visitCount);
        checkArgument(isValidValue(visitCount), MESSAGE_CONSTRAINTS);
        this.value = visitCount;
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
                || (other instanceof VisitCount // instanceof handles nulls
                && value.equals(((VisitCount) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
