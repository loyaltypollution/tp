package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DRINKNAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REDEEM;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.PurchaseCommand;

public class PurchaseCommandParserTest {
    private PurchaseCommandParser parser = new PurchaseCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        String drinkName = "Matcha";
        Index targetIndex = INDEX_FIRST_PERSON;

        // Standard case
        String userInput = " 1 " + PREFIX_DRINKNAME + drinkName;
        PurchaseCommand expectedCommand = new PurchaseCommand(targetIndex, drinkName, false);
        assertParseSuccess(parser, userInput, expectedCommand);

        // With redemption flag = true
        userInput = " 1 " + PREFIX_DRINKNAME + drinkName + " " + PREFIX_REDEEM + "true";
        expectedCommand = new PurchaseCommand(targetIndex, drinkName, true);
        assertParseSuccess(parser, userInput, expectedCommand);

        // With redemption flag = false
        userInput = " 1 " + PREFIX_DRINKNAME + drinkName + " " + PREFIX_REDEEM + "false";
        expectedCommand = new PurchaseCommand(targetIndex, drinkName, false);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, PurchaseCommand.MESSAGE_USAGE);

        // Missing index
        assertParseFailure(parser, PREFIX_DRINKNAME + "Matcha", expectedMessage);

        // Missing drink name
        assertParseFailure(parser, "1", expectedMessage);

        // Empty string
        assertParseFailure(parser, "", expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // Invalid redemption value
        assertParseFailure(parser, " 1 " + PREFIX_DRINKNAME + "Matcha " + PREFIX_REDEEM + "yes",
                "Boolean value must be 'true' or 'false'");
    }
    @Test
    public void parse_invalidPreamble_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, PurchaseCommand.MESSAGE_USAGE);

        // Non-integer index
        assertParseFailure(parser, " abc " + PREFIX_DRINKNAME + "Matcha", expectedMessage);
    }
}
