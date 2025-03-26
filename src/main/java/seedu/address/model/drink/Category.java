package seedu.address.model.drink;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Drink's category.
 * Guarantees: immutable; is valid as declared in {@link #isValidCategory(String)}.
 */
public class Category {

    public static final String MESSAGE_CONSTRAINTS = "Category should not be blank";

    public final String category;

    /**
     * Constructs a {@code Category}.
     *
     * @param category A valid category.
     */
    public Category(String category) {
        requireNonNull(category);
        if (!isValidCategory(category)) {
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    /**
     * Returns true if a given string is a valid category.
     */
    public static boolean isValidCategory(String test) {
        return test != null && !test.trim().isEmpty();
    }

    @Override
    public String toString() {
        return category;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Category
                && category.equals(((Category) other).category));
    }

    @Override
    public int hashCode() {
        return category.hashCode();
    }
}
