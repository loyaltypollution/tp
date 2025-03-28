package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CustomerIdTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CustomerId(null));
    }

    @Test
    public void constructor_invalidCustomerId_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new CustomerId(""));
        assertThrows(IllegalArgumentException.class, () -> new CustomerId("1001"));
        assertThrows(IllegalArgumentException.class, () -> new CustomerId("C"));
        assertThrows(IllegalArgumentException.class, () -> new CustomerId("c1001"));
        assertThrows(IllegalArgumentException.class, () -> new CustomerId("CABC"));
    }

    @Test
    public void constructor_validCustomerId_success() {
        assertDoesNotThrow(() -> new CustomerId("C1001"));
        assertDoesNotThrow(() -> new CustomerId("C9999"));
        assertDoesNotThrow(() -> new CustomerId("C1"));
    }

    @Test
    public void isValidValue() {
        // Invalid cases
        assertEquals(false, CustomerId.isValidValue(""));
        assertEquals(false, CustomerId.isValidValue("C"));
        assertEquals(false, CustomerId.isValidValue("c1001"));
        assertEquals(false, CustomerId.isValidValue("1001"));
        assertEquals(false, CustomerId.isValidValue("CABC"));

        // Valid cases
        assertEquals(true, CustomerId.isValidValue("C1001"));
        assertEquals(true, CustomerId.isValidValue("C9999"));
        assertEquals(true, CustomerId.isValidValue("C1"));
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        CustomerId customerId = new CustomerId("C1001");
        assertEquals(customerId, customerId);
    }

    @Test
    public void equals_differentObjectSameValue_returnsTrue() {
        assertEquals(new CustomerId("C1001"), new CustomerId("C1001"));
    }

    @Test
    public void equals_differentValues_returnsFalse() {
        assertEquals(false, new CustomerId("C1001").equals(new CustomerId("C1002")));
    }
}
