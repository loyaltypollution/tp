package seedu.address.model.drink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;


public class DrinkTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Drink(null, 5.0, "Coffee"));
        assertThrows(NullPointerException.class, () -> new Drink("Latte", 5.0, null));
    }

    @Test
    public void isSameDrink() {
        Drink latte = new Drink("Latte", 4.50, "Coffee");

        // same object -> returns true
        assertTrue(latte.isSameDrink(latte));

        // null -> returns false
        assertFalse(latte.isSameDrink(null));

        // same name, different price and category -> returns true
        Drink editedLatte = new Drink("Latte", 5.00, "Specialty");
        assertTrue(latte.isSameDrink(editedLatte));

        // different name -> returns false
        editedLatte = new Drink("Espresso", 4.50, "Coffee");
        assertFalse(latte.isSameDrink(editedLatte));

        // different case for name -> returns true
        editedLatte = new Drink("latte", 4.50, "Coffee");
        assertTrue(latte.isSameDrink(editedLatte));
    }

    @Test
    public void equals() {
        Drink latte = new Drink("Latte", 4.50, "Coffee");

        // same values -> returns true
        Drink latteWithSameValues = new Drink("Latte", 4.50, "Coffee");
        assertTrue(latte.equals(latteWithSameValues));

        // same object -> returns true
        assertTrue(latte.equals(latte));

        // null -> returns false
        assertFalse(latte.equals(null));

        // different type -> returns false
        assertFalse(latte.equals(5));

        // different name -> returns false
        Drink cappuccino = new Drink("Cappuccino", 4.50, "Coffee");
        assertFalse(latte.equals(cappuccino));

        // different price -> returns false
        Drink expensiveLatte = new Drink("Latte", 5.50, "Coffee");
        assertFalse(latte.equals(expensiveLatte));

        // different category -> returns false
        Drink specialtyLatte = new Drink("Latte", 4.50, "Specialty");
        assertFalse(latte.equals(specialtyLatte));
    }

    @Test
    public void toStringMethod() {
        Drink latte = new Drink("Latte", 4.50, "Coffee");
        String expected = "Latte Price: $4.5 Category: Coffee";
        assertEquals(expected, latte.toString());
    }
}
