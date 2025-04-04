package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.DrinkCatalog;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.drink.Drink;
import seedu.address.model.drink.ReadOnlyDrinkCatalog;
import seedu.address.model.person.Address;
import seedu.address.model.person.Customer;
import seedu.address.model.person.CustomerId;
import seedu.address.model.person.Email;
import seedu.address.model.person.FavouriteItem;
import seedu.address.model.person.HoursWorked;
import seedu.address.model.person.Name;
import seedu.address.model.person.PerformanceRating;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.person.RewardPoints;
import seedu.address.model.person.Role;
import seedu.address.model.person.ShiftTiming;
import seedu.address.model.person.Staff;
import seedu.address.model.person.StaffId;
import seedu.address.model.person.TotalSpent;
import seedu.address.model.person.VisitCount;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static final Remark EMPTY_REMARK = new Remark("");

    public static Staff[] getSampleStaff() {
        return new Staff[] {
            new Staff(
                    new Name("Alice Tan"),
                    new Phone("81234567"),
                    new Email("alice.tan@cafeexample.com"),
                    new Address("123 Café Street"),
                    new Remark("Punctual and friendly"),
                    getTagSet("barista", "fulltime"),
                    new StaffId("S001"),
                    new Role("Barista"),
                    new ShiftTiming("Morning Shift"),
                    new HoursWorked("40"),
                    new PerformanceRating("4.8")
            ),
            new Staff(
                    new Name("Jacob Tan"),
                    new Phone("87654321"),
                    new Email("jacob.tan@cafeexample.com"),
                    new Address("456 Coffee Lane"),
                    new Remark("Great leadership skills"),
                    getTagSet("manager", "fulltime"),
                    new StaffId("S002"),
                    new Role("Manager"),
                    new ShiftTiming("Day Shift"),
                    new HoursWorked("45"),
                    new PerformanceRating("4.9")
            ),
            new Staff(
                    new Name("Charlie Wong"),
                    new Phone("89898989"),
                    new Email("charlie.wong@cafeexample.com"),
                    new Address("789 Espresso Avenue"),
                    new Remark("Creative and efficient"),
                    getTagSet("chef", "parttime"),
                    new StaffId("S003"),
                    new Role("Chef"),
                    new ShiftTiming("Evening Shift"),
                    new HoursWorked("25"),
                    new PerformanceRating("4.5")
            )
        };
    }

    public static Customer[] getSampleCustomers() {
        return new Customer[] {
            new Customer(
                    new Name("Abby Tan"),
                    new Phone("91234567"),
                    new Email("abby.tan@cafeexample.com"),
                    new Address("123 Café Street"),
                    new Remark("Always comes at 7am!"),
                    getTagSet(),
                    new CustomerId("C001"),
                    new RewardPoints("100"),
                    new VisitCount("12"),
                    new FavouriteItem("oat latte with vanilla syrup"),
                    new TotalSpent("120.3")
            ),
            new Customer(
                    new Name("Bella Smith"),
                    new Phone("81234567"),
                    new Email("bellasmith@cafeexample.com"),
                    new Address("123 Café Street"),
                    new Remark("comes with her dog"),
                    getTagSet(),
                    new CustomerId("C002"),
                    new RewardPoints("100"),
                    new VisitCount("12"),
                    new FavouriteItem("dog latte"),
                    new TotalSpent("120.3")
            ),
            new Customer(
                    new Name("Cory"),
                    new Phone("81111111"),
                    new Email("cory@cafeexample.com"),
                    new Address("123 Café Street"),
                    new Remark("interesting..."),
                    getTagSet(),
                    new CustomerId("C003"),
                    new RewardPoints("0"),
                    new VisitCount("78"),
                    new FavouriteItem("water"),
                    new TotalSpent("50.0")
            )
        };
    }

    /**
     * Returns a sample DrinkCatalog with pre-loaded sample data.
     */
    public static ReadOnlyDrinkCatalog getSampleDrinkCatalog() {
        DrinkCatalog sampleDc = new DrinkCatalog();
        for (Drink sampleDrink : getSampleDrinks()) {
            sampleDc.addDrink(sampleDrink);
        }
        return sampleDc;
    }

    /**
     * Returns a list of sample drinks.
     */
    public static Drink[] getSampleDrinks() {
        return new Drink[] {
            new Drink("Espresso", 3.50, "Coffee"),
            new Drink("Cappuccino", 4.50, "Coffee"),
            new Drink("Latte", 4.50, "Coffee"),
            new Drink("Mocha", 5.00, "Coffee"),
            new Drink("Green Tea", 3.00, "Tea"),
            new Drink("Black Tea", 3.00, "Tea"),
            new Drink("Earl Grey", 3.50, "Tea"),
            new Drink("Chamomile", 3.50, "Tea"),
            new Drink("Orange Juice", 4.00, "Cold Drinks"),
            new Drink("Apple Juice", 4.00, "Cold Drinks"),
            new Drink("Iced Coffee", 4.50, "Cold Drinks"),
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Staff sampleStaff : getSampleStaff()) {
            sampleAb.addStaff(sampleStaff);
        }
        for (Customer sampleCustomer : getSampleCustomers()) {
            sampleAb.addCustomer(sampleCustomer);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
