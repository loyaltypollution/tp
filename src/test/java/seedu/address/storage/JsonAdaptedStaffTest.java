package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.model.util.StaffBuilder.MISSING_FIELD_MESSAGE_FORMAT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.StaffId;
import seedu.address.testutil.TypicalStaff;

public class JsonAdaptedStaffTest {
    private static final String INVALID_NAME = "J@ck";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#chef";

    private static final String VALID_NAME = TypicalStaff.ALEX.getName().toString();
    private static final String VALID_PHONE = TypicalStaff.ALEX.getPhone().toString();
    private static final String VALID_EMAIL = TypicalStaff.ALEX.getEmail().toString();
    private static final String VALID_ADDRESS = TypicalStaff.ALEX.getAddress().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = TypicalStaff.ALEX.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());
    private static final String VALID_STAFF_ID = TypicalStaff.ALEX.getStaffId().toString();
    private static final String VALID_ROLE = TypicalStaff.ALEX.getRole().toString();
    private static final String VALID_SHIFT_TIMING = TypicalStaff.ALEX.getShiftTiming().toString();
    private static final String VALID_HOURS_WORKED = TypicalStaff.ALEX.getHoursWorked().toString();
    private static final String VALID_PERFORMANCE_RATING = TypicalStaff.ALEX.getPerformanceRating().toString();

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME,
                VALID_PHONE,
                null,
                VALID_ADDRESS,
                VALID_TAGS,
                VALID_STAFF_ID,
                VALID_ROLE,
                VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        IllegalValueException exception = assertThrows(IllegalValueException.class, staff::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME,
                VALID_PHONE,
                VALID_EMAIL,
                null,
                VALID_TAGS,
                VALID_STAFF_ID,
                VALID_ROLE,
                VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        IllegalValueException exception = assertThrows(IllegalValueException.class, staff::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_nullRole_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME,
                VALID_PHONE,
                VALID_EMAIL,
                VALID_ADDRESS,
                VALID_TAGS,
                VALID_STAFF_ID,
                null,
                VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, "Role");
        IllegalValueException exception = assertThrows(IllegalValueException.class, staff::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_nullShiftTiming_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME,
                VALID_PHONE,
                VALID_EMAIL,
                VALID_ADDRESS,
                VALID_TAGS,
                VALID_STAFF_ID,
                VALID_ROLE,
                null,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, "ShiftTiming");
        IllegalValueException exception = assertThrows(IllegalValueException.class, staff::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_validStaffDetails_returnsStaff() throws Exception {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(TypicalStaff.ALEX);
        assertEquals(TypicalStaff.ALEX, staff.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(INVALID_NAME,
                VALID_PHONE,
                VALID_EMAIL,
                VALID_ADDRESS,
                VALID_TAGS,
                VALID_STAFF_ID,
                VALID_ROLE,
                VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        IllegalValueException exception = assertThrows(IllegalValueException.class, staff::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(null,
                VALID_PHONE,
                VALID_EMAIL,
                VALID_ADDRESS,
                VALID_TAGS,
                VALID_STAFF_ID,
                VALID_ROLE,
                VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        IllegalValueException exception = assertThrows(IllegalValueException.class, staff::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME,
                INVALID_PHONE,
                VALID_EMAIL,
                VALID_ADDRESS,
                VALID_TAGS,
                VALID_STAFF_ID,
                VALID_ROLE,
                VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        IllegalValueException exception = assertThrows(IllegalValueException.class, staff::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME,
                VALID_PHONE,
                INVALID_EMAIL,
                VALID_ADDRESS,
                VALID_TAGS,
                VALID_STAFF_ID,
                VALID_ROLE,
                VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        IllegalValueException exception = assertThrows(IllegalValueException.class, staff::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME,
                VALID_PHONE,
                VALID_EMAIL,
                INVALID_ADDRESS,
                VALID_TAGS,
                VALID_STAFF_ID,
                VALID_ROLE,
                VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        IllegalValueException exception = assertThrows(IllegalValueException.class, staff::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_nullStaffId_throwsIllegalValueException() {
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME,
                VALID_PHONE,
                VALID_EMAIL,
                VALID_ADDRESS,
                VALID_TAGS,
                null,
                VALID_ROLE,
                VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, StaffId.class.getSimpleName());
        IllegalValueException exception = assertThrows(IllegalValueException.class, staff::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedStaff staff = new JsonAdaptedStaff(VALID_NAME,
                VALID_PHONE,
                VALID_EMAIL,
                VALID_ADDRESS,
                invalidTags,
                VALID_STAFF_ID,
                VALID_ROLE,
                VALID_SHIFT_TIMING,
                VALID_HOURS_WORKED,
                VALID_PERFORMANCE_RATING);
        assertThrows(IllegalValueException.class, staff::toModelType);
    }
}
