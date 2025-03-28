package seedu.address.logic.parser.descriptors;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.fields.Address;
import seedu.address.model.person.fields.Email;
import seedu.address.model.person.fields.Name;
import seedu.address.model.person.fields.Phone;
import seedu.address.model.person.fields.Remark;
import seedu.address.model.tag.Tag;

/**
 * Stores the details to edit the person with. Each non-empty field value
 * will replace the corresponding field value of the person.
 */
public class EditPersonDescriptor {

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Remark remark;

    private Set<Tag> tags;

    public EditPersonDescriptor() {
    }

    /**
     * Copy constructor. A defensive copy of {@code tags} is used
     * internally.
     */
    public EditPersonDescriptor(EditPersonDescriptor toCopy) {
        setName(toCopy.name);
        setPhone(toCopy.phone);
        setEmail(toCopy.email);
        setAddress(toCopy.address);
        setRemark(toCopy.remark);
        setTags(toCopy.tags);
    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldEdited() {
        return CollectionUtil.isAnyNonNull(name, phone, email, address, remark, tags);
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Optional<Name> getName() {
        return Optional.ofNullable(name);
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Optional<Phone> getPhone() {
        return Optional.ofNullable(phone);
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Optional<Email> getEmail() {
        return Optional.ofNullable(email);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    public Optional<Remark> getRemark() {
        return Optional.ofNullable(remark);
    }

    public void setRemark(Remark remark) {
        this.remark = remark;
    }

    /**
     * Sets {@code tags} to this object's {@code tags}. A defensive copy of
     * {@code tags} is used internally.
     */
    public void setTags(Set<Tag> tags) {
        this.tags = (tags != null) ? new HashSet<>(tags) : null;
    }

    /**
     * Returns an unmodifiable tag set, which throws
     * {@code UnsupportedOperationException} if modification is attempted.
     * Returns {@code Optional#empty()} if {@code tags} is null.
     */
    public Optional<Set<Tag>> getTags() {
        return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditPersonDescriptor)) {
            return false;
        }

        EditPersonDescriptor otherEditPersonDescriptor = (EditPersonDescriptor) other;
        return Objects.equals(name, otherEditPersonDescriptor.name)
                && Objects.equals(phone, otherEditPersonDescriptor.phone)
                && Objects.equals(email, otherEditPersonDescriptor.email)
                && Objects.equals(address, otherEditPersonDescriptor.address)
                && Objects.equals(tags, otherEditPersonDescriptor.tags);
    }

    /**
     * Creates a {@code ToStringBuilder} for this object.
     * The builder includes the fields: name, phone, email, address, and tags.
     *
     * @return A {@code ToStringBuilder} instance containing the string representation of this object.
     */
    public ToStringBuilder toStringBuilder() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("tags", tags);
    }

    @Override
    public String toString() {
        return toStringBuilder().toString();
    }
}
