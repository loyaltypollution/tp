package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CATEGORY_COFFEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_LATTE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PRICE_LATTE;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDrinks.LATTE;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;

public class JsonAdaptedDrinkTest {

    @Test
    public void toModelType_validDrinkDetails_returnsDrink() throws Exception {
        JsonAdaptedDrink drink = new JsonAdaptedDrink(LATTE);
        assertEquals(LATTE, drink.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedDrink drink = new JsonAdaptedDrink(
                "", VALID_PRICE_LATTE, VALID_CATEGORY_COFFEE);
        String expectedMessage = "Drink name cannot be blank";
        assertThrows(IllegalValueException.class, expectedMessage, drink::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedDrink drink = new JsonAdaptedDrink(
                null, VALID_PRICE_LATTE, VALID_CATEGORY_COFFEE);
        String expectedMessage = "Drink name cannot be blank";
        assertThrows(IllegalValueException.class, expectedMessage, drink::toModelType);
    }

    @Test
    public void toModelType_invalidPrice_throwsIllegalValueException() {
        JsonAdaptedDrink drink = new JsonAdaptedDrink(
                VALID_NAME_LATTE, 0, VALID_CATEGORY_COFFEE);
        String expectedMessage = "Drink price must be a positive number";
        assertThrows(IllegalValueException.class, expectedMessage, drink::toModelType);
    }

    @Test
    public void toModelType_invalidCategory_throwsIllegalValueException() {
        JsonAdaptedDrink drink = new JsonAdaptedDrink(
                VALID_NAME_LATTE, VALID_PRICE_LATTE, "");
        String expectedMessage = "Drink category cannot be blank";
        assertThrows(IllegalValueException.class, expectedMessage, drink::toModelType);
    }

    @Test
    public void toModelType_nullCategory_throwsIllegalValueException() {
        JsonAdaptedDrink drink = new JsonAdaptedDrink(
                VALID_NAME_LATTE, VALID_PRICE_LATTE, null);
        String expectedMessage = "Drink category cannot be blank";
        assertThrows(IllegalValueException.class, expectedMessage, drink::toModelType);
    }
}
