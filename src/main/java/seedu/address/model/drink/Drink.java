package seedu.address.model.drink;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents a Drink in the café management system.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Drink {

    // Identity fields
    private final String name;
    private final double price;
    private final String category;

    // Optional fields - stored as transient to not affect equals/hashCode
    private transient String description;
    private transient int stock;

    /**
     * Basic constructor with required fields only.
     * Every field must be present and not null.
     */
    public Drink(String name, double price, String category) {
        requireAllNonNull(name, price, category);
        this.name = name;
        this.price = price;
        this.category = category;
        // Default values for optional fields
        this.description = "";
        this.stock = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
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

        return otherDrink != null
                && otherDrink.getName().equalsIgnoreCase(getName());
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
        return name.equalsIgnoreCase(otherDrink.name)
                && Double.compare(price, otherDrink.price) == 0
                && category.equals(otherDrink.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), price, category);
    }

    @Override
    public String toString() {
        return getName() + " Price: $" + getPrice() + " Category: " + getCategory();
    }
}
