package seedu.address.model.drink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PriceTest {

    @Test
    void constructor_invalidPrice_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Price(0));
        assertThrows(IllegalArgumentException.class, () -> new Price(-5.0));
    }

    @Test
    void isValidValue_validCases() {
        assertTrue(Price.isValidValue(0.01));
        assertTrue(Price.isValidValue(5.99));
        assertTrue(Price.isValidValue(100.0));
    }

    @Test
    void isValidValue_invalidCases() {
        assertFalse(Price.isValidValue(0));
        assertFalse(Price.isValidValue(-1.0));
        assertFalse(Price.isValidValue(-50.0));
    }

    @Test
    void equals_sameObject_returnsTrue() {
        Price price = new Price(10.0);
        assertEquals(price, price);
    }

    @Test
    void equals_differentObjectsSameValue_returnsTrue() {
        assertEquals(new Price(10.0), new Price(10.0));
    }

    @Test
    void equals_differentPrice_returnsFalse() {
        assertFalse(new Price(10.0).equals(new Price(5.0)));
    }

    @Test
    void toString_correctFormat() {
        Price price = new Price(7.5);
        assertEquals("7.50", price.toString());
    }

    @Test
    void hashCode_samePrice_sameHashCode() {
        assertEquals(new Price(15.99).hashCode(), new Price(15.99).hashCode());
    }
}
