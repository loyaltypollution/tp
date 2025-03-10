package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Customer;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Customer objects.
 */
public class CustomerBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_REMARK = "Regular customer";
    public static final int DEFAULT_REWARD_POINTS = 100;
    public static final int DEFAULT_VISIT_COUNT = 5;
    public static final String DEFAULT_FAVORITE_ITEM = "Latte";
    public static final double DEFAULT_TOTAL_SPENT = 75.50;
    public static final int DEFAULT_RATING = 5;

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Remark remark;
    private Set<Tag> tags;
    private int rewardPoints;
    private int visitCount;
    private String favoriteItem;
    private double totalSpent;
    private int rating;

    /**
     * Creates a {@code CustomerBuilder} with the default details.
     */
    public CustomerBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        remark = new Remark(DEFAULT_REMARK);
        tags = new HashSet<>();
        rewardPoints = DEFAULT_REWARD_POINTS;
        visitCount = DEFAULT_VISIT_COUNT;
        favoriteItem = DEFAULT_FAVORITE_ITEM;
        totalSpent = DEFAULT_TOTAL_SPENT;
        rating = DEFAULT_RATING;
    }

    /**
     * Initializes the CustomerBuilder with the data of {@code customerToCopy}.
     */
    public CustomerBuilder(Customer customerToCopy) {
        name = customerToCopy.getName();
        phone = customerToCopy.getPhone();
        email = customerToCopy.getEmail();
        address = customerToCopy.getAddress();
        remark = customerToCopy.getRemark();
        tags = new HashSet<>(customerToCopy.getTags());
        rewardPoints = customerToCopy.getRewardPoints();
        visitCount = customerToCopy.getVisitCount();
        favoriteItem = customerToCopy.getFavoriteItem();
        totalSpent = customerToCopy.getTotalSpent();
        rating = customerToCopy.getRating();
    }

    /**
     * Sets the {@code Name} of the {@code Customer} that we are building.
     */
    public CustomerBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Customer} that we are building.
     */
    public CustomerBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Customer} that we are building.
     */
    public CustomerBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Customer} that we are building.
     */
    public CustomerBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Customer} that we are building.
     */
    public CustomerBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Customer} that we are building.
     */
    public CustomerBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code rewardPoints} of the {@code Customer} that we are building.
     */
    public CustomerBuilder withRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
        return this;
    }

    /**
     * Sets the {@code visitCount} of the {@code Customer} that we are building.
     */
    public CustomerBuilder withVisitCount(int visitCount) {
        this.visitCount = visitCount;
        return this;
    }

    /**
     * Sets the {@code favoriteItem} of the {@code Customer} that we are building.
     */
    public CustomerBuilder withFavoriteItem(String favoriteItem) {
        this.favoriteItem = favoriteItem;
        return this;
    }

    /**
     * Sets the {@code totalSpent} of the {@code Customer} that we are building.
     */
    public CustomerBuilder withTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
        return this;
    }

    /**
     * Sets the {@code rating} of the {@code Customer} that we are building.
     */
    public CustomerBuilder withRating(int rating) {
        this.rating = rating;
        return this;
    }

    /**
     * Builds the customer with the information altogether.
     */
    public Customer build() {
        return new Customer(name, phone, email, address, remark, tags,
                rewardPoints, visitCount, favoriteItem, totalSpent, rating);
    }
}
