package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FavouriteItemTest {

    @Test
    public void isValidFavouriteItem_validValues_returnsTrue() {
        // Favourite items can be any non-blank string
        assertTrue(FavouriteItem.isValidFavouriteItem("Pizza"));
        assertTrue(FavouriteItem.isValidFavouriteItem("Apple"));
        assertTrue(FavouriteItem.isValidFavouriteItem("Chocolate"));
        assertTrue(FavouriteItem.isValidFavouriteItem("1234")); // Numeric values should be allowed as well
    }

    @Test
    public void constructor_validValues_createsFavouriteItem() {
        // valid favourite items should not throw any exceptions
        new FavouriteItem("Pizza");
        new FavouriteItem("Apple");
        new FavouriteItem("Chocolate");
    }

    @Test
    public void constructor_invalidValues_throwsIllegalArgumentException() {
        // invalid favourite items should throw an IllegalArgumentException
        try {
            new FavouriteItem(""); // Empty string should throw an exception
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains(FavouriteItem.MESSAGE_CONSTRAINTS));
        }
    }

    @Test
    public void equals_sameValues_returnsTrue() {
        FavouriteItem favouriteItem1 = new FavouriteItem("Pizza");
        FavouriteItem favouriteItem2 = new FavouriteItem("Pizza");
        assertTrue(favouriteItem1.equals(favouriteItem2));
    }

    @Test
    public void equals_differentValues_returnsFalse() {
        FavouriteItem favouriteItem1 = new FavouriteItem("Pizza");
        FavouriteItem favouriteItem2 = new FavouriteItem("Apple");
        assertFalse(favouriteItem1.equals(favouriteItem2));
    }

    @Test
    public void toString_testValue() {
        FavouriteItem favouriteItem = new FavouriteItem("Pizza");
        assertTrue(favouriteItem.toString().equals("Pizza"));
    }
}
