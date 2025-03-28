package seedu.address.model.person.fields;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Customer's ID in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidValue(String)}
 */
public class CustomerId {

    public static final String MESSAGE_CONSTRAINTS =
            "Customer ID should start with a 'C' followed by digits, e.g., C1001";

    /*
     * The Customer ID must start with an uppercase 'C' followed by at least one digit.
     */
    public static final String VALIDATION_REGEX = "C\\d+";

    public final String value;

    /**
     * Constructs a {@code CustomerId}.
     *
     * @param customerId A valid customer ID.
     */
    public CustomerId(String customerId) {
        requireNonNull(customerId);
        checkArgument(isValidValue(customerId), MESSAGE_CONSTRAINTS);
        value = customerId;
    }

    /**
     * Returns true if a given string is a valid customer ID.
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
                || (other instanceof CustomerId // instanceof handles nulls
                && value.equals(((CustomerId) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
