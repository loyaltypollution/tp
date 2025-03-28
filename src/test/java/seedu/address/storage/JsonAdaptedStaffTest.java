package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedStaff.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStaff.ALEX;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.fields.Address;
import seedu.address.model.person.fields.Email;
import seedu.address.model.person.fields.Name;
import seedu.address.model.person.fields.Phone;
import seedu.address.model.person.Staff;

public class JsonAdaptedStaffTest {
    private static final String INVALID_NAME = "J@ck";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#chef";

    private static final String VALID_NAME = ALEX.getName().toString();
    private static final String VALID_PHONE = ALEX.getPhone().toString();
    private static final String VALID_EMAIL = ALEX.getEmail().toString();
    private static final String VALID_ADDRESS = ALEX.getAddress().toString();
    private static final String VALID_REMARK = ALEX.getRemark().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = ALEX.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());
    private static final String VALID_STAFF_ID = ALEX.getStaffId().toString();
    private static final String VALID_ROLE = ALEX.getRole().toString();
    private static final String VALID_SHIFT_TIMING = ALEX.getShiftTiming().toString();
    private static final String VALID_HOURS_WORKED = ALEX.getHoursWorked().toString();
    private static final String VALID_PERFORMANCE_RATING = ALEX.getPerformanceRating().toString();

    @Test
    void constructor_nullEmail_throwsIllegalValueException() {
        assertThrows(IllegalValueException.class, () -> new JsonAdaptedStaff(
                VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS, VALID_REMARK, VALID_TAGS,
                VALID_STAFF_ID, VALID_ROLE, VALID_SHIFT_TIMING, VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING
        ).toModelType());

    }

    @Test
    void constructor_nullAddress_throwsIllegalValueException() {
        assertThrows(IllegalValueException.class, () ->
                new JsonAdaptedStaff(VALID_NAME, VALID_PHONE, VALID_EMAIL, null, VALID_REMARK,
                        VALID_TAGS, VALID_STAFF_ID, VALID_ROLE, VALID_SHIFT_TIMING,
                        VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING).toModelType());
    }

    @Test
    void constructor_nullRemark_throwsIllegalValueException() {
        assertThrows(IllegalValueException.class, () ->
                new JsonAdaptedStaff(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, null,
                        VALID_TAGS, VALID_STAFF_ID, VALID_ROLE, VALID_SHIFT_TIMING,
                        VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING).toModelType());
    }

    @Test
    void constructor_nullRole_throwsIllegalValueException() {
        assertThrows(IllegalValueException.class, () ->
                new JsonAdaptedStaff(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_REMARK,
                        VALID_TAGS, VALID_STAFF_ID, null, VALID_SHIFT_TIMING,
                        VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING).toModelType());
    }

    @Test
    void constructor_nullShiftTiming_throwsIllegalValueException() {
        assertThrows(IllegalValueException.class, () ->
                new JsonAdaptedStaff(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_REMARK,
                        VALID_TAGS, VALID_STAFF_ID, VALID_ROLE, null,
                        VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING).toModelType());
    }

    @Test
    public void toModelType_validStaffDetails_returnsStaff() throws Exception {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(ALEX);
        Staff expected = ALEX;
        Staff actual = staff.toModelType();
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(ALEX, staff.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(INVALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_REMARK, VALID_TAGS, VALID_STAFF_ID, VALID_ROLE, VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, staff::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(null, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_REMARK, VALID_TAGS, VALID_STAFF_ID, VALID_ROLE, VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, staff::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_REMARK, VALID_TAGS, VALID_STAFF_ID, VALID_ROLE, VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, staff::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS,
                VALID_REMARK, VALID_TAGS, VALID_STAFF_ID, VALID_ROLE, VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, staff::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS,
                VALID_REMARK, VALID_TAGS, VALID_STAFF_ID, VALID_ROLE, VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, staff::toModelType);
    }

    @Test
    public void toModelType_nullStaffId_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_REMARK, VALID_TAGS, null, VALID_ROLE, VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, "Staff ID");
        assertThrows(IllegalValueException.class, expectedMessage, staff::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_REMARK, invalidTags, VALID_STAFF_ID, VALID_ROLE, VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED, VALID_PERFORMANCE_RATING);
        assertThrows(IllegalValueException.class, staff::toModelType);
    }
}
