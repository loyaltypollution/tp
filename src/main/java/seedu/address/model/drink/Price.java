package seedu.address.model.drink;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Drink's price.
 * Guarantees: immutable; is valid as declared in {@link #isValidPrice(double)}.
 */
public class Price {

    public static final String MESSAGE_CONSTRAINTS = "Price should be greater than 0";

    // Points conversion rates
    private static final int POINTS_PER_DOLLAR = 10; // Earn 10 points per dollar spent
    private static final int POINTS_TO_DOLLAR_RATIO = 100; // 100 points = $1 in redemption value

    private final double price;

    /**
     * Constructs a {@code Price}.
     *
     * @param price A valid price.
     */
    public Price(double price) {
        requireNonNull(price);
        checkArgument(isValidPrice(price), MESSAGE_CONSTRAINTS);
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

    /**
     * Calculates reward points to add based on purchase price.
     * Points are awarded at a rate of POINTS_PER_DOLLAR for each dollar spent.
     */
    public int calculatePointsForPurchase() {
        return (int) Math.floor(price * POINTS_PER_DOLLAR);
    }

    /**
     * Calculates points needed to redeem a purchase of the given price.
     * Points are converted at a rate of POINTS_TO_DOLLAR_RATIO points per dollar.
     */
    public int calculatePointsForRedemption() {
        return (int) Math.ceil(price * POINTS_TO_DOLLAR_RATIO);
    }

    @Override
    public String toString() {
        return String.format("$%.2f", price);
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
