package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.fields.Address;
import seedu.address.model.person.fields.CustomerId;
import seedu.address.model.person.fields.Email;
import seedu.address.model.person.fields.HoursWorked;
import seedu.address.model.person.fields.Name;
import seedu.address.model.person.fields.PerformanceRating;
import seedu.address.model.person.fields.Phone;
import seedu.address.model.person.fields.Remark;
import seedu.address.model.person.fields.RewardPoints;
import seedu.address.model.person.fields.Role;
import seedu.address.model.person.fields.ShiftTiming;
import seedu.address.model.person.fields.StaffId;
import seedu.address.model.person.fields.TotalSpent;
import seedu.address.model.person.fields.VisitCount;
import seedu.address.model.person.fields.FavouriteItem;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidValue(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidValue(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidValue(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String remark} into a {@code Remark}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code remark} is invalid.
     */
    public static Remark parseRemark(String remark) throws ParseException {
        requireNonNull(remark);
        String trimmedRemark = remark.trim();
        if (!Remark.isValidValue(trimmedRemark)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Remark(trimmedRemark);
    }


    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidValue(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidValue(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
    /**
     * Parses a {@code String rewardPoints} into a {@code RewardPoints}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code rewardPoints} is invalid.
     */
    public static RewardPoints parseRewardPoints(String rewardPoints) throws ParseException {
        requireNonNull(rewardPoints);
        String trimmedRewardPoints = rewardPoints.trim();
        if (!RewardPoints.isValidValue(trimmedRewardPoints)) {
            throw new ParseException(RewardPoints.MESSAGE_CONSTRAINTS);
        }
        return new RewardPoints(trimmedRewardPoints);
    }

    /**
     * Parses a {@code String visitCount} into a {@code VisitCount}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code visitCount} is invalid.
     */
    public static VisitCount parseVisitCount(String visitCount) throws ParseException {
        requireNonNull(visitCount);
        String trimmedVisitCount = visitCount.trim();
        if (!VisitCount.isValidValue(trimmedVisitCount)) {
            throw new ParseException(VisitCount.MESSAGE_CONSTRAINTS);
        }
        return new VisitCount(trimmedVisitCount);
    }

    /**
     * Parses a {@code String favouriteItem} into a {@code FavouriteItem}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code favouriteItem} is invalid.
     */
    public static FavouriteItem parseFavouriteItem(String favouriteItem) throws ParseException {
        requireNonNull(favouriteItem);
        String trimmedFavouriteItem = favouriteItem.trim();
        if (!FavouriteItem.isValidValue(trimmedFavouriteItem)) {
            throw new ParseException(FavouriteItem.MESSAGE_CONSTRAINTS);
        }
        return new FavouriteItem(trimmedFavouriteItem);
    }

    /**
     * Parses a {@code String totalSpent} into a {@code TotalSpent}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code totalSpent} is invalid.
     */
    public static TotalSpent parseTotalSpent(String totalSpent) throws ParseException {
        requireNonNull(totalSpent);
        String trimmedTotalSpent = totalSpent.trim();
        if (!TotalSpent.isValidValue(trimmedTotalSpent)) {
            throw new ParseException(TotalSpent.MESSAGE_CONSTRAINTS);
        }
        return new TotalSpent(trimmedTotalSpent);
    }

    /**
     * Parses a {@code String customerId} into a {@code CustomerId}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code staffId} is invalid.
     */
    public static CustomerId parseCustomerId(String customerId) throws ParseException {
        requireNonNull(customerId);
        String trimmedCustomerId = customerId.trim();
        if (!CustomerId.isValidValue(trimmedCustomerId)) {
            throw new ParseException(CustomerId.MESSAGE_CONSTRAINTS);
        }
        return new CustomerId(trimmedCustomerId);
    }

    /**
     * Parses a {@code String staffId} into a {@code StaffId}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code staffId} is invalid.
     */
    public static StaffId parseStaffId(String staffId) throws ParseException {
        requireNonNull(staffId);
        String trimmedStaffId = staffId.trim();
        if (!StaffId.isValidValue(trimmedStaffId)) {
            throw new ParseException(StaffId.MESSAGE_CONSTRAINTS);
        }
        return new StaffId(trimmedStaffId);
    }

    /**
     * Parses a {@code String role} into a {@code Role}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code role} is invalid.
     */
    public static Role parseRole(String role) throws ParseException {
        requireNonNull(role);
        String trimmedRole = role.trim();
        if (!Role.isValidValue(trimmedRole)) {
            throw new ParseException(Role.MESSAGE_CONSTRAINTS);
        }
        return new Role(trimmedRole);
    }

    /**
     * Parses a {@code String shiftTiming} into a {@code ShiftTiming}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code shiftTiming} is invalid.
     */
    public static ShiftTiming parseShiftTiming(String shiftTiming) throws ParseException {
        requireNonNull(shiftTiming);
        String trimmedShiftTiming = shiftTiming.trim();
        if (!ShiftTiming.isValidValue(trimmedShiftTiming)) {
            throw new ParseException(ShiftTiming.MESSAGE_CONSTRAINTS);
        }
        return new ShiftTiming(trimmedShiftTiming);
    }

    /**
     * Parses a {@code String hoursWorked} into a {@code HoursWorked}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code hoursWorked} is invalid.
     */
    public static HoursWorked parseHoursWorked(String hoursWorked) throws ParseException {
        requireNonNull(hoursWorked);
        String trimmedHoursWorked = hoursWorked.trim();
        if (!HoursWorked.isValidValue(trimmedHoursWorked)) {
            throw new ParseException(HoursWorked.MESSAGE_CONSTRAINTS);
        }
        return new HoursWorked(trimmedHoursWorked);
    }

    /**
     * Parses a {@code String performanceRating} into a {@code PerformanceRating}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code performanceRating} is invalid.
     */
    public static PerformanceRating parsePerformanceRating(String performanceRating) throws ParseException {
        requireNonNull(performanceRating);
        String trimmedPerformanceRating = performanceRating.trim();
        if (!PerformanceRating.isValidValue(trimmedPerformanceRating)) {
            throw new ParseException(PerformanceRating.MESSAGE_CONSTRAINTS);
        }
        return new PerformanceRating(trimmedPerformanceRating);
    }

    /**
     * Parses a {@code String boolean} into a {@code boolean}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code boolean} is invalid.
     */
    public static boolean parseBoolean(String bool) throws ParseException {
        String trimmedBool = bool.trim();
        if (!trimmedBool.equalsIgnoreCase("true") && !trimmedBool.equalsIgnoreCase("false")) {
            throw new ParseException("Boolean value must be 'true' or 'false'");
        }
        return Boolean.parseBoolean(trimmedBool);
    }


}
