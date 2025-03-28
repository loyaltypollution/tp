package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Role(null));
    }

    @Test
    public void constructor_invalidRole_throwsIllegalArgumentException() {
        String invalidRole = "";
        assertThrows(IllegalArgumentException.class, () -> new Role(invalidRole));
    }

    @Test
    public void isValidValue() {
        // null role
        assertThrows(NullPointerException.class, () -> Role.isValidValue(null));

        // invalid roles
        assertFalse(Role.isValidValue("")); // empty string
        assertFalse(Role.isValidValue(" ")); // spaces only

        // valid roles
        assertTrue(Role.isValidValue("Barista"));
        assertTrue(Role.isValidValue("Manager"));
        assertTrue(Role.isValidValue("Cashier"));
        assertTrue(Role.isValidValue("Head of Operations")); // multi-word role
    }

    @Test
    public void equals() {
        Role role = new Role("Barista");

        // same values -> returns true
        assertTrue(role.equals(new Role("Barista")));

        // same object -> returns true
        assertTrue(role.equals(role));

        // null -> returns false
        assertFalse(role.equals(null));

        // different types -> returns false
        assertFalse(role.equals(5.0f));

        // different values -> returns false
        assertFalse(role.equals(new Role("Manager")));
    }
}
