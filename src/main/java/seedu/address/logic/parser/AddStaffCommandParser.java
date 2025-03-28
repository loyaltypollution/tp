package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HOURS_WORKED;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PERFORMANCE_RATING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SHIFT_TIMING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STAFF_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddStaffCommand;
import seedu.address.logic.parser.exceptions.ParseException;
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

/**
 * Parses input arguments and creates a new AddStaffCommand object
 */
public class AddStaffCommandParser implements Parser<AddStaffCommand> {

    private static final String DEFAULT_EMAIL = "default@gmail.com";
    private static final String DEFAULT_ADDRESS = "empty";
    private static final String DEFAULT_REMARK = "";
    private static final String DEFAULT_ROLE = "Full Time worker";
    private static final String DEFAULT_SHIFT_TIMING = "9am-5pm";
    private static final String DEFAULT_HOURS_WORKED = "0";
    private static final String DEFAULT_PERFORMANCE_RATING = "0";

    /**
     * Parses the given {@code String} of arguments in the context of the AddStaffCommand
     * and returns an AddStaffCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public AddStaffCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();

        // Fast add format: <staffId>:<name>:<phone>
        if (trimmedArgs.matches("^[^\\s:]+:[^\\s:]+:[^\\s:]+$")) {
            String[] staffInfo = trimmedArgs.split(":");

            if (staffInfo.length != 3) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddStaffCommand.MESSAGE_USAGE));
            }

            StaffId staffId = ParserUtil.parseStaffId(staffInfo[0]);
            Name name = ParserUtil.parseName(staffInfo[1]);
            Phone phone = ParserUtil.parsePhone(staffInfo[2]);

            Email email = new Email(DEFAULT_EMAIL);
            Address address = new Address(DEFAULT_ADDRESS);
            Remark remark = new Remark(DEFAULT_REMARK);
            Set<Tag> tagList = Set.of();

            Role role = new Role(DEFAULT_ROLE);
            ShiftTiming shiftTiming = new ShiftTiming(DEFAULT_SHIFT_TIMING);
            HoursWorked hoursWorked = new HoursWorked(DEFAULT_HOURS_WORKED);
            PerformanceRating performanceRating = new PerformanceRating(DEFAULT_PERFORMANCE_RATING);

            Staff staff = new Staff(name, phone, email, address, remark, tagList,
                    staffId, role, shiftTiming, hoursWorked, performanceRating);

            return new AddStaffCommand(staff);
        }

        // Default behavior for other cases (where user provides all fields)
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args,
                PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TAG,
                PREFIX_STAFF_ID, PREFIX_ROLE, PREFIX_SHIFT_TIMING, PREFIX_HOURS_WORKED, PREFIX_PERFORMANCE_RATING);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL,
                PREFIX_STAFF_ID, PREFIX_ROLE, PREFIX_SHIFT_TIMING, PREFIX_HOURS_WORKED, PREFIX_PERFORMANCE_RATING)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddStaffCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
                PREFIX_STAFF_ID, PREFIX_ROLE, PREFIX_SHIFT_TIMING, PREFIX_HOURS_WORKED, PREFIX_PERFORMANCE_RATING);

        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());
        Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get());
        Remark remark = new Remark(""); // still no remarks at creation
        Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));

        StaffId staffId = ParserUtil.parseStaffId(argMultimap.getValue(PREFIX_STAFF_ID).get());
        Role role = ParserUtil.parseRole(argMultimap.getValue(PREFIX_ROLE).get());
        ShiftTiming shiftTiming = ParserUtil.parseShiftTiming(argMultimap.getValue(PREFIX_SHIFT_TIMING).get());
        HoursWorked hoursWorked = ParserUtil.parseHoursWorked(argMultimap.getValue(PREFIX_HOURS_WORKED).get());
        PerformanceRating performanceRating = ParserUtil.parsePerformanceRating(
                argMultimap.getValue(PREFIX_PERFORMANCE_RATING).get());

        Staff staff = new Staff(name, phone, email, address, remark, tagList,
                staffId, role, shiftTiming, hoursWorked, performanceRating);

        return new AddStaffCommand(staff);
    }


    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
