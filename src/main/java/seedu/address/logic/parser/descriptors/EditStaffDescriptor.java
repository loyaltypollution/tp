package seedu.address.logic.parser.descriptors;

import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.fields.HoursWorked;
import seedu.address.model.person.fields.PerformanceRating;
import seedu.address.model.person.fields.Role;
import seedu.address.model.person.fields.ShiftTiming;
import seedu.address.model.person.fields.StaffId;

/**
 * Stores the details to edit the staff with. Each non-empty field value
 * will replace the corresponding field value of the staff.
 */
public class EditStaffDescriptor extends EditPersonDescriptor {

    // Staff-specific fields
    private StaffId staffId; // Unique identifier for staff
    private Role role; // Job role (e.g., "Barista", "Manager")
    private ShiftTiming shiftTiming; // Work schedule (e.g., "9am-5pm")
    private HoursWorked hoursWorked; // Total hours worked in a period
    private PerformanceRating performanceRating; // Performance rating out of 5.0

    public EditStaffDescriptor() {
    }

    /**
     * Copy constructor. A defensive copy of {@code tags} is used
     * internally.
     */
    public EditStaffDescriptor(EditStaffDescriptor toCopy) {
        super(toCopy);
        setStaffId(toCopy.staffId);
        setRole(toCopy.role);
        setShiftTiming(toCopy.shiftTiming);
        setHoursWorked(toCopy.hoursWorked);
        setPerformanceRating(toCopy.performanceRating);
    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldEdited() {
        return super.isAnyFieldEdited()
                || CollectionUtil.isAnyNonNull(staffId, role, shiftTiming, hoursWorked, performanceRating);
    }

    public Optional<StaffId> getStaffId() {
        return Optional.ofNullable(staffId);
    }

    public void setStaffId(StaffId staffId) {
        this.staffId = staffId;
    }

    public Optional<Role> getRole() {
        return Optional.ofNullable(role);
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Optional<ShiftTiming> getShiftTiming() {
        return Optional.ofNullable(shiftTiming);
    }

    public void setShiftTiming(ShiftTiming shiftTiming) {
        this.shiftTiming = shiftTiming;
    }

    public Optional<HoursWorked> getHoursWorked() {
        return Optional.ofNullable(hoursWorked);
    }

    public void setHoursWorked(HoursWorked hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Optional<PerformanceRating> getPerformanceRating() {
        return Optional.ofNullable(performanceRating);
    }

    public void setPerformanceRating(PerformanceRating performanceRating) {
        this.performanceRating = performanceRating;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditStaffDescriptor)) {
            return false;
        }

        if (!super.equals(other)) {
            return false;
        }

        EditStaffDescriptor otherEditStaffDescriptor = (EditStaffDescriptor) other;
        return Objects.equals(staffId, otherEditStaffDescriptor.staffId)
                && Objects.equals(role, otherEditStaffDescriptor.role)
                && Objects.equals(shiftTiming, otherEditStaffDescriptor.shiftTiming)
                && Objects.equals(hoursWorked, otherEditStaffDescriptor.hoursWorked)
                && Objects.equals(performanceRating, otherEditStaffDescriptor.performanceRating);
    }

    /**
     * Builds a string representation of the object using a {@link ToStringBuilder}.
     * This method extends the parent class's string representation by adding
     * additional fields specific to the staff entity, such as staff ID, role,
     * shift timing, hours worked, and performance rating.
     *
     * @return A {@link ToStringBuilder} containing the string representation of the
     *         object.
     */
    @Override
    public ToStringBuilder toStringBuilder() {
        ToStringBuilder parentBuilder = super.toStringBuilder();
        parentBuilder.add("staffId", staffId)
                .add("role", role)
                .add("shiftTiming", shiftTiming)
                .add("hoursWorked", hoursWorked)
                .add("performanceRating", performanceRating);
        return parentBuilder;
    }
}
