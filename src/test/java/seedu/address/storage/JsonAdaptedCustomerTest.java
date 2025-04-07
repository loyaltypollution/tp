package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.model.util.CustomerBuilder.MISSING_FIELD_MESSAGE_FORMAT;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Customer;
import seedu.address.model.person.CustomerId;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.RewardPoints;
import seedu.address.model.person.TotalSpent;
import seedu.address.model.person.VisitCount;
import seedu.address.model.tag.Tag;

public class JsonAdaptedCustomerTest {

    private static final String VALID_NAME = "Alice Pauline";
    private static final String VALID_PHONE = "12345678";
    private static final String VALID_EMAIL = "alice@example.com";
    private static final String VALID_ADDRESS = "123, Jurong West Ave 6, #08-111";
    private static final String VALID_CUSTOMER_ID = "C001";
    private static final String VALID_REWARD_POINTS = "100";
    private static final String VALID_VISIT_COUNT = "5";
    private static final String VALID_FAVOURITE_ITEM = "Latte";
    private static final String VALID_TOTAL_SPENT = "150.50";
    private static final List<JsonAdaptedTag> VALID_TAGS = List.of(new Tag("VIP"))
            .stream().map(JsonAdaptedTag::new).collect(Collectors.toList());

    private static final String INVALID_PHONE = "abcd";
    private static final String INVALID_EMAIL = "alice@@example";
    private static final String INVALID_CUSTOMER_ID = "";
    private static final String INVALID_REWARD_POINTS = "-100";
    private static final String INVALID_VISIT_COUNT = "-5";
    private static final String INVALID_TOTAL_SPENT = "-50.00";

    @Test
    public void toModelType_validCustomerDetails_returnsCustomer() throws Exception {
        JsonAdaptedCustomer customer = new JsonAdaptedCustomer(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_CUSTOMER_ID, VALID_REWARD_POINTS, VALID_VISIT_COUNT,
                VALID_FAVOURITE_ITEM, VALID_TOTAL_SPENT);
        Customer modelCustomer = customer.toModelType();
        assertEquals(VALID_NAME, modelCustomer.getName().fullName);
        assertEquals(VALID_PHONE, modelCustomer.getPhone().value);
        assertEquals(VALID_EMAIL, modelCustomer.getEmail().value);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedCustomer customer = new JsonAdaptedCustomer(null, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_CUSTOMER_ID, VALID_REWARD_POINTS, VALID_VISIT_COUNT,
                VALID_FAVOURITE_ITEM, VALID_TOTAL_SPENT);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        IllegalValueException exception = assertThrows(IllegalValueException.class, customer::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedCustomer customer = new JsonAdaptedCustomer(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_CUSTOMER_ID, VALID_REWARD_POINTS, VALID_VISIT_COUNT,
                VALID_FAVOURITE_ITEM, VALID_TOTAL_SPENT);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        IllegalValueException exception = assertThrows(IllegalValueException.class, customer::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedCustomer customer = new JsonAdaptedCustomer(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_CUSTOMER_ID, VALID_REWARD_POINTS, VALID_VISIT_COUNT,
                VALID_FAVOURITE_ITEM, VALID_TOTAL_SPENT);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        IllegalValueException exception = assertThrows(IllegalValueException.class, customer::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_invalidCustomerId_throwsIllegalValueException() {
        JsonAdaptedCustomer customer = new JsonAdaptedCustomer(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, INVALID_CUSTOMER_ID, VALID_REWARD_POINTS, VALID_VISIT_COUNT,
                VALID_FAVOURITE_ITEM, VALID_TOTAL_SPENT);
        String expectedMessage = CustomerId.MESSAGE_CONSTRAINTS;
        IllegalValueException exception = assertThrows(IllegalValueException.class, customer::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_invalidRewardPoints_throwsIllegalValueException() {
        JsonAdaptedCustomer customer = new JsonAdaptedCustomer(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_CUSTOMER_ID, INVALID_REWARD_POINTS, VALID_VISIT_COUNT,
                VALID_FAVOURITE_ITEM, VALID_TOTAL_SPENT);
        String expectedMessage = RewardPoints.MESSAGE_CONSTRAINTS;
        IllegalValueException exception = assertThrows(IllegalValueException.class, customer::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_invalidVisitCount_throwsIllegalValueException() {
        JsonAdaptedCustomer customer = new JsonAdaptedCustomer(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_CUSTOMER_ID, VALID_REWARD_POINTS, INVALID_VISIT_COUNT,
                VALID_FAVOURITE_ITEM, VALID_TOTAL_SPENT);
        String expectedMessage = VisitCount.MESSAGE_CONSTRAINTS;
        IllegalValueException exception = assertThrows(IllegalValueException.class, customer::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void toModelType_invalidTotalSpent_throwsIllegalValueException() {
        JsonAdaptedCustomer customer = new JsonAdaptedCustomer(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_TAGS, VALID_CUSTOMER_ID, VALID_REWARD_POINTS, VALID_VISIT_COUNT,
                VALID_FAVOURITE_ITEM, INVALID_TOTAL_SPENT);
        String expectedMessage = TotalSpent.MESSAGE_CONSTRAINTS;
        IllegalValueException exception = assertThrows(IllegalValueException.class, customer::toModelType);
        assertEquals(expectedMessage, exception.getMessage());
    }
}
