package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.drink.Drink;

/**
 * Jackson-friendly version of {@link Drink}.
 */
public class JsonAdaptedDrink {

    private final String name;
    private final double price;
    private final String category;

    /**
     * Constructs a {@code JsonAdaptedDrink} with the given drink details.
     */
    @JsonCreator
    public JsonAdaptedDrink(@JsonProperty("name") String name,
                           @JsonProperty("price") double price,
                           @JsonProperty("category") String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * Converts a given {@code Drink} into this class for Jackson use.
     */
    public JsonAdaptedDrink(Drink source) {
        name = source.getPrimitiveName();
        price = source.getPrimitivePrice();
        category = source.getPrimitiveCategory();
    }

    /**
     * Converts this Jackson-friendly adapted drink object into the model's {@code Drink} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted drink.
     */
    public Drink toModelType() throws IllegalValueException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalValueException("Drink name cannot be blank");
        }

        if (price <= 0) {
            throw new IllegalValueException("Drink price must be a positive number");
        }

        if (category == null || category.trim().isEmpty()) {
            throw new IllegalValueException("Drink category cannot be blank");
        }

        return new Drink(name, price, category);
    }
}
