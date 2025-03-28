package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class StaffIdTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new StaffId(null));
    }

    @Test
    public void constructor_invalidStaffId_throwsIllegalArgumentException() {
        String invalidStaffId = "";
        assertThrows(IllegalArgumentException.class, () -> new StaffId(invalidStaffId));
    }

    @Test
    public void isValidValue() {
        // null staff ID
        assertThrows(NullPointerException.class, () -> StaffId.isValidValue(null));

        // invalid staff IDs
        assertFalse(StaffId.isValidValue("")); // empty string
        assertFalse(StaffId.isValidValue(" ")); // spaces only
        assertFalse(StaffId.isValidValue("S")); // missing digits
        assertFalse(StaffId.isValidValue("1234")); // missing 'S' prefix
        assertFalse(StaffId.isValidValue("s1001")); // lowercase 's'
        assertFalse(StaffId.isValidValue("S10A1")); // non-numeric characters after 'S'

        // valid staff IDs
        assertTrue(StaffId.isValidValue("S1")); // minimal valid case
        assertTrue(StaffId.isValidValue("S100"));
        assertTrue(StaffId.isValidValue("S99999"));
    }

    @Test
    public void equals() {
        StaffId staffId = new StaffId("S1001");

        // same values -> returns true
        assertTrue(staffId.equals(new StaffId("S1001")));

        // same object -> returns true
        assertTrue(staffId.equals(staffId));

        // null -> returns false
        assertFalse(staffId.equals(null));

        // different types -> returns false
        assertFalse(staffId.equals(5.0f));

        // different values -> returns false
        assertFalse(staffId.equals(new StaffId("S1002")));
    }
}
