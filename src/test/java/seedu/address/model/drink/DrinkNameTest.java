package seedu.address.model.drink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DrinkNameTest {

    @Test
    void constructor_nullDrinkName_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DrinkName(null));
    }

    @Test
    void constructor_invalidDrinkName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new DrinkName(""));
        assertThrows(IllegalArgumentException.class, () -> new DrinkName("   "));
    }

    @Test
    void isValidName_validCases() {
        assertTrue(DrinkName.isValidName("Coca Cola"));
        assertTrue(DrinkName.isValidName("Orange Juice"));
        assertTrue(DrinkName.isValidName("Latte"));
    }

    @Test
    void isValidName_invalidCases() {
        assertFalse(DrinkName.isValidName(null));
        assertFalse(DrinkName.isValidName(""));
        assertFalse(DrinkName.isValidName("   "));
    }

    @Test
    void equals_sameObject_returnsTrue() {
        DrinkName drinkName = new DrinkName("Pepsi");
        assertEquals(drinkName, drinkName);
    }

    @Test
    void equals_differentObjectsSameValue_returnsTrue() {
        assertEquals(new DrinkName("Pepsi"), new DrinkName("Pepsi"));
    }

    @Test
    void equals_differentDrinkName_returnsFalse() {
        assertFalse(new DrinkName("Pepsi").equals(new DrinkName("Sprite")));
    }

    @Test
    void toString_correctFormat() {
        DrinkName drinkName = new DrinkName("Fanta");
        assertEquals("Fanta", drinkName.toString());
    }

    @Test
    void hashCode_sameDrinkName_sameHashCode() {
        assertEquals(new DrinkName("Root Beer").hashCode(), new DrinkName("Root Beer").hashCode());
    }
}
