package seedu.address.logic.parser.descriptors;

import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.fields.CustomerId;
import seedu.address.model.person.fields.RewardPoints;
import seedu.address.model.person.fields.TotalSpent;
import seedu.address.model.person.fields.VisitCount;
import seedu.address.model.person.fields.FavouriteItem;

/**
 * Stores the details to edit the customer with. Each non-empty field value
 * will replace the corresponding field value of the customer.
 */
public class EditCustomerDescriptor extends EditPersonDescriptor {

    // Customer-specific fields
    private CustomerId customerId;
    private RewardPoints rewardPoints;
    private VisitCount visitCount;
    private FavouriteItem favouriteItem;
    private TotalSpent totalSpent;

    public EditCustomerDescriptor() {
    }

    /**
     * Copy constructor. A defensive copy of {@code tags} is used
     * internally.
     */
    public EditCustomerDescriptor(EditCustomerDescriptor toCopy) {
        super(toCopy);
        setCustomerId(toCopy.customerId);
        setRewardPoints(toCopy.rewardPoints);
        setVisitCount(toCopy.visitCount);
        setFavouriteItem(toCopy.favouriteItem);
        setTotalSpent(toCopy.totalSpent);
    }

    @Override
    public boolean isAnyFieldEdited() {
        return super.isAnyFieldEdited()
                || CollectionUtil.isAnyNonNull(customerId, rewardPoints, visitCount, favouriteItem, totalSpent);
    }

    public Optional<CustomerId> getCustomerId() {
        return Optional.ofNullable(customerId);
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public Optional<RewardPoints> getRewardPoints() {
        return Optional.ofNullable(rewardPoints);
    }

    public void setRewardPoints(RewardPoints rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Optional<VisitCount> getVisitCount() {
        return Optional.ofNullable(visitCount);
    }

    public void setVisitCount(VisitCount visitCount) {
        this.visitCount = visitCount;
    }

    public Optional<FavouriteItem> getFavouriteItem() {
        return Optional.ofNullable(favouriteItem);
    }

    public void setFavouriteItem(FavouriteItem favouriteItem) {
        this.favouriteItem = favouriteItem;
    }

    public Optional<TotalSpent> getTotalSpent() {
        return Optional.ofNullable(totalSpent);
    }

    public void setTotalSpent(TotalSpent totalSpent) {
        this.totalSpent = totalSpent;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCustomerDescriptor)) {
            return false;
        }

        if (!super.equals(other)) {
            return false;
        }

        EditCustomerDescriptor otherEditCustomerDescriptor = (EditCustomerDescriptor) other;
        return Objects.equals(customerId, otherEditCustomerDescriptor.customerId)
                && Objects.equals(rewardPoints, otherEditCustomerDescriptor.rewardPoints)
                && Objects.equals(visitCount, otherEditCustomerDescriptor.visitCount)
                && Objects.equals(favouriteItem, otherEditCustomerDescriptor.favouriteItem)
                && Objects.equals(totalSpent, otherEditCustomerDescriptor.totalSpent);
    }

    /**
     * Builds a string representation of the object using a {@link ToStringBuilder}.
     * This method extends the parent class's string representation by adding
     * additional fields specific to the customer entity, such as customer ID,
     * rewardPoints,
     * visit count, favourite item, and total spent.
     *
     * @return A {@link ToStringBuilder} containing the string representation of the
     *         object.
     */
    @Override
    public ToStringBuilder toStringBuilder() {
        ToStringBuilder parentBuilder = super.toStringBuilder();
        parentBuilder.add("customerId", customerId)
                .add("rewardPoints", rewardPoints)
                .add("visitCount", visitCount)
                .add("favouriteItem", favouriteItem)
                .add("totalSpent", totalSpent);
        return parentBuilder;
    }
}
