package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.fields.Address;
import seedu.address.model.person.Customer;
import seedu.address.model.person.fields.CustomerId;
import seedu.address.model.person.fields.Email;
import seedu.address.model.person.fields.Name;
import seedu.address.model.person.fields.Phone;
import seedu.address.model.person.fields.Remark;
import seedu.address.model.person.fields.RewardPoints;
import seedu.address.model.person.fields.TotalSpent;
import seedu.address.model.person.fields.VisitCount;
import seedu.address.model.person.fields.FavouriteItem;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Customer}.
 */
class JsonAdaptedCustomer extends JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Customer's %s field is missing!";

    /**
     * Constructs a {@code JsonAdaptedCustomer} with the given customer details.
     */
    @JsonCreator
    public JsonAdaptedCustomer(@JsonProperty("name") String name,
                               @JsonProperty("phone") String phone,
                               @JsonProperty("email") String email,
                               @JsonProperty("address") String address,
                               @JsonProperty("remark") String remark,
                               @JsonProperty("tags") List<JsonAdaptedTag> tags,
                               @JsonProperty("customerId") String customerId,
                               @JsonProperty("rewardPoints") String rewardPoints,
                               @JsonProperty("visitCount") String visitCount,
                               @JsonProperty("favouriteItem") String favouriteItem,
                               @JsonProperty("totalSpent") String totalSpent) {
        super(name, phone, email, address, remark, tags);
        // fields.put(Name.class, name);
        // fields.put(Phone.class, phone);
        // fields.put(Email.class, email);
        // fields.put(Address.class, address);
        // fields.put(Remark.class, remark);

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
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        remark = source.getRemark().value;
        tags.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
        customerId = source.getCustomerId().value;
        rewardPoints = source.getRewardPoints().value;
        visitCount = source.getVisitCount().value;
        favouriteItem = source.getFavouriteItem().value;
        totalSpent = source.getTotalSpent().value;
    }

    /**
     * Converts this Jackson-friendly adapted customer object into the model's {@code Customer} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted customer.
     */
    public Customer toModelType() throws IllegalValueException {
        final List<Tag> customerTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tags) {
            customerTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidValue(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidValue(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidValue(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidValue(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        if (remark == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Remark.class.getSimpleName()));
        }
        final Remark modelRemark = new Remark(remark);

        if (customerId == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Customer ID"));
        }
        if (!CustomerId.isValidValue(customerId)) {
            throw new IllegalValueException(CustomerId.MESSAGE_CONSTRAINTS);
        }
        final CustomerId modelCustomerId = new CustomerId(customerId);

        if (rewardPoints == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Reward Points"));
        }
        if (!RewardPoints.isValidValue(rewardPoints)) {
            throw new IllegalValueException(RewardPoints.MESSAGE_CONSTRAINTS);
        }
        final RewardPoints modelRewardPoints = new RewardPoints(rewardPoints);

        if (visitCount == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Visit Count"));
        }
        if (!VisitCount.isValidValue(visitCount)) {
            throw new IllegalValueException(VisitCount.MESSAGE_CONSTRAINTS);
        }
        final VisitCount modelVisitCount = new VisitCount(visitCount);

        if (favouriteItem == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Favourite Item"));
        }
        if (!FavouriteItem.isValidValue(favouriteItem)) {
            throw new IllegalValueException(FavouriteItem.MESSAGE_CONSTRAINTS);
        }
        final FavouriteItem modelFavouriteItem = new FavouriteItem(favouriteItem);

        if (totalSpent == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "Total Spent"));
        }
        if (!TotalSpent.isValidValue(totalSpent)) {
            throw new IllegalValueException(TotalSpent.MESSAGE_CONSTRAINTS);
        }
        final TotalSpent modelTotalSpent = new TotalSpent(totalSpent);

        final Set<Tag> modelTags = new HashSet<>(customerTags);
        return new Customer(modelName, modelPhone, modelEmail, modelAddress, modelRemark, modelTags,
                modelCustomerId, modelRewardPoints, modelVisitCount, modelFavouriteItem, modelTotalSpent);
    }

}
