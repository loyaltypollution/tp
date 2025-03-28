package seedu.address.model.person.fields;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidValue(String)}
 */
public class Name extends Field {

    public static final String MESSAGE_CONSTRAINTS =
            "Names should only contain alphanumeric characters and spaces, and it should not be blank";

    // Regex to match one or more digits (no negative or decimal values)
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String fullName;

    /**
     * Constructs a {@code Name}.
     *
     * @param name A valid number of hours worked.
     */
    public Name(String name) {
        super(name, MESSAGE_CONSTRAINTS, VALIDATION_REGEX);
        fullName = name;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Name
                && value.equals(((Name) other).value));
    }
}
