package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CUSTOMERS;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.drink.Drink;
import seedu.address.model.person.Address;
import seedu.address.model.person.Customer;
import seedu.address.model.person.CustomerId;
import seedu.address.model.person.Email;
import seedu.address.model.person.FavouriteItem;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.person.RewardPoints;
import seedu.address.model.person.TotalSpent;
import seedu.address.model.person.VisitCount;
import seedu.address.model.tag.Tag;

/**
 * Records a purchase for a customer, updating their total spent and reward points.
 */
public class PurchaseCommand extends Command {

    public static final String COMMAND_WORD = "purchase";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Records a purchase for a customer "
        + "identified by the index number in the displayed customer list.\n"
        + "Parameters: ind/INDEX n/DRINK_NAME\n"
        + "Example: " + COMMAND_WORD + " ind/1 n/ICED LATTE";

    public static final String MESSAGE_PURCHASE_SUCCESS = "Purchase recorded for %1$s.\n"
        + "Drink: %2$s, Price: $%3$.2f\n"
        + "Points earned: %4$d, New total points: %5$d\n"
        + "New total spent: $%6$.2f";

    public static final String MESSAGE_DRINK_NOT_FOUND = "Drink '%1$s' not found in the catalog.";

    // Points conversion rate - for every $1 spent, customer earns this many points
    private static final int POINTS_PER_DOLLAR = 10;

    private final Index customerIndex;
    private final String drinkName;

    /**
     * Creates a PurchaseCommand to record a purchase of the specified {@code drinkName}
     * for customer at specified {@code customerIndex}
     */
    public PurchaseCommand(Index customerIndex, String drinkName) {
        requireAllNonNull(customerIndex, drinkName);
        this.customerIndex = customerIndex;
        this.drinkName = drinkName;
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
        // TODO: this violates hand principle. we want to have model directly search for drink
        // this way, we can implement fuzzy matching there
        // fuzzy matching should have parameters such as (ratio + distance)
        Optional<Drink> drinkOptional = model.getFilteredDrinkList().stream()
                .filter(d -> d.getName().equalsIgnoreCase(drinkName))
                .findFirst();

        if (!drinkOptional.isPresent()) {
            throw new CommandException(String.format(MESSAGE_DRINK_NOT_FOUND, drinkName));
        }

        Drink drink = drinkOptional.get();
        double price = drink.getPrice();

        // Calculate points to add based on purchase amount
        int pointsToAdd = calculatePointsForPurchase(price);

        Customer updatedCustomer = createUpdatedCustomer(customerToUpdate, price, pointsToAdd);

        model.setPerson(customerToUpdate, updatedCustomer);
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
     * Calculates reward points to add based on purchase amount.
     * Points are awarded at a rate of POINTS_PER_DOLLAR for each dollar spent.
     */
    private int calculatePointsForPurchase(double amount) {
        return (int) Math.floor(amount * POINTS_PER_DOLLAR);
    }

    /**
     * Creates and returns a {@code Customer} with the details of {@code customerToUpdate}
     * with updated total spent and reward points.
     */
    private static Customer createUpdatedCustomer(Customer customerToUpdate, double purchaseAmount, int pointsToAdd) {
        assert customerToUpdate != null;

        Name name = customerToUpdate.getName();
        Phone phone = customerToUpdate.getPhone();
        Email email = customerToUpdate.getEmail();
        Address address = customerToUpdate.getAddress();
        Remark remark = customerToUpdate.getRemark();
        Set<Tag> tags = customerToUpdate.getTags();
        CustomerId customerId = customerToUpdate.getCustomerId();

        // Retrieve current reward points and total spent values
        int currentRewardPoints = Integer.parseInt(customerToUpdate.getRewardPoints().value);
        double currentTotalSpent = Double.parseDouble(customerToUpdate.getTotalSpent().value);
        int currentVisitCount = Integer.parseInt(customerToUpdate.getVisitCount().value);

        // Calculate updated values
        int updatedRewardPoints = currentRewardPoints + pointsToAdd;
        double updatedTotalSpent = currentTotalSpent + purchaseAmount;

        // Create new RewardPoints and TotalSpent objects
        RewardPoints newRewardPoints = new RewardPoints(String.valueOf(updatedRewardPoints));
        TotalSpent newTotalSpent = new TotalSpent(String.format("%.2f", updatedTotalSpent));

        VisitCount visitCount = new VisitCount(String.valueOf(currentVisitCount + 1));
        FavouriteItem favoriteItem = customerToUpdate.getFavoriteItem();

        return new Customer(name, phone, email, address, remark, tags,
                customerId, newRewardPoints, visitCount, favoriteItem, newTotalSpent);
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
                && drinkName.equalsIgnoreCase(otherCommand.drinkName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("customerIndex", customerIndex)
                .add("drinkName", drinkName)
                .toString();
    }
}
