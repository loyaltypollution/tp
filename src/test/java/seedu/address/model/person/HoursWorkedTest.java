package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class HoursWorkedTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new HoursWorked(null));
    }

    @Test
    public void constructor_invalidHoursWorked_throwsIllegalArgumentException() {
        String invalidHoursWorked = "";
        assertThrows(IllegalArgumentException.class, () -> new HoursWorked(invalidHoursWorked));
    }

    @Test
    public void isValidValue() {
        // null hours worked
        assertThrows(NullPointerException.class, () -> HoursWorked.isValidValue(null));

        // invalid hours worked
        assertFalse(HoursWorked.isValidValue("")); // empty string
        assertFalse(HoursWorked.isValidValue(" ")); // spaces only
        assertFalse(HoursWorked.isValidValue("abc")); // alphabets
        assertFalse(HoursWorked.isValidValue("12a")); // alphanumeric
        assertFalse(HoursWorked.isValidValue("-5")); // negative numbers
        assertFalse(HoursWorked.isValidValue("3.5")); // decimal numbers

        // valid hours worked
        assertTrue(HoursWorked.isValidValue("0")); // zero is allowed
        assertTrue(HoursWorked.isValidValue("1")); // minimum valid number
        assertTrue(HoursWorked.isValidValue("40")); // typical work hours
        assertTrue(HoursWorked.isValidValue("168")); // max possible in a week
    }

    @Test
    public void equals() {
        HoursWorked hoursWorked = new HoursWorked("40");

        // same values -> returns true
        assertTrue(hoursWorked.equals(new HoursWorked("40")));

        // same object -> returns true
        assertTrue(hoursWorked.equals(hoursWorked));

        // null -> returns false
        assertFalse(hoursWorked.equals(null));

        // different types -> returns false
        assertFalse(hoursWorked.equals(5.0f));

        // different values -> returns false
        assertFalse(hoursWorked.equals(new HoursWorked("35")));
    }
}
