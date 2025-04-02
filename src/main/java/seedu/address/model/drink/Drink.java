package seedu.address.model.drink;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents a Drink in the café management system.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Drink {

    // Identity fields
    private final DrinkName name;
    private final Price price;
    private final Category category;

    // Optional fields - stored as transient to not affect equals/hashCode
    private transient String description;
    private transient int stock;

    /**
     * Basic constructor with required fields only.
     * Every field must be present and not null.
     */
    public Drink(String name, double price, String category) {
        requireAllNonNull(name, price, category);
        this.name = new DrinkName(name);
        this.price = new Price(price);
        this.category = new Category(category);
        // Default values for optional fields
        this.description = "";
        this.stock = 0;
    }

    public DrinkName getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getPrintableName() {
        return name.toString();
    }

    public String getPrintablePrice() {
        return price.toString();
    }

    public String getPrintableCategory() {
        return category.toString();
    }

    public String getPrimitiveName() {
        return name.getDrinkName();
    }

    public double getPrimitivePrice() {
        return price.getPrice();
    }

    public String getPrimitiveCategory() {
        return category.getCategory();
    }

    public String getDescription() {
        return description != null ? description : "";
    }

    public int getStock() {
        return stock;
    }

    /**
     * Sets the description without affecting equals/hashCode.
     * Note: This does not affect the immutability of the core fields.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the stock without affecting equals/hashCode.
     * Note: This does not affect the immutability of the core fields.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Returns true if both drinks have the same name.
     * This defines a weaker notion of equality between two drinks.
     */
    public boolean isSameDrink(Drink otherDrink) {
        if (otherDrink == this) {
            return true;
        }

        if (!(otherDrink instanceof Drink)) {
            return false;
        }

        return name.equals(otherDrink.getName());
    }

    /**
     * Returns true if both drinks have the same identity and data fields.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Drink)) {
            return false;
        }

        Drink otherDrink = (Drink) other;
        return name.equals(otherDrink.getName())
                && price.equals(otherDrink.getPrice())
                && category.equals(otherDrink.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }

    @Override
    public String toString() {
        return getName() + " Price: " + getPrice() + " Category: " + getCategory();
    }
}
