package seedu.address.storage;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;
import seedu.address.model.person.fields.*;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Person}.
 */
public class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    protected final Map<Class<? extends Field>, String> fields;
    private final List<JsonAdaptedTag> tags = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                             @JsonProperty("email") String email, @JsonProperty("address") String address,
                             @JsonProperty("remark") String remark, @JsonProperty("tags") List<JsonAdaptedTag> tags) {
        fields = new HashMap<>();
        fields.put(Name.class, name);
        fields.put(Phone.class, phone);
        fields.put(Email.class, email);
        fields.put(Address.class, address);
        fields.put(Remark.class, remark);
        
        if (tags != null) {
            this.tags.addAll(tags);
        }
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        fields = new HashMap<>();
        fields.put(Name.class, source.getName().fullName);
        fields.put(Phone.class, source.getPhone().value);
        fields.put(Email.class, source.getEmail().value);
        fields.put(Address.class, source.getAddress().value);
        fields.put(Remark.class, source.getRemark().value);
        
        tags.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }
    
    /**
     * Helper method to retrieve and validate a field from the map.
     */
    protected Field getField(Class<? extends Field> clazz) throws IllegalValueException {
        String value = fields.get(clazz);
        if (value == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, clazz.getSimpleName()));
        }
        try {
            Field instance = clazz.getDeclaredConstructor().newInstance();
            if (!instance.isValidValue(value)) {
                throw new IllegalValueException(instance.getMessageConstraints());
            }
            return instance;
        } catch (ReflectiveOperationException e) {
            throw new IllegalValueException("Unable to instantiate field class: " + clazz.getSimpleName(), e);
        }
    }
}
