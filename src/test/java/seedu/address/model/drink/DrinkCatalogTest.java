package seedu.address.model.drink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDrinks.CAPPUCCINO;
import static seedu.address.testutil.TypicalDrinks.LATTE;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.DrinkCatalog;

public class DrinkCatalogTest {

    private final DrinkCatalog drinkCatalog = new DrinkCatalog();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), drinkCatalog.getDrinkList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> drinkCatalog.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyDrinkCatalog_replacesData() {
        DrinkCatalog newData = new DrinkCatalog();
        newData.addDrink(LATTE);
        drinkCatalog.resetData(newData);
        assertEquals(newData, drinkCatalog);
    }

    @Test
    public void hasDrink_nullDrink_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> drinkCatalog.hasDrink(null));
    }

    @Test
    public void hasDrink_drinkNotInDrinkCatalog_returnsFalse() {
        assertFalse(drinkCatalog.hasDrink(LATTE));
    }

    @Test
    public void hasDrink_drinkInDrinkCatalog_returnsTrue() {
        drinkCatalog.addDrink(LATTE);
        assertTrue(drinkCatalog.hasDrink(LATTE));
    }

    @Test
    public void hasDrink_drinkWithSameIdentityFieldsInDrinkCatalog_returnsTrue() {
        drinkCatalog.addDrink(LATTE);
        Drink editedLatte = new Drink("Latte", 5.00, "Specialty");
        assertTrue(drinkCatalog.hasDrink(editedLatte));
    }


    @Test
    public void addDrink_drinkAdded() {
        drinkCatalog.addDrink(LATTE);
        assertTrue(drinkCatalog.hasDrink(LATTE));
    }

    @Test
    public void removeDrink_drinkRemoved() {
        drinkCatalog.addDrink(LATTE);
        drinkCatalog.removeDrink(LATTE);
        assertFalse(drinkCatalog.hasDrink(LATTE));
    }

    @Test
    public void setDrink_targetFound_drinkReplaced() {
        drinkCatalog.addDrink(LATTE);
        drinkCatalog.setDrink(LATTE, CAPPUCCINO);

        DrinkCatalog expectedCatalog = new DrinkCatalog();
        expectedCatalog.addDrink(CAPPUCCINO);

        assertEquals(expectedCatalog, drinkCatalog);
    }
}
