package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
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
 * Jackson-friendly version of {@link Staff}.
 */
class JsonAdaptedStaff {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Staff's Staff ID field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final String remark;
    private final List<JsonAdaptedTag> tags = new ArrayList<>();

    // Staff-specific fields
    private final String staffId;
    private final String role;
    private final String shiftTiming;
    private final String hoursWorked;
    private final String performanceRating;

    /**
     * Constructs a {@code JsonAdaptedStaff} with the given staff details.
     */
    @JsonCreator
    public JsonAdaptedStaff(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                            @JsonProperty("email") String email, @JsonProperty("address") String address,
                            @JsonProperty("remark") String remark, @JsonProperty("tags") List<JsonAdaptedTag> tags,
                            @JsonProperty("staffId") String staffId, @JsonProperty("role") String role,
                            @JsonProperty("shiftTiming") String shiftTiming,
                            @JsonProperty("hoursWorked") String hoursWorked,
                            @JsonProperty("performanceRating") String performanceRating) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.remark = remark;
        if (tags != null) {
            this.tags.addAll(tags);
        }
        this.staffId = staffId;
        this.role = role;
        this.shiftTiming = shiftTiming;
        this.hoursWorked = hoursWorked;
        this.performanceRating = performanceRating;
    }

    /**
     * Converts a given {@code Staff} into this class for Jackson use.
     */
    public JsonAdaptedStaff(Staff source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        remark = source.getRemark().value;
        tags.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
        staffId = source.getStaffId().value;
        role = source.getRole().value;
        shiftTiming = source.getShiftTiming().value;
        hoursWorked = source.getHoursWorked().value;
        performanceRating = source.getPerformanceRating().value;
    }

    /**
     * Converts this Jackson-friendly adapted staff object into the model's {@code Staff} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted staff.
     */
    public Staff toModelType() throws IllegalValueException {
        final List<Tag> staffTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tags) {
            staffTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidValue(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidValue(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidValue(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidValue(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        if (remark == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Remark.class.getSimpleName()));
        }
        final Remark modelRemark = new Remark(remark);

        if (staffId == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, StaffId.class.getSimpleName()));
        }
        if (!StaffId.isValidValue(staffId)) {
            throw new IllegalValueException(StaffId.MESSAGE_CONSTRAINTS);
        }
        final StaffId modelStaffId = new StaffId(staffId);

        if (role == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Role.class.getSimpleName()));
        }
        if (!Role.isValidValue(role)) {
            throw new IllegalValueException(Role.MESSAGE_CONSTRAINTS);
        }
        final Role modelRole = new Role(role);

        if (shiftTiming == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ShiftTiming.class.getSimpleName()));
        }
        if (!ShiftTiming.isValidValue(shiftTiming)) {
            throw new IllegalValueException(ShiftTiming.MESSAGE_CONSTRAINTS);
        }
        final ShiftTiming modelShiftTiming = new ShiftTiming(shiftTiming);

        if (hoursWorked == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Hours Worked"));
        }
        if (!HoursWorked.isValidValue(hoursWorked)) {
            throw new IllegalValueException(HoursWorked.MESSAGE_CONSTRAINTS);
        }
        final HoursWorked modelHoursWorked = new HoursWorked(hoursWorked);

        if (performanceRating == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Performance Rating"));
        }
        if (!PerformanceRating.isValidValue(performanceRating)) {
            throw new IllegalValueException(PerformanceRating.MESSAGE_CONSTRAINTS);
        }
        final PerformanceRating modelPerformanceRating = new PerformanceRating(performanceRating);


        final Set<Tag> modelTags = new HashSet<>(staffTags);
        return new Staff(modelName, modelPhone, modelEmail, modelAddress, modelRemark, modelTags,
                modelStaffId, modelRole, modelShiftTiming, modelHoursWorked, modelPerformanceRating);
    }
}
