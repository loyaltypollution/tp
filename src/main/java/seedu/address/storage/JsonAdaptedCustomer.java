package seedu.address.storage;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Customer;
import seedu.address.model.util.CustomerBuilder;

/**
 * Jackson-friendly version of {@link Customer}.
 */
public class JsonAdaptedCustomer extends JsonAdaptedPerson<Customer> {

    // Customer-specific fields
    private final String customerId;
    private final String rewardPoints;
    private final String visitCount;
    private final String favouriteItem;
    private final String totalSpent;

    /**
     * Constructs a {@code JsonAdaptedCustomer} with the given customer details.
     */
    @JsonCreator
    public JsonAdaptedCustomer(@JsonProperty("name") String name,
                             @JsonProperty("phone") String phone,
                             @JsonProperty("email") String email,
                             @JsonProperty("address") String address,
                             @JsonProperty("tags") List<JsonAdaptedTag> tags,
                             @JsonProperty("customerId") String customerId,
                             @JsonProperty("rewardPoints") String rewardPoints,
                             @JsonProperty("visitCount") String visitCount,
                             @JsonProperty("favouriteItem") String favouriteItem,
                             @JsonProperty("totalSpent") String totalSpent) {
        super(name, phone, email, address, tags);
        this.customerId = customerId;
        this.rewardPoints = rewardPoints;
        this.visitCount = visitCount;
        this.favouriteItem = favouriteItem;
        this.totalSpent = totalSpent;
    }

    /**
     * Converts a given {@code Customer} into this class for Jackson use.
     */
    public JsonAdaptedCustomer(Customer source) {
        super(source);
        this.customerId = source.getCustomerId().value;
        this.rewardPoints = source.getRewardPoints().value;
        this.visitCount = source.getVisitCount().value;
        this.favouriteItem = source.getFavouriteItem().value;
        this.totalSpent = source.getTotalSpent().value;
    }

    /**
     * Modifies the given {@code CustomerBuilder} with the values from this {@code JsonAdaptedCustomer}.
     * This is used to create a new {@code Customer} object.
     *
     * @param personBuilder the {@code CustomerBuilder} to modify
     * @return the modified {@code CustomerBuilder}
     * @throws IllegalValueException if there were any data constraints violated in the adapted customer.
     */
    public CustomerBuilder modifyBuilder(CustomerBuilder personBuilder) throws IllegalValueException {
        personBuilder = super.modifyBuilder(personBuilder);
        return personBuilder.withCustomerId(customerId)
                .withRewardPoints(rewardPoints)
                .withVisitCount(visitCount)
                .withFavouriteItem(favouriteItem)
                .withTotalSpent(totalSpent);
    }

    /**
     * Converts this Jackson-friendly adapted customer object into the model's {@code Customer} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted customer.
     */
    @Override
    public Customer toModelType() throws IllegalValueException {
        CustomerBuilder personBuilder = new CustomerBuilder();
        personBuilder = modifyBuilder(personBuilder);
        return personBuilder.build();
    }
}
