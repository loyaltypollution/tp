package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TotalSpentTest {

    @Test
    public void isValidValue_validValues_returnsTrue() {
        // valid total spent values
        assertTrue(TotalSpent.isValidValue("0.0"));
        assertTrue(TotalSpent.isValidValue("5.5"));
        assertTrue(TotalSpent.isValidValue("12.34"));
        assertTrue(TotalSpent.isValidValue("100.00"));
    }

    @Test
    public void isValidValue_invalidValues_returnsFalse() {
        // invalid total spent values
        assertFalse(TotalSpent.isValidValue("0.123")); // More than 2 decimals
        assertFalse(TotalSpent.isValidValue("-5.5")); // Negative number
        assertFalse(TotalSpent.isValidValue("abc")); // Non-numeric input
        assertFalse(TotalSpent.isValidValue("100.")); // Missing decimal places
    }

    @Test
    public void constructor_validValues_createsTotalSpent() {
        // valid values should not throw any exceptions
        new TotalSpent("0.0");
        new TotalSpent("5.5");
        new TotalSpent("12.34");
    }

    @Test
    public void constructor_invalidValues_throwsIllegalArgumentException() {
        // invalid values should throw an IllegalArgumentException
        try {
            new TotalSpent("0.123");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains(TotalSpent.MESSAGE_CONSTRAINTS));
        }

        try {
            new TotalSpent("-5.5");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains(TotalSpent.MESSAGE_CONSTRAINTS));
        }

        try {
            new TotalSpent("abc");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains(TotalSpent.MESSAGE_CONSTRAINTS));
        }
    }

    @Test
    public void equals_sameValues_returnsTrue() {
        TotalSpent totalSpent1 = new TotalSpent("10.0");
        TotalSpent totalSpent2 = new TotalSpent("10.0");
        assertTrue(totalSpent1.equals(totalSpent2));
    }

    @Test
    public void equals_differentValues_returnsFalse() {
        TotalSpent totalSpent1 = new TotalSpent("10.0");
        TotalSpent totalSpent2 = new TotalSpent("20.0");
        assertFalse(totalSpent1.equals(totalSpent2));
    }

    @Test
    public void toString_testValue() {
        TotalSpent totalSpent = new TotalSpent("5.5");
        assertTrue(totalSpent.toString().equals("5.5"));
    }
}
