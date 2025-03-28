package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ShiftTimingTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ShiftTiming(null));
    }

    @Test
    public void constructor_invalidShiftTiming_throwsIllegalArgumentException() {
        String invalidShiftTiming = "";
        assertThrows(IllegalArgumentException.class, () -> new ShiftTiming(invalidShiftTiming));
    }

    @Test
    public void isValidValue() {
        // null shift timing
        assertThrows(NullPointerException.class, () -> ShiftTiming.isValidValue(null));

        // invalid shift timings
        assertFalse(ShiftTiming.isValidValue("")); // empty string
        assertFalse(ShiftTiming.isValidValue(" ")); // single space
        assertFalse(ShiftTiming.isValidValue("    ")); // multiple spaces

        // valid shift timings
        assertTrue(ShiftTiming.isValidValue("8am-4pm"));
        assertTrue(ShiftTiming.isValidValue("10:00 - 18:00"));
        assertTrue(ShiftTiming.isValidValue("Night shift"));
        assertTrue(ShiftTiming.isValidValue("3PM-11PM"));
    }

    @Test
    public void equals() {
        ShiftTiming shiftTiming = new ShiftTiming("8am-4pm");

        // same values -> returns true
        assertTrue(shiftTiming.equals(new ShiftTiming("8am-4pm")));

        // same object -> returns true
        assertTrue(shiftTiming.equals(shiftTiming));

        // null -> returns false
        assertFalse(shiftTiming.equals(null));

        // different types -> returns false
        assertFalse(shiftTiming.equals(5.0f));

        // different values -> returns false
        assertFalse(shiftTiming.equals(new ShiftTiming("9am-5pm")));
    }
}
