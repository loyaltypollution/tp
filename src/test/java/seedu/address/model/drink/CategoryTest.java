package seedu.address.model.drink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void constructor_nullCategory_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Category(null));
    }

    @Test
    void constructor_invalidCategory_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Category(""));
        assertThrows(IllegalArgumentException.class, () -> new Category("   "));
    }

    @Test
    void isValidCategory_validCases() {
        assertTrue(Category.isValidCategory("Juice"));
        assertTrue(Category.isValidCategory("Soft Drink"));
        assertTrue(Category.isValidCategory("Tea"));
    }

    @Test
    void isValidCategory_invalidCases() {
        assertFalse(Category.isValidCategory(null));
        assertFalse(Category.isValidCategory(""));
        assertFalse(Category.isValidCategory("   "));
    }

    @Test
    void equals_sameObject_returnsTrue() {
        Category category = new Category("Coffee");
        assertEquals(category, category);
    }

    @Test
    void equals_differentObjectsSameValue_returnsTrue() {
        assertEquals(new Category("Coffee"), new Category("Coffee"));
    }

    @Test
    void equals_differentCategory_returnsFalse() {
        assertFalse(new Category("Coffee").equals(new Category("Tea")));
    }

    @Test
    void toString_correctFormat() {
        Category category = new Category("Milkshake");
        assertEquals("Milkshake", category.toString());
    }

    @Test
    void hashCode_sameCategory_sameHashCode() {
        assertEquals(new Category("Energy Drink").hashCode(), new Category("Energy Drink").hashCode());
    }
}
