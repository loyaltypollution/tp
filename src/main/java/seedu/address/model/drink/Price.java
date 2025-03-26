package seedu.address.model.drink;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Drink's price.
 * Guarantees: immutable; is valid as declared in {@link #isValidPrice(double)}.
 */
public class Price {

    public static final String MESSAGE_CONSTRAINTS = "Price should be greater than 0";

    public final double price;

    /**
     * Constructs a {@code Price}.
     *
     * @param price A valid price.
     */
    public Price(double price) {
        requireNonNull(price);
        if (!isValidPrice(price)) {
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Returns true if a given price is valid.
     */
    public static boolean isValidPrice(double test) {
        return test > 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f", price);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Price
                && price == ((Price) other).price);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(price);
    }
}
