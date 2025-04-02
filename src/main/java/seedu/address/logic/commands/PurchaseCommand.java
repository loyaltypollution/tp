package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DRINKNAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REDEEM;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CUSTOMERS;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.drink.Drink;
import seedu.address.model.drink.Price;
import seedu.address.model.person.Customer;
import seedu.address.model.person.RewardPoints;
import seedu.address.model.person.VisitCount;
import seedu.address.model.util.CustomerBuilder;

/**
 * Records a purchase for a customer, updating their total spent and reward points.
 * Can also redeem reward points for a purchase if the redeem flag is set.
 */
public class PurchaseCommand extends Command {

    public static final String COMMAND_WORD = "purchase";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Records a purchase for a customer "
        + "identified by the index number in the displayed customer list.\n"
        + "Parameters: INDEX " + PREFIX_DRINKNAME + "DRINK_NAME [" + PREFIX_REDEEM + "true]\n"
        + "Example: " + COMMAND_WORD + " 1 " + PREFIX_DRINKNAME + "ICED LATTE\n"
        + "Example (with redemption): " + COMMAND_WORD + " 1 " + PREFIX_DRINKNAME + "ICED LATTE "
        + PREFIX_REDEEM + "true";

    public static final String MESSAGE_PURCHASE_SUCCESS = "Purchase recorded for %1$s.\n"
        + "Drink: %2$s, Price: %3$s\n"
        + "Points earned: %4$d, New total points: %5$d\n"
        + "New total spent: $%6$.2f";

    public static final String MESSAGE_REDEMPTION_SUCCESS = "Points redeemed for %1$s.\n"
        + "Drink: %2$s, Price: %3$s\n"
        + "Points used: %4$d, Remaining points: %5$d";

    public static final String MESSAGE_DRINK_NOT_FOUND = "Drink '%1$s' not found in the catalog.";

    public static final String MESSAGE_INSUFFICIENT_POINTS = "Insufficient points for redemption. "
        + "Required: %1$d, Available: %2$d";

    private final Index customerIndex;
    private final String drinkName;
    private final boolean isRedemption;

    /**
     * Creates a PurchaseCommand to record a purchase of the specified {@code drinkName}
     * for customer at specified {@code customerIndex}
     *
     * @param customerIndex The index of the customer in the filtered customer list
     * @param drinkName The name of the drink to purchase
     * @param isRedemption Whether this purchase should use reward points
     */
    public PurchaseCommand(Index customerIndex, String drinkName, boolean isRedemption) {
        requireAllNonNull(customerIndex, drinkName);
        this.customerIndex = customerIndex;
        this.drinkName = drinkName;
        this.isRedemption = isRedemption;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Customer> lastShownList = model.getFilteredCustomerList();

        if (customerIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CUSTOMER_DISPLAYED_INDEX);
        }

        Customer customerToUpdate = lastShownList.get(customerIndex.getZeroBased());

        // Find the drink in the catalog
        Optional<Drink> drinkOptional = model.getFilteredDrinkList().stream()
                .filter(d -> d.getName().equalsNameIgnoreCase(drinkName))
                .findFirst();

        if (!drinkOptional.isPresent()) {
            throw new CommandException(String.format(MESSAGE_DRINK_NOT_FOUND, drinkName));
        }

        Drink drink = drinkOptional.get();
        Price price = drink.getPrice();

        if (isRedemption) {
            return handleRedemption(model, customerToUpdate, drink, price);
        } else {
            return handleRegularPurchase(model, customerToUpdate, drink, price);
        }
    }

    /**
     * Handles a regular purchase that earns points and updates total spent.
     */
    private CommandResult handleRegularPurchase(Model model, Customer customerToUpdate,
            Drink drink, Price price) {
        // Calculate points to add based on purchase amount
        int pointsToAdd = price.calculatePointsForPurchase();

        Customer updatedCustomer = createUpdatedCustomerForPurchase(customerToUpdate, price, pointsToAdd);

        model.setCustomer(customerToUpdate, updatedCustomer);
        model.updateFilteredCustomerList(PREDICATE_SHOW_ALL_CUSTOMERS);

        return new CommandResult(String.format(MESSAGE_PURCHASE_SUCCESS,
                customerToUpdate.getName(),
                drink.getName(),
                price,
                pointsToAdd,
                Integer.parseInt(updatedCustomer.getRewardPoints().value),
                Double.parseDouble(updatedCustomer.getTotalSpent().value)));
    }

    /**
     * Handles a redemption purchase that uses points instead of adding to total spent.
     */
    private CommandResult handleRedemption(Model model, Customer customerToUpdate,
            Drink drink, Price price) throws CommandException {
        // Calculate points needed for redemption
        int pointsNeeded = price.calculatePointsForRedemption();
        int currentPoints = Integer.parseInt(customerToUpdate.getRewardPoints().value);

        // Check if customer has enough points
        if (currentPoints < pointsNeeded) {
            throw new CommandException(String.format(MESSAGE_INSUFFICIENT_POINTS,
                    pointsNeeded, currentPoints));
        }

        // Create updated customer with reduced points but same total spent
        Customer updatedCustomer = createUpdatedCustomerForRedemption(customerToUpdate, pointsNeeded);

        model.setCustomer(customerToUpdate, updatedCustomer);
        model.updateFilteredCustomerList(PREDICATE_SHOW_ALL_CUSTOMERS);

        return new CommandResult(String.format(MESSAGE_REDEMPTION_SUCCESS,
                customerToUpdate.getName(),
                drink.getName(),
                price,
                pointsNeeded,
                Integer.parseInt(updatedCustomer.getRewardPoints().value)));
    }

    /**
     * Creates and returns a {@code Customer} with the details of {@code customerToUpdate}
     * with updated total spent and reward points for a regular purchase.
     */
    private static Customer createUpdatedCustomerForPurchase(Customer customerToUpdate,
            Price purchaseAmount, int pointsToAdd) {
        assert customerToUpdate != null;

        int currentRewardPoints = Integer.parseInt(customerToUpdate.getRewardPoints().value);
        int currentVisitCount = Integer.parseInt(customerToUpdate.getVisitCount().value);

        return new CustomerBuilder(customerToUpdate)
                .withRewardPoints(new RewardPoints(String.valueOf(currentRewardPoints + pointsToAdd)))
                .withTotalSpent(customerToUpdate.getTotalSpent().incrementSpent(purchaseAmount))
                .withVisitCount(new VisitCount(String.valueOf(currentVisitCount + 1)))
                .build();
    }

    /**
     * Creates and returns a {@code Customer} with the details of {@code customerToUpdate}
     * with reduced reward points for a redemption.
     * Total spent remains unchanged, but visit count is incremented.
     */
    private static Customer createUpdatedCustomerForRedemption(Customer customerToUpdate, int pointsToDeduct) {
        assert customerToUpdate != null;

        int currentRewardPoints = Integer.parseInt(customerToUpdate.getRewardPoints().value);
        int currentVisitCount = Integer.parseInt(customerToUpdate.getVisitCount().value);

        return new CustomerBuilder(customerToUpdate)
                .withRewardPoints(new RewardPoints(String.valueOf(currentRewardPoints - pointsToDeduct)))
                .withVisitCount(new VisitCount(String.valueOf(currentVisitCount + 1)))
                .build();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PurchaseCommand)) {
            return false;
        }

        PurchaseCommand otherCommand = (PurchaseCommand) other;
        return customerIndex.equals(otherCommand.customerIndex)
                && drinkName.equalsIgnoreCase(otherCommand.drinkName)
                && isRedemption == otherCommand.isRedemption;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("customerIndex", customerIndex)
                .add("drinkName", drinkName)
                .add("isRedemption", isRedemption)
                .toString();
    }
}
