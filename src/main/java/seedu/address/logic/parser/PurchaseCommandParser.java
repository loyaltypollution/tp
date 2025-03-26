package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DRINKNAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REDEEM;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.PurchaseCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new PurchaseCommand object
 */
public class PurchaseCommandParser implements Parser<PurchaseCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the PurchaseCommand
     * and returns a PurchaseCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public PurchaseCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(
                args, PREFIX_DRINKNAME, PREFIX_REDEEM);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, PurchaseCommand.MESSAGE_USAGE), pe);
        }

        if (!argMultimap.getValue(PREFIX_DRINKNAME).isPresent()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, PurchaseCommand.MESSAGE_USAGE));
        }

        String drinkName = argMultimap.getValue(PREFIX_DRINKNAME).get();
        boolean isRedemption = false;

        if (argMultimap.getValue(PREFIX_REDEEM).isPresent()) {
            try {
                isRedemption = ParserUtil.parseBoolean(argMultimap.getValue(PREFIX_REDEEM).get());
            } catch (ParseException pe) {
                throw new ParseException(pe.getMessage(), pe);
            }
        }

        return new PurchaseCommand(index, drinkName, isRedemption);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
