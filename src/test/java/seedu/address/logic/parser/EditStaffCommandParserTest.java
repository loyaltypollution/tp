package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.HOURS_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_ADDRESS_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_PHONE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_BEN;
import static seedu.address.logic.commands.CommandTestUtil.RATING_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.ROLE_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.SHIFT_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.STAFF_ID_DESC_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_HOURS_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BEN;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RATING_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROLE_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SHIFT_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STAFF_ID_ALEX;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_THIRD_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.EditStaffCommand;
import seedu.address.logic.parser.descriptors.EditStaffDescriptor;
import seedu.address.model.person.fields.Address;
import seedu.address.model.person.fields.Email;
import seedu.address.model.person.fields.Name;
import seedu.address.model.person.fields.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.EditStaffDescriptorBuilder;

public class EditStaffCommandParserTest {

    private static final String TAG_EMPTY = " " + PREFIX_TAG;

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditStaffCommand.MESSAGE_USAGE);

    private EditStaffCommandParser parser = new EditStaffCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // no index specified
        assertParseFailure(parser, VALID_NAME_ALEX, MESSAGE_INVALID_FORMAT);

        // no field specified
        assertParseFailure(parser, "1", EditStaffCommand.MESSAGE_NOT_EDITED);

        // no index and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5" + NAME_DESC_ALEX, MESSAGE_INVALID_FORMAT);

        // zero index
        assertParseFailure(parser, "0" + NAME_DESC_ALEX, MESSAGE_INVALID_FORMAT);

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "1" + INVALID_NAME_DESC, Name.MESSAGE_CONSTRAINTS); // invalid name
        assertParseFailure(parser, "1" + INVALID_PHONE_DESC, Phone.MESSAGE_CONSTRAINTS); // invalid phone
        assertParseFailure(parser, "1" + INVALID_EMAIL_DESC, Email.MESSAGE_CONSTRAINTS); // invalid email
        assertParseFailure(parser, "1" + INVALID_ADDRESS_DESC, Address.MESSAGE_CONSTRAINTS); // invalid address
        assertParseFailure(parser, "1" + INVALID_TAG_DESC, Tag.MESSAGE_CONSTRAINTS); // invalid tag

        // invalid phone followed by valid email
        assertParseFailure(parser, "1" + INVALID_PHONE_DESC + EMAIL_DESC_ALEX, Phone.MESSAGE_CONSTRAINTS);

        // while parsing {@code PREFIX_TAG} alone will reset the tags of the {@code Person} being edited,
        // parsing it together with a valid tag results in error
        assertParseFailure(parser, "1" + TAG_DESC_FRIEND + TAG_DESC_HUSBAND + TAG_EMPTY, Tag.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "1" + TAG_DESC_FRIEND + TAG_EMPTY + TAG_DESC_HUSBAND, Tag.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "1" + TAG_EMPTY + TAG_DESC_FRIEND + TAG_DESC_HUSBAND, Tag.MESSAGE_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
        assertParseFailure(parser, "1" + INVALID_NAME_DESC + INVALID_EMAIL_DESC + VALID_ADDRESS_ALEX + VALID_PHONE_ALEX,
                Name.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_allFieldsSpecified_success() {
        Index targetIndex = INDEX_SECOND_PERSON;
        String userInput = targetIndex.getOneBased() + PHONE_DESC_BEN + TAG_DESC_HUSBAND
                + EMAIL_DESC_ALEX + ADDRESS_DESC_ALEX + NAME_DESC_ALEX + TAG_DESC_FRIEND
                + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX + SHIFT_DESC_ALEX
                + HOURS_DESC_ALEX + RATING_DESC_ALEX;

        EditStaffDescriptor descriptor = new EditStaffDescriptorBuilder().withName(VALID_NAME_ALEX)
                .withPhone(VALID_PHONE_BEN).withEmail(VALID_EMAIL_ALEX).withAddress(VALID_ADDRESS_ALEX)
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
                .withStaffId(VALID_STAFF_ID_ALEX).withRole(VALID_ROLE_ALEX)
                .withShiftTiming(VALID_SHIFT_ALEX).withHoursWorked(VALID_HOURS_ALEX)
                .withPerformanceRating(VALID_RATING_ALEX).build();
        EditStaffCommand expectedCommand = new EditStaffCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_someFieldsSpecified_success() {
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + PHONE_DESC_BEN + EMAIL_DESC_ALEX
                + STAFF_ID_DESC_ALEX + ROLE_DESC_ALEX;

        EditStaffDescriptor descriptor = new EditStaffDescriptorBuilder().withPhone(VALID_PHONE_BEN)
                .withEmail(VALID_EMAIL_ALEX).withStaffId(VALID_STAFF_ID_ALEX)
                .withRole(VALID_ROLE_ALEX).build();
        EditStaffCommand expectedCommand = new EditStaffCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_oneFieldSpecified_success() {
        Index targetIndex = INDEX_THIRD_PERSON;

        // staffId
        String userInput = targetIndex.getOneBased() + STAFF_ID_DESC_ALEX;
        EditStaffDescriptor descriptor = new EditStaffDescriptorBuilder().withStaffId(VALID_STAFF_ID_ALEX).build();
        EditStaffCommand expectedCommand = new EditStaffCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // role
        userInput = targetIndex.getOneBased() + ROLE_DESC_ALEX;
        descriptor = new EditStaffDescriptorBuilder().withRole(VALID_ROLE_ALEX).build();
        expectedCommand = new EditStaffCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // shiftTiming
        userInput = targetIndex.getOneBased() + SHIFT_DESC_ALEX;
        descriptor = new EditStaffDescriptorBuilder().withShiftTiming(VALID_SHIFT_ALEX).build();
        expectedCommand = new EditStaffCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // hoursWorked
        userInput = targetIndex.getOneBased() + HOURS_DESC_ALEX;
        descriptor = new EditStaffDescriptorBuilder().withHoursWorked(VALID_HOURS_ALEX).build();
        expectedCommand = new EditStaffCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // performanceRating
        userInput = targetIndex.getOneBased() + RATING_DESC_ALEX;
        descriptor = new EditStaffDescriptorBuilder().withPerformanceRating(VALID_RATING_ALEX).build();
        expectedCommand = new EditStaffCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_multipleRepeatedFields_failure() {
        // More extensive testing of duplicate parameter detections is done in
        // AddCommandParserTest#parse_repeatedNonTagValue_failure()

        // valid followed by invalid
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + INVALID_PHONE_DESC + PHONE_DESC_BEN;

        assertParseFailure(parser, userInput, Messages.getErrorMessageForDuplicatePrefixes(PREFIX_PHONE));

        // invalid followed by valid
        userInput = targetIndex.getOneBased() + PHONE_DESC_BEN + INVALID_PHONE_DESC;

        assertParseFailure(parser, userInput, Messages.getErrorMessageForDuplicatePrefixes(PREFIX_PHONE));

        // mulltiple valid fields repeated
        userInput = targetIndex.getOneBased() + PHONE_DESC_ALEX + ADDRESS_DESC_ALEX + EMAIL_DESC_ALEX
                + TAG_DESC_FRIEND + PHONE_DESC_ALEX + ADDRESS_DESC_ALEX + EMAIL_DESC_ALEX + TAG_DESC_FRIEND
                + PHONE_DESC_BEN + ADDRESS_DESC_BEN + EMAIL_DESC_BEN + TAG_DESC_HUSBAND;

        assertParseFailure(parser, userInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS));

        // multiple invalid values
        userInput = targetIndex.getOneBased() + INVALID_PHONE_DESC + INVALID_ADDRESS_DESC + INVALID_EMAIL_DESC
                + INVALID_PHONE_DESC + INVALID_ADDRESS_DESC + INVALID_EMAIL_DESC;

        assertParseFailure(parser, userInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS));
    }

    @Test
    public void parse_resetFields_success() {
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + TAG_EMPTY;

        EditStaffDescriptor descriptor = new EditStaffDescriptorBuilder().withTags().build();
        EditStaffCommand expectedCommand = new EditStaffCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }
}
