package seedu.address.model.person.fields;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public abstract class Field {
    private String messageConstraints;
    private String validationRegex;

    public final String value;

    protected Field(String value, String messageConstraints, String validationRegex) {
        requireNonNull(value);
        checkArgument(isValidValue(value), messageConstraints);
        this.value = value;
        this.messageConstraints = messageConstraints;
        this.validationRegex = validationRegex;
    }

    public boolean isValidValue(String test) {
        return test.matches(validationRegex);
    }

    public String getMessageConstraints() {
        return messageConstraints;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}