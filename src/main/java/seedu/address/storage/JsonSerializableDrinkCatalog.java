package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.DrinkCatalog;
import seedu.address.model.drink.Drink;
import seedu.address.model.drink.ReadOnlyDrinkCatalog;

/**
 * An Immutable DrinkCatalog that is serializable to JSON format.
 */
@JsonRootName(value = "drinkcatalog")
public class JsonSerializableDrinkCatalog {

    private final List<JsonAdaptedDrink> drinks = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableDrinkCatalog} with the given drinks.
     */
    @JsonCreator
    public JsonSerializableDrinkCatalog(@JsonProperty("drinks") List<JsonAdaptedDrink> drinks) {
        this.drinks.addAll(drinks);
    }

    /**
     * Converts a given {@code ReadOnlyDrinkCatalog} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableDrinkCatalog}.
     */
    public JsonSerializableDrinkCatalog(ReadOnlyDrinkCatalog source) {
        drinks.addAll(source.getDrinkList().stream()
                .map(JsonAdaptedDrink::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this drink catalog into the model's {@code DrinkCatalog} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public DrinkCatalog toModelType() throws IllegalValueException {
        DrinkCatalog drinkCatalog = new DrinkCatalog();
        for (JsonAdaptedDrink jsonAdaptedDrink : drinks) {
            Drink drink = jsonAdaptedDrink.toModelType();
            if (drinkCatalog.hasDrink(drink)) {
                throw new IllegalValueException("Drink catalog contains duplicate drinks");
            }
            drinkCatalog.addDrink(drink);
        }
        return drinkCatalog;
    }
}
