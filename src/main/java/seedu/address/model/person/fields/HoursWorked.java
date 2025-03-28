package seedu.address.model.person.fields;

/**
 * Represents a Person's hours worked in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidValue(String)}
 */
public class HoursWorked extends Field {

    public static final String MESSAGE_CONSTRAINTS =
            "Hours worked should only contain digits, and it should be at least 1 digit long";

    // Regex to match one or more digits (no negative or decimal values)
    public static final String VALIDATION_REGEX = "\\d+";

    /**
     * Constructs a {@code HoursWorked}.
     *
     * @param hoursWorked A valid number of hours worked.
     */
    public HoursWorked(String hoursWorked) {
        super(hoursWorked, MESSAGE_CONSTRAINTS, VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof HoursWorked
                && value.equals(((HoursWorked) other).value));
    }
}
