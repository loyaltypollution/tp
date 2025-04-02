package seedu.address.model.drink;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import seedu.address.commons.util.StringUtil;

/**
 * Represents a Drink's name.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}.
 */
public class DrinkName {

    public static final String MESSAGE_CONSTRAINTS =
            "Drink names should only contain letters and spaces, "
            + "and cannot be blank or consist only of spaces.";

    public static final String VALIDATION_REGEX = "^(?!\\s*$)[A-Za-z ]+$";

    private final String drinkName;

    /**
     * Constructs a {@code DrinkName}.
     *
     * @param drinkName A valid name.
     */
    public DrinkName(String drinkName) {
        requireNonNull(drinkName);
        checkArgument(isValidDrinkName(drinkName), MESSAGE_CONSTRAINTS);
        this.drinkName = drinkName;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidDrinkName(String test) {
        if (test == null) {
            return false;
        }
        return test.matches(VALIDATION_REGEX);
    }

    public String getDrinkName() {
        return drinkName;
    }

    @Override
    public String toString() {
        return drinkName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof DrinkName
                && drinkName.equalsIgnoreCase(((DrinkName) other).drinkName));
    }

    public boolean equalsNameIgnoreCase(String otherName) {
        return drinkName.equalsIgnoreCase(otherName);
    }

    public boolean containsWordIgnoreCase(String word) {
        return StringUtil.containsWordIgnoreCase(drinkName, word);
    }

    @Override
    public int hashCode() {
        return drinkName.hashCode();
    }
}
