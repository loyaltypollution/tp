package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

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
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Staff objects.
 */
public class StaffBuilder {

    public static final String DEFAULT_NAME = "Alex Tan";
    public static final String DEFAULT_PHONE = "91234567";
    public static final String DEFAULT_EMAIL = "alex.tan@example.com";
    public static final String DEFAULT_ADDRESS = "456, Bukit Timah Road, #12-34";
    public static final String DEFAULT_REMARK = "Punctual and hardworking.";
    public static final String DEFAULT_STAFF_ID = "S1001";
    public static final String DEFAULT_ROLE = "Barista";
    public static final String DEFAULT_SHIFT_TIMING = "8am-4pm";
    public static final String DEFAULT_HOURS_WORKED = "40";
    public static final String DEFAULT_PERFORMANCE_RATING = "4.5";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Remark remark;
    private Set<Tag> tags;
    private StaffId staffId;
    private Role role;
    private ShiftTiming shiftTiming;
    private HoursWorked hoursWorked;
    private PerformanceRating performanceRating;

    /**
     * Creates a {@code StaffBuilder} with the default details.
     */
    public StaffBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        remark = new Remark(DEFAULT_REMARK);
        tags = new HashSet<>();
        staffId = new StaffId(DEFAULT_STAFF_ID);
        role = new Role(DEFAULT_ROLE);
        shiftTiming = new ShiftTiming(DEFAULT_SHIFT_TIMING);
        hoursWorked = new HoursWorked(DEFAULT_HOURS_WORKED);
        performanceRating = new PerformanceRating(DEFAULT_PERFORMANCE_RATING);
    }

    /**
     * Initializes the StaffBuilder with the data of {@code staffToCopy}.
     */
    public StaffBuilder(Staff staffToCopy) {
        name = staffToCopy.getName();
        phone = staffToCopy.getPhone();
        email = staffToCopy.getEmail();
        address = staffToCopy.getAddress();
        remark = staffToCopy.getRemark();
        tags = new HashSet<>(staffToCopy.getTags());
        staffId = staffToCopy.getStaffId();
        role = staffToCopy.getRole();
        shiftTiming = staffToCopy.getShiftTiming();
        hoursWorked = staffToCopy.getHoursWorked();
        performanceRating = staffToCopy.getPerformanceRating();
    }

    /**
     * Sets the {@code Name} of the {@code Staff} that we are building.
     */
    public StaffBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Staff} that we are building.
     */
    public StaffBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public StaffBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Staff} that we are building.
     */
    public StaffBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Staff} that we are building.
     */
    public StaffBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public StaffBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Staff} that we are building.
     */
    public StaffBuilder withStaffId(String staffId) {
        this.staffId = new StaffId(staffId);
        return this;
    }

    /**
     * Sets the {@code Role} of the {@code Staff} that we are building.
     */
    public StaffBuilder withRole(String role) {
        this.role = new Role(role);
        return this;
    }

    /**
     * Sets the {@code ShiftTiming} of the {@code Staff} that we are building.
     */
    public StaffBuilder withShiftTiming(String shiftTiming) {
        this.shiftTiming = new ShiftTiming(shiftTiming);
        return this;
    }

    /**
     * Sets the {@code HoursWorked} of the {@code Staff} that we are building.
     */
    public StaffBuilder withHoursWorked(String hoursWorked) {
        this.hoursWorked = new HoursWorked(hoursWorked);
        return this;
    }

    /**
     * Sets the {@code PerformanceRating} of the {@code Staff} that we are building.
     */
    public StaffBuilder withPerformanceRating(String performanceRating) {
        this.performanceRating = new PerformanceRating(performanceRating);
        return this;
    }

    /**
     * Builds the staff with the information altogether.
     */
    public Staff build() {
        return new Staff(name, phone, email, address, remark, tags,
                staffId, role, shiftTiming, hoursWorked, performanceRating);
    }
}
