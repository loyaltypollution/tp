package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RewardPointsTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RewardPoints(null));
    }

    @Test
    public void constructor_invalidRewardPoints_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new RewardPoints(""));
        assertThrows(IllegalArgumentException.class, () -> new RewardPoints("-1"));
        assertThrows(IllegalArgumentException.class, () -> new RewardPoints("abc"));
        assertThrows(IllegalArgumentException.class, () -> new RewardPoints("10.5"));
        assertThrows(IllegalArgumentException.class, () -> new RewardPoints(" 50"));
    }

    @Test
    public void constructor_validRewardPoints_success() {
        assertDoesNotThrow(() -> new RewardPoints("0"));
        assertDoesNotThrow(() -> new RewardPoints("10"));
        assertDoesNotThrow(() -> new RewardPoints("1000"));
    }

    @Test
    public void isValidValue() {
        // Invalid cases
        assertEquals(false, RewardPoints.isValidValue(""));
        assertEquals(false, RewardPoints.isValidValue("-1"));
        assertEquals(false, RewardPoints.isValidValue("abc"));
        assertEquals(false, RewardPoints.isValidValue("10.5"));
        assertEquals(false, RewardPoints.isValidValue(" 50"));

        // Valid cases
        assertEquals(true, RewardPoints.isValidValue("0"));
        assertEquals(true, RewardPoints.isValidValue("10"));
        assertEquals(true, RewardPoints.isValidValue("1000"));
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        RewardPoints points = new RewardPoints("50");
        assertEquals(points, points);
    }

    @Test
    public void equals_differentObjectSameValue_returnsTrue() {
        assertEquals(new RewardPoints("50"), new RewardPoints("50"));
    }

    @Test
    public void equals_differentValues_returnsFalse() {
        assertEquals(false, new RewardPoints("50").equals(new RewardPoints("100")));
    }
}
