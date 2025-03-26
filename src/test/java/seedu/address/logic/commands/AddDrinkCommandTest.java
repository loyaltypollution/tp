package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.DrinkCatalog;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.drink.Drink;

public class AddDrinkCommandTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(new AddressBook(), new UserPrefs(), new DrinkCatalog());
    }

    @Test
    public void execute_newDrink_success() throws Exception {
        Drink validDrink = new Drink("Espresso", 3.50, "Coffee");
        AddDrinkCommand drinkAddCommand = new AddDrinkCommand(validDrink);

        CommandResult result = drinkAddCommand.execute(model);

        // Check success message
        assertEquals(String.format(AddDrinkCommand.MESSAGE_SUCCESS, validDrink), result.getFeedbackToUser());

        // Verify drink was added
        assertTrue(model.hasDrink(validDrink));
    }

    @Test
    public void execute_duplicateDrink_throwsCommandException() {
        Drink duplicateDrink = new Drink("Latte", 4.50, "Coffee");
        model.addDrink(duplicateDrink); // Add to model first

        AddDrinkCommand drinkAddCommand = new AddDrinkCommand(duplicateDrink);

        assertThrows(CommandException.class, () -> drinkAddCommand.execute(model));
    }

    @Test
    public void equals() {
        Drink espresso = new Drink("Espresso", 3.50, "Coffee");
        Drink cappuccino = new Drink("Cappuccino", 4.00, "Coffee");

        AddDrinkCommand addEspressoCommand = new AddDrinkCommand(espresso);
        AddDrinkCommand addCappuccinoCommand = new AddDrinkCommand(cappuccino);

        // Same object -> returns true
        assertTrue(addEspressoCommand.equals(addEspressoCommand));

        // Same values -> returns true
        AddDrinkCommand addEspressoCommandCopy = new AddDrinkCommand(espresso);
        assertTrue(addEspressoCommand.equals(addEspressoCommandCopy));

        // Different drinks -> returns false
        assertFalse(addEspressoCommand.equals(addCappuccinoCommand));

        // Different type -> returns false
        assertFalse(addEspressoCommand.equals(5));

        // Null -> returns false
        assertFalse(addEspressoCommand.equals(null));
    }
}
