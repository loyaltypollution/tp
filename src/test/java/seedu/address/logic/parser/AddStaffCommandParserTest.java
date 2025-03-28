package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.HOURS_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.HOURS_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_ADDRESS_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_PHONE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.RATING_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.RATING_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.ROLE_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.ROLE_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.SHIFT_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.SHIFT_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.STAFF_ID_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.STAFF_ID_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_MANAGER;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_HOURS_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RATING_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROLE_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SHIFT_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STAFF_ID_ALEX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HOURS_WORKED;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PERFORMANCE_RATING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SHIFT_TIMING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STAFF_ID;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.AddStaffCommand;
import seedu.address.model.person.fields.Address;
import seedu.address.model.person.fields.Email;
import seedu.address.model.person.fields.HoursWorked;
import seedu.address.model.person.fields.Name;
import seedu.address.model.person.fields.PerformanceRating;
import seedu.address.model.person.fields.Phone;
import seedu.address.model.person.fields.Remark;
import seedu.address.model.person.fields.Role;
import seedu.address.model.person.fields.ShiftTiming;
import seedu.address.model.person.Staff;
import seedu.address.model.person.fields.StaffId;
import seedu.address.model.tag.Tag;

public class AddStaffCommandParserTest {
    private AddStaffCommandParser parser = new AddStaffCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        String userInput = NAME_DESC_ALEX + PHONE_DESC_ALEX + EMAIL_DESC_ALEX + ADDRESS_DESC_ALEX
                + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX
                + TAG_DESC_MANAGER;

        AddStaffCommand expectedCommand = new AddStaffCommand(
                new Staff(new Name(VALID_NAME_ALEX),
                        new Phone(VALID_PHONE_ALEX),
                        new Email(VALID_EMAIL_ALEX),
                        new Address(VALID_ADDRESS_ALEX),
                        new Remark(""),
                        Set.of(new Tag("manager")),
                        new StaffId(VALID_STAFF_ID_ALEX),
                        new Role(VALID_ROLE_ALEX),
                        new ShiftTiming(VALID_SHIFT_ALEX),
                        new HoursWorked(VALID_HOURS_ALEX),
                        new PerformanceRating(VALID_RATING_ALEX)));

        assertParseSuccess(parser, userInput, expectedCommand);
    }


    @Test
    public void parse_repeatedNonTagValue_failure() {
        String validExpectedStaffString = NAME_DESC_ALEX + PHONE_DESC_ALEX + EMAIL_DESC_ALEX
                + ADDRESS_DESC_ALEX + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX
                + HOURS_DESC_ALEX + RATING_DESC_ALEX + TAG_DESC_MANAGER;

        // multiple names
        assertParseFailure(parser, NAME_DESC_BEN + validExpectedStaffString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_NAME));

        // multiple phones
        assertParseFailure(parser, PHONE_DESC_BEN + validExpectedStaffString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_PHONE));

        // multiple emails
        assertParseFailure(parser, EMAIL_DESC_BEN + validExpectedStaffString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_EMAIL));

        // multiple addresses
        assertParseFailure(parser, ADDRESS_DESC_BEN + validExpectedStaffString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_ADDRESS));

        // multiple staff IDs
        assertParseFailure(parser, STAFF_ID_DESC_BEN + validExpectedStaffString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_STAFF_ID));

        // multiple roles
        assertParseFailure(parser, ROLE_DESC_BEN + validExpectedStaffString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_ROLE));

        // multiple shift timings
        assertParseFailure(parser, SHIFT_DESC_BEN + validExpectedStaffString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_SHIFT_TIMING));

        // multiple fields repeated
        assertParseFailure(parser, validExpectedStaffString + PHONE_DESC_BEN + EMAIL_DESC_BEN + NAME_DESC_BEN
                        + ADDRESS_DESC_BEN + STAFF_ID_DESC_BEN + ROLE_DESC_BEN + SHIFT_DESC_BEN + HOURS_DESC_BEN
                        + RATING_DESC_BEN + validExpectedStaffString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_NAME, PREFIX_ADDRESS, PREFIX_EMAIL, PREFIX_PHONE,
                        PREFIX_STAFF_ID, PREFIX_ROLE, PREFIX_SHIFT_TIMING, PREFIX_HOURS_WORKED,
                        PREFIX_PERFORMANCE_RATING));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddStaffCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, VALID_NAME_ALEX + PHONE_DESC_ALEX + EMAIL_DESC_ALEX + ADDRESS_DESC_ALEX
                        + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX,
                expectedMessage);

        // missing phone prefix
        assertParseFailure(parser, NAME_DESC_ALEX + VALID_PHONE_ALEX + EMAIL_DESC_ALEX + ADDRESS_DESC_ALEX
                        + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX,
                expectedMessage);

        // missing email prefix
        assertParseFailure(parser, NAME_DESC_ALEX + PHONE_DESC_ALEX + VALID_EMAIL_ALEX + ADDRESS_DESC_ALEX
                        + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX,
                expectedMessage);

        // missing staff ID prefix
        assertParseFailure(parser, NAME_DESC_ALEX + PHONE_DESC_ALEX + EMAIL_DESC_ALEX + ADDRESS_DESC_ALEX
                        + VALID_STAFF_ID_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX,
                expectedMessage);

        // missing role prefix
        assertParseFailure(parser, NAME_DESC_ALEX + PHONE_DESC_ALEX + EMAIL_DESC_ALEX + ADDRESS_DESC_ALEX
                        + STAFF_ID_DESC_ALEX + VALID_ROLE_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + PHONE_DESC_ALEX + EMAIL_DESC_ALEX + ADDRESS_DESC_ALEX
                        + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX,
                Name.MESSAGE_CONSTRAINTS);

        // invalid phone
        assertParseFailure(parser, NAME_DESC_ALEX + INVALID_PHONE_DESC + EMAIL_DESC_ALEX + ADDRESS_DESC_ALEX
                        + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX,
                Phone.MESSAGE_CONSTRAINTS);

        // invalid email
        assertParseFailure(parser, NAME_DESC_ALEX + PHONE_DESC_ALEX + INVALID_EMAIL_DESC + ADDRESS_DESC_ALEX
                        + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX,
                Email.MESSAGE_CONSTRAINTS);

        // invalid address
        assertParseFailure(parser, NAME_DESC_ALEX + PHONE_DESC_ALEX + EMAIL_DESC_ALEX + INVALID_ADDRESS_DESC
                        + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX,
                Address.MESSAGE_CONSTRAINTS);

        // invalid tag
        assertParseFailure(parser, NAME_DESC_ALEX + PHONE_DESC_ALEX + EMAIL_DESC_ALEX + ADDRESS_DESC_ALEX
                + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX + RATING_DESC_ALEX
                + INVALID_TAG_DESC, Tag.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_ALEX + PHONE_DESC_ALEX + EMAIL_DESC_ALEX
                + ADDRESS_DESC_ALEX + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX + HOURS_DESC_ALEX
                + RATING_DESC_ALEX, String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddStaffCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validFastAdd_success() {
        String userInput = "S0101:John:92012012"; // Simulating fast-add format

        // Define the expected AddStaffCommand with the correct default values
        AddStaffCommand expectedCommand = new AddStaffCommand(
                new Staff(
                        new Name("John"),
                        new Phone("92012012"),
                        new Email("default@gmail.com"),
                        new Address("empty"),
                        new Remark(""),
                        Set.of(),
                        new StaffId("S0101"),
                        new Role("Full Time worker"),
                        new ShiftTiming("9am-5pm"),
                        new HoursWorked("0"),
                        new PerformanceRating("0")
                )
        );

        // Assert that the parsed command matches the expected command
        assertParseSuccess(parser, userInput, expectedCommand);
    }


}
