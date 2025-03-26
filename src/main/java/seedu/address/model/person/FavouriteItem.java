package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Customer's Favourite Item in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidFavouriteItem(String)}
 */
public class FavouriteItem {

    public static final String MESSAGE_CONSTRAINTS = "Favourite items can take any values, and it should not be blank";

    /*
     * No strict validation for favourite items as it can take any value.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs a {@code FavouriteItem}.
     *
     * @param favouriteItem A valid favourite item.
     */
    public FavouriteItem(String favouriteItem) {
        requireNonNull(favouriteItem);
        checkArgument(isValidFavouriteItem(favouriteItem), MESSAGE_CONSTRAINTS);
        value = favouriteItem;
    }

    /**
     * Returns true if a given string is a valid favourite item.
     */
    public static boolean isValidFavouriteItem(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FavouriteItem)) {
            return false;
        }

        FavouriteItem otherFavouriteItem = (FavouriteItem) other;
        return value.equals(otherFavouriteItem.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
