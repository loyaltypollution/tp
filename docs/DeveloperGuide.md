---
  layout: default.md
  title: "Developer Guide"
  pageNav: 3
---

# CafeConnect Developer Guide

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## **Acknowledgements**

CafeConnect is based on the AddressBook-Level3 project created by the SE-EDU initiative
It incorporates the following third-party libraries: JavaFX, Jackson, JUnit5.

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## **Design**
### Architecture

<puml src="diagrams/ArchitectureDiagram.puml" width="280" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** (consisting of classes [`Main`](https://github.com/AY2425S2-CS2103T-T08-3/tp/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/AY2425S2-CS2103T-T08-3/tp/tree/master/src/main/java/seedu/address/MainApp.java)) is in charge of the app launch and shut down.
* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following four components:

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `customerdelete 1`.

<puml src="diagrams/ArchitectureSequenceDiagram.puml" width="574" />

> **_NOTE:_** The sequence diagram shows a simplified execution of the `DeleteCustomerCommand`.

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

<puml src="diagrams/ComponentManagers.puml" width="300" />

The sections below give more details of each component.
### UI component

The **API** of this component is specified in [`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

<puml src="diagrams/UiClassDiagram.puml" alt="Structure of the UI Component"/>

The **UI** consists of a `MainWindow` that is made up of parts e.g. `CommandBox`, `ResultDisplay`, `CustomerListPanel`, `StaffListPanel`, `DrinkListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The **UI** component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/AY2425S2-CS2103T-T08-3/tp/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/AY2425S2-CS2103T-T08-3/tp/tree/master/src/main/resources/view/MainWindow.fxml)

The **UI** component:
* Executes user commands using the `Logic` component.
* Listens for changes to `Model` data so that the UI can be updated with the modified data.
* Keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* Depends on classes in the `Model` component, as it displays `Customer`, `Staff`, and `Drink` objects residing in the `Model`.
* Contains a tabbed interface allowing users to switch between staff management, customer records, and the drink catalog.
* Features visual elements like charts to display customer metrics and sales data when requested.

The `HelpWindow` component is shown when you execute a help command. It contains a link to the detailed user and developer guide on this CafeConnect documentation website.
### Logic component

**API** : [`Logic.java`](https://github.com/AY2425S2-CS2103T-T08-3/tp/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<puml src="diagrams/LogicClassDiagram.puml" width="550"/>

The sequence diagram below illustrates the interactions within the `Logic` component, taking `execute("customerdelete 1")` API call as an example.

<puml src="diagrams/DeleteCustomerSequenceDiagram.puml" alt="Interactions Inside the Logic Component for the `customerdelete 1` Command" />

> **_NOTE:_** The lifeline for `DeleteCustomerCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline continues till the end of diagram.

How the `Logic` component works:

1. When `Logic` is called upon to execute a command, it is passed to an `AddressBookParser` object which in turn creates a parser that matches the command (e.g., `DeleteCustomerCommandParser`) and uses it to parse the command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `DeleteCustomerCommand`) which is executed by the `LogicManager`.
1. The command can communicate with the `Model` when it is executed (e.g. to delete a staff).<br>
   Note that although this is shown as a single step in the diagram above (for simplicity), in the code it can take several interactions (between the command object and the `Model`) to achieve.
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<puml src="diagrams/ParserClasses.puml" width="600"/>

How the parsing works:
* When called upon to parse a user command, the `AddressBookParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `AddressBookParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCustomerCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

### Model component
**API** : [`Model.java`](https://github.com/AY2425S2-CS2103T-T08-3/tp/tree/master/src/main/java/seedu/address/model/Model.java)

The model component represents the data domain of CafeConnect and provides APIs for accessing and modifying this data.

<puml src="diagrams/ModelOverviewClassDiagram.puml" width="850" height="500" />

**Model Overview**

The `Model` component,

* Stores different types of data essential for café management:
  * Core data entities: `Person`, `Staff`, `Customer`, and `Drink` objects
  * User preferences via the `UserPrefs` class
* Exposes _unmodifiable_ `ObservableList<T>` objects for UI components to bind to
* Provides validation methods for checking if entities already exist in the system
* Implements methods to add, remove, and modify data entities
* Does not depend on any of the other components (UI, Logic, or Storage)

The diagram above shows the main structure of the `Model` component. For clarity, we'll examine each entity model in more detail below.

#### Person Model
<puml src="diagrams/PersonModelClassDiagram.puml" width="750" />

The `Person` model:

* Serves as the base class for both `Staff` and `Customer` entities
* Contains common attributes for all persons: `Name`, `Phone`, `Email`, `Address`, `Remark`, and `Tag`s
* Enforces validation for all fields through specialized field classes
* Is stored in a `UniquePersonList` that ensures no two persons have the same identity

#### Staff Model
<puml src="diagrams/StaffModelClassDiagram.puml" width="750" />

The `Staff` model:

* Extends the `Person` class, inheriting all person attributes
* Adds staff-specific fields: `StaffId`, `Role`, `ShiftTiming`, `HoursWorked`, and `PerformanceRating`
* Uses `StaffId` as the primary identifier for staff members
* Is stored in a `UniqueStaffList` that enforces uniqueness based on staff IDs
* Implements staff-specific behavior for operations like performance tracking

#### Customer Model
<puml src="diagrams/CustomerModelClassDiagram.puml" width="750" />

The `Customer` model:

* Extends the `Person` class, inheriting all person attributes
* Adds customer-specific fields: `CustomerId`, `RewardPoints`, `VisitCount`, `FavouriteItem`, and `TotalSpent`
* Uses `CustomerId` as the primary identifier for customers
* Is stored in a `UniqueCustomerList` that enforces uniqueness based on customer IDs
* Implements customer-specific behavior, including reward point tracking, visit counting, and spending history

#### Drink Model
<puml src="diagrams/DrinkModelClassDiagram.puml" width="750" />

The `Drink` model:

* Defines drink items available in the café menu
* Contains essential drink attributes: `DrinkName`, `Price`, and `Category`
* Includes optional attributes like `description` and `stock` that don't affect identity
* Uses `DrinkName` as the primary identifier for drinks
* Is stored in a `UniqueDrinkList` that enforces uniqueness based on drink names
* Implements business logic for reward points calculation in the `Price` class:
  * Earning points: 10 points per dollar spent
  * Redeeming points: 100 points equals to $1 value
* Is managed through the `DrinkCatalog` class that implements `ReadOnlyDrinkCatalog`

Each entity in the Model component follows value semantics (meaning two entities with identical fields are considered equal) and is immutable for core fields to prevent unexpected side effects.

### Storage component

**API** : [`Storage.java`](https://github.com/AY2425S2-CS2103T-T08-3/tp/tree/master/src/main/java/seedu/address/storage/Storage.java)

<puml src="diagrams/StorageClassDiagram.puml" width="850" />

The `Storage` component,
* Can save and load data in JSON format across multiple data files:
  * `addressbook.json` - Stores all staff and customer data
  * `drinkcatalog.json` - Stores the drink menu data
  * `preferences.json` - Stores user preferences like window size and position
* Inherits from multiple interfaces: `AddressBookStorage`, `UserPrefsStorage`, and `DrinkCatalogStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* Is implemented by `StorageManager`, which coordinates all persistence operations by delegating to specialized storage classes.
* Uses Jackson library for JSON serialization and deserialization.
* Creates JSON-adapted versions of model objects through adapter classes:
  * `JsonAdaptedPerson` serves as the base adapter for person entities
  * `JsonAdaptedStaff` and `JsonAdaptedCustomer` extend the person adapter with specialized fields
  * `JsonAdaptedDrink` handles drink menu items
* Depends on classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`).

The sequence diagram below illustrates the storage operations that occur when executing a command that modifies data (such as `customerdelete 1`):

<puml src="diagrams/StorageSequenceDiagram.puml" width="800" />

When the application starts:
1. `MainApp` initializes `StorageManager` with the appropriate storage components for address book, drink catalog, and user preferences.
2. `StorageManager` attempts to load data from each storage file.
3. If any file is missing or corrupted, the application creates a new empty data structure for that component.

When a command modifies data:
1. After the model is updated, `LogicManager` calls `storage.saveAddressBook(model.getAddressBook())` (or the equivalent method for other data types).
2. `StorageManager` delegates to the appropriate storage component:
  * `JsonAddressBookStorage` for staff and customer data
  * `JsonDrinkCatalogStorage` for drink menu data
  * `JsonUserPrefsStorage` for user preferences
3. The storage component converts model objects to their JSON-adapted versions and writes the resulting JSON to the appropriate file.

> **_NOTE:_** If a data file is corrupted, the application will simply create a new empty data structure. Users must manage backups of their data files manually.

### Common classes

Classes used by multiple components are in the `seedu.address.commons` package.
## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### Staff Management System

#### Adding a staff to the addressbook

<puml src="diagrams/AddStaffSequenceDiagram.puml" alt="AddStaffSequenceDiagram" />

`AddressBookParser` creates an instance of `AddStaffCommandParser` to parse the user input string.

`AddStaffCommandParser` first extracts values corresponding to the prefixes `sid/`, `n/`, `p/`, `e/`, `a/`, `role/`, `shift/`, `hours/`, `rating/`, and `t/`.
It ensures that:
- The **ID prefix** `sid/` must start with a "S" followed by digits (e.g., S1001, s1001).
- The **name prefix** `n/` must contain only alphanumeric characters and spaces, and it cannot be blank.
- The **phone prefix** `p/` must contain only digits and be at least 3 digits long.
- The **email prefix** `e/` must contain a valid email address.
- The **address prefix** `a/` must contain a non-blank address.
- The **role prefix** `role/` must contain a non-empty role.
- The **shift prefix** `shift/` must contain a non-empty shift.
- The **hours prefix** `hours/` must contain a non-negative integer.
- The **rating prefix** `rating/` must contain only digits that are between 0 and 5.0 (inclusive) and of 1 decimal place.
- The **tag prefix** `t/`, if provided, must contain one or more non-empty tags.

If any of these constraints are violated, `AddStaffCommandParser` throws a `ParseException`. Otherwise, it creates a new instance of `AddStaffCommand` based on the user input.

---

`AddStaffCommand` stores the staff to be added, represented as a `Staff` instance.

Upon execution, `AddStaffCommand` first checks the model for duplicate staff. If no existing staff member with a matching (case-insensitive) staff id is found, it adds the new staff member to the address book.

> **_NOTE:_** CafeConnect identifies a staff member as a duplicate if their `SID` matches (case-insensitive) with an existing staff member in the address book. Attempting to add a duplicate will result in an error.

#### Deleting a staff from the address book

The delete staff feature allows users to remove staff from the address book by specifying the staff's index in the displayed list.

The implementation follows the command pattern where `AddressBookParser` identifies the command type and delegates to `DeleteStaffCommandParser` to create the appropriate command object.

<puml src="diagrams/DeleteStaffSequenceDiagram.puml" alt="DeleteStaffSequenceDiagram" />

`AddressBookParser` creates `DeleteStaffCommandParser` to parse user input string.

`DeleteStaffCommandParser` extracts the index from the command arguments and ensures:
- The **Index** is a valid positive integer.

If the index is invalid, `DeleteStaffCommandParser` throws a `ParseException`. Otherwise, it creates a new instance of `DeleteStaffCommand` based on the user input.

---

Upon execution, `DeleteStaffCommand` first checks if the index is within the bounds of the filtered staff list. If the index is out of bounds, a `CommandException` is thrown.

If the index is valid, `DeleteStaffCommand`:
1. Retrieves the staff to be deleted from the filtered staff list.
2. Calls `model.deleteStaff(staffToDelete)` to remove the staff from the address book.
3. Returns a `CommandResult` with a success message.

> **_NOTE:_** CafeConnect only allows deleting staff by index. Once a staff member is deleted, they cannot be recovered unless added again manually.

#### Editing a staff's details

The edit staff feature allows users to modify the details of an existing staff member by specifying the staff's index in the displayed list and the new details.

The implementation follows the command pattern, where `AddressBookParser` identifies the command type and delegates to `EditStaffCommandParser` to create the appropriate command object.

<puml src="diagrams/EditStaffSequenceDiagram.puml" alt="EditStaffSequenceDiagram" />

`AddressBookParser` creates `EditStaffCommandParser` to parse the user input string.

`EditStaffCommandParser` extracts the index and provided fields from the command arguments and ensures:
- The **Index** is a valid positive integer.
- At least one field is provided for editing.

If the input is invalid, `EditStaffCommandParser` throws a `ParseException`. Otherwise, it creates a new instance of `EditStaffCommand` based on the user input.

---

Upon execution, `EditStaffCommand` first checks if the index is within the bounds of the filtered staff list. If the index is out of bounds, a CommandException is thrown.

If the index is valid, `EditStaffCommand`:
1. Retrieves the staff member to be modified from the list.
2. Extracts the updated details from `EditStaffDescriptor`.
3. Constructs a new `Staff` instance using `StaffBuilder`.
4. Checks for duplicate staff entries in the system and throws a `CommandException` if a duplicate is found.
5. Updates the model with the modified staff information.
6. Returns a `CommandResult` confirming the successful edit.

<br></br>

### Customer Management System

#### Adding a customer to the addressbook

<puml src="diagrams/AddCustomerSequenceDiagram.puml" alt="AddCustomerSequenceDiagram" />

`AddressBookParser` creates an instance of `AddCustomerCommandParser` to parse the user input string.

`AddCustomerCommandParser` first extracts values corresponding to the prefixes `cid/`, `n/`, `p/`, `e/`, `a/`, `rp/`, `vc/`, `fi/`, `ts/`, and `t/`.
It ensures that:
- The **ID prefix** `cid/` must start with a "C" followed by digits (e.g., `C1001`).
- The **name prefix** `n/` must contain only alphanumeric characters and spaces, and it cannot be blank.
- The **phone prefix** `p/` must contain only digits and be at least 3 digits long.
- The **email prefix** `e/` must contain a valid email address.
- The **address prefix** `a/` must contain a non-blank address.
- The **reward points prefix** `rp/` must contain only digits.
- The **visit count prefix** `vc/` must contain only digits.
- The **favourite item prefix** `fi/` can take any value, but it cannot be blank.
- The **total spent prefix** `ts/` must contain only digits representing the amount in dollars.
- The **tag prefix** `t/`, if provided, must contain one or more non-empty tags.

If any of these constraints are violated, `AddCustomerCommandParser` throws a `ParseException`. Otherwise, it creates a new instance of `AddCustomerCommand` based on the user input.

---

`AddCustomerCommand` stores the customer to be added, represented as a `Customer` instance.

Upon execution, `AddCustomerCommand` first checks the model for duplicate customers. If no existing customer with a matching (case-insensitive) customer id is found, it adds the new customer to the customer list.

> **_NOTE:_** CafeConnect identifies a customer as a duplicate if their `CID` matches (case-insensitive) with an existing customer in the list. Attempting to add a duplicate will result in an error.

#### Deleting a customer from the address book

The delete customer feature allows users to remove customers from the address book by specifying the customer's index in the displayed list.

The implementation follows the command pattern where `AddressBookParser` identifies the command type and delegates to `DeleteCustomerCommandParser` to create the appropriate command object.

<puml src="diagrams/DeleteCustomerSequenceDiagram.puml" alt="DeleteCustomerSequenceDiagram" />

`AddressBookParser` creates `DeleteCustomerCommandParser` to parse user input string.

`DeleteCustomerCommandParser` extracts the index from the command arguments and ensures:
- The **Index** is a valid positive integer.

If the index is invalid, `DeleteCustomerCommandParser` throws a `ParseException`. Otherwise, it creates a new instance of `DeleteCustomerCommand` based on the user input.

---

Upon execution, `DeleteCustomerCommand` first checks if the index is within the bounds of the filtered customer list. If the index is out of bounds, a `CommandException` is thrown.

If the index is valid, `DeleteCustomerCommand`:
1. Retrieves the customer to be deleted from the filtered customer list.
2. Calls `model.deleteCustomer(customerToDelete)` to remove the customer from the address book.
3. Returns a `CommandResult` with a success message.

> **_NOTE:_** CafeConnect only allows deleting customers by index. Once a customer is deleted, they cannot be recovered unless added again manually.

#### Editing a Customer's Details

The edit customer feature allows users to modify the details of an existing customer by specifying the customer's index in the displayed list and the new details.

The implementation follows the command pattern, where `AddressBookParser` identifies the command type and delegates to `EditCustomerCommandParser` to create the appropriate command object.

<puml src="diagrams/EditCustomerSequenceDiagram.puml" alt="EditCustomerSequenceDiagram" />  

`AddressBookParser` creates `EditCustomerCommandParser` to parse the user input string.

`EditCustomerCommandParser` extracts the index and provided fields from the command arguments and ensures:
- The **Index** is a valid positive integer.
- At least one field is provided for editing.

If the input is invalid, `EditCustomerCommandParser` throws a `ParseException`. Otherwise, it creates a new instance of `EditCustomerCommand` based on the user input.

---

Upon execution, `EditCustomerCommand` first checks if the index is within the bounds of the filtered customer list. If the index is out of bounds, a `CommandException` is thrown.

If the index is valid, `EditCustomerCommand`:
1. Retrieves the customer to be modified from the list.
2. Extracts the updated details from `EditCustomerDescriptor`.
3. Constructs a new `Customer` instance using `CustomerBuilder`.
4. Checks for duplicate customer entries in the system and throws a `CommandException` if a duplicate is found.
5. Updates the model with the modified customer information.
6. Returns a `CommandResult` confirming the successful edit.

<br></br>

### Drink Management System

#### Adding a drink to the catalog

<puml src="diagrams/AddDrinkSequenceDiagram.puml" alt="AddDrinkSequenceDiagram" />

`AddressBookParser` creates an instance of `AddDrinkCommandParser` to parse the user input string.

`AddDrinkCommandParser` first extracts values corresponding to the prefixes `n/`, `p/`and `c/`.

It ensures that:
- The **name prefix** `n/` must contain a valid drink name.
- The **price prefix** `p/` must contain a valid positive decimal value.
- The **category prefix** `c/` must contain a non-empty category name.

If any of these constraints are violated, `AddDrinkCommandParser` throws a `ParseException`. Otherwise, it creates a new instance of `AddDrinkCommand` based on the user input.

---

`AddDrinkCommand` stores the drink to be added, represented as a `Drink` instance.

Upon execution, `AddDrinkCommand` first checks the model for duplicate drinks. If no existing drink with a matching (case-insensitive) name is found, it adds the new drink to the catalog.

> **_NOTE:_** CafeConnect identifies a drink as a duplicate if its `NAME` matches (case-insensitive) with an existing drink in the catalog. Attempting to add a duplicate will result in an error.

#### Deleting a drink from the catalog

The delete drink feature allows users to remove drinks from the catalog by specifying the drink's index in the displayed list.

The implementation follows the command pattern where `AddressBookParser` identifies the command type and delegates to `DeleteDrinkCommandParser` to create the appropriate command object.

<puml src="diagrams/DeleteDrinkSequenceDiagram.puml" alt="DeleteDrinkSequenceDiagram" />

`AddressBookParser` creates `DeleteDrinkCommandParser` to parse user input string.

`DeleteDrinkCommandParser` extracts the index from the command arguments and ensures:
- The **Index** is a valid positive integer.

If the index is invalid, `DeleteDrinkCommandParser` throws a `ParseException`. Otherwise, it creates a new instance of `DeleteDrinkCommand` based on the user input.

---

Upon execution, `DeleteDrinkCommand` first checks if the index is within the bounds of the filtered drink list. If the index is out of bounds, a `CommandException` is thrown.

If the index is valid, `DeleteDrinkCommand`:
1. Retrieves the drink to be deleted from the filtered drink list.
2. Calls `model.deleteDrink(drinkToDelete)` to remove the drink from the catalog.
3. Returns a `CommandResult` with a success message.

> **_NOTE:_** CafeConnect only allows deleting drinks by index. Once a drink is deleted, it cannot be recovered unless added again manually.

<br></br>

### Customer Purchase and Points System

#### Recording a customer purchase

<puml src="diagrams/PurchaseSequenceDiagram.puml" alt="PurchaseSequenceDiagram" />

`AddressBookParser` creates an instance of `PurchaseCommandParser` to parse the user input string.

`PurchaseCommandParser` first extracts values corresponding to the index, the prefix `n/`, and the prefix `redeem/`.

It ensures that:
- The **customer index** must be a valid positive integer.
- The **drink name prefix** `n/` must refer to an existing drink in the catalog.
- The **redemption prefix** `redeem/`, if provided, must be either "true" or "false".

If any of these constraints are violated, `PurchaseCommandParser` throws a `ParseException`. Otherwise, it creates a new instance of `PurchaseCommand` based on the user input.

---

`PurchaseCommand` stores the customer index, drink name, and redemption status.

Upon execution, `PurchaseCommand` first retrieves the customer at the specified index and searches for the drink in the catalog by name. It then processes the purchase based on the redemption status:

1. For regular purchases:
   - Calculates reward points (10 points per dollar)
   - Updates the customer's total spent
   - Updates the customer's reward points
   - Increments the visit count
2. For point redemptions:
   - Verifies the customer has sufficient points
   - Calculates points needed (100 points per dollar)
   - Deducts points from the customer
   - Keeps total spent unchanged
   - Increments the visit count

> **_NOTE:_** The points calculation follows a fixed rate of 10 points per dollar spent. Redemption follows a rate of 100 points equivalent to $1 in drink value.

<br></br>

### Quick Command Shortcuts

The implementation of shortcut commands provides an efficient way for café owners to add new entries and record purchases with minimal typing.

#### Types of Shortcut Commands

CaféConnect implements two distinct types of shortcut commands:

1. **Entity Creation Shortcuts** - For quickly adding new customers and staff:
   * `qc CID:NAME:PHONE` - Quick add a customer
   * `qs SID:NAME:PHONE` - Quick add a staff member

2. **Operation Shortcut** - For quickly recording purchases:
   * `qp INDEX:DRINK_NAME[:r]` - Quick record a purchase (with optional redemption)

#### Entity Creation Shortcuts
<puml src="diagrams/StaffShortcutCommandSequenceDiagram.puml" width="800" />
<puml src="diagrams/CustomerShortcutCommandSequenceDiagram.puml" width="800" />

These commands allow users to rapidly add new customer and staff entries during busy periods when full detailed commands might be impractical. The implementation works as follows:

1. `AddressBookParser` detects shortcut commands and routes them to the appropriate handler:
   * `qc` routes to the customer shortcut handler `CustomerQuickCommandParser`
   * `qs` routes to the staff shortcut handler `StaffQuickCommandParser`

2. The shortcut parsers process the input using these steps:
   * Split the input string at the colon separators
   * Validate that exactly three components are present (ID, name, and phone)
   * Create a new entity with the provided values and default values for other fields
   * Return the appropriate command object (e.g., `AddCustomerCommand` or `AddStaffCommand`)

3. The command is then executed like any standard command:
   * The model is updated with the new entity
   * The updated model is saved to persistent storage
   * A success message is displayed to the user

> **_NOTE:_** Entity creation shortcuts only accept three parameters (ID, name, and phone). Other fields are set to default values and can be updated later using the edit commands.

#### Purchase Shortcut
<puml src="diagrams/PurchaseShortcutCommandSequenceDiagram.puml" width="800" />

The purchase shortcut enables café staff to quickly record customer purchases with an optional redemption flag. The implementation differs from entity creation shortcuts:

1. `AddressBookParser` detects the `qp` command and routes it to the `PurchaseCommandParser`.

2. The purchase parser processes the input using these steps:
   * Validates the input against the pattern `^[0-9]+:.+(:r)?$`
   * Splits the input at the colon separators
   * Extracts the customer index (first part) and drink name (second part)
   * Checks for the presence of an optional third part "r" that indicates a redemption purchase
   * Returns a `PurchaseCommand` with the extracted parameters

3. The purchase command execution:
   * Retrieves the customer at the specified index
   * Verifies the drink exists in the drink catalog
   * Records the purchase, updating customer metrics (visit count, reward points, total spent)
   * For redemption purchases (with `:r`), deducts reward points instead of increasing total spent
   * Displays a success message with the updated customer information

> **_NOTE:_** The purchase shortcut uses a different parameter format than entity creation shortcuts. It takes a customer index (not ID), requires an existing drink name, and has an optional redemption flag.

This implementation adheres to the Command pattern used throughout the application while providing a streamlined interface for common operations. All shortcuts follow a colon-separated format for consistency, but with different parameter requirements based on their function.

<br></br>

### Data Storage and Persistence

CaféConnect uses JSON-based storage to persist data across application restarts. The storage implementation separates different entity types into distinct files:

- `addressbook.json`: Stores staff and customer data
- `drinkcatalog.json`: Stores drink catalog data
- `preferences.json`: Stores user preferences like window size and position

<puml src="diagrams/StorageSequenceDiagram.puml" alt="StorageSequenceDiagram" />

When saving data, the following sequence occurs:
1. A command that modifies data is executed
2. The model is updated with the changes
3. The storage manager is notified to save the changes
4. The appropriate storage component serializes the data to JSON
5. The JSON data is written to the file system

On application startup, the reverse process occurs:
1. The storage manager attempts to read data from the JSON files
2. If successful, the data is deserialized into model objects
3. If any file is missing or corrupted, a new empty data structure is created

> **_NOTE:_** CafeConnect implements data backup and recovery mechanisms. If a data file is corrupted, the application attempts to back it up before creating a new empty data structure.

--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)
--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

## Product Scope

### Purpose
The Café Management System is designed to help café owners efficiently manage customers, staff, and menu items while streamlining daily operations. It provides an intuitive interface with both detailed and shortcut commands for quick data entry and retrieval. The system focuses on **speed, accuracy, and ease of use**, making it ideal for busy café environments.

### Features
- **Customer Management**: Add, edit, delete, find, and list customers with details like contact info, reward points, and spending history.
- **Staff Management**: Track staff members, their roles, work shifts, performance ratings, and contact details.
- **Menu Management**: Add, remove, and manage drinks with categorized pricing.
- **Order & Purchase Tracking**: Record transactions, allow redemption of loyalty points, and track customer spending habits.
- **Quick Commands**: Enable fast input of customer and staff details through concise shortcuts.
- **Filtering & Sorting**: Search and categorize customers and staff based on key attributes.
- **Help & Guidance**: Provide quick access to command references for ease of use.

### Value Proposition
- **Saves Time**: Enables quick updates and retrieval of customer, staff, and menu information.
- **Enhances Efficiency**: Reduces manual effort in managing records.
- **Improves Customer Retention**: Tracks customer preferences and spending to offer a personalized experience.
- **Optimizes Staff Management**: Helps keep track of working hours, shifts, and performance evaluations.
- **Boosts Business Insights**: Provides data on sales trends, popular drinks, and customer engagement.

---

## Target User Profile

| Attribute             | Description |
|-----------------------|-------------|
| **Primary User**      | Café owners and managers who need a fast, structured way to manage their café operations. |
| **Demographics**      | Small to medium café owners, typically in urban areas with moderate to high customer traffic. |
| **Technical Skills**  | Comfortable with command-line interfaces (CLI) and quick-typing, but prefer intuitive commands. |
| **Pain Points**       | Struggles with handling large amounts of customer and staff data manually, keeping track of sales, and ensuring smooth operations. |
| **Needs & Goals**     | Wants a **fast, no-frills, and reliable** system to manage daily tasks without unnecessary complexity. |
| **Usage Environment** | Typically used on a **desktop or laptop** at the café’s counter or office for quick access during operations. |


### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​          | I want to …​                                 | So that I can…​                                                 |
|----------|-----------------|----------------------------------------------|------------------------------------------------------------------|
| `* * *`  | café owner      | add a new customer                          | keep track of my regular customers and their preferences       |
| `* * *`  | café owner      | delete a customer                           | remove outdated or irrelevant customer records                 |
| `* * *`  | café owner      | edit a customer's details                   | update their contact info or preferences if they change        |
| `* * *`  | café owner      | find a customer by name                     | quickly retrieve customer details                              |
| `* * *`  | café owner      | list all customers                          | view a full list of my customers at any time                   |
| `* * *`  | café owner      | add a new staff member                      | track my employees and their roles                             |
| `* * *`  | café owner      | delete a staff member                       | remove staff who have left the café                            |
| `* * *`  | café owner      | edit a staff member's details               | update their role, contact, or working hours                   |
| `* * *`  | café owner      | find a staff member by name                 | locate specific staff quickly                                  |
| `* * *`  | café owner      | list all staff members                      | get an overview of all employees                              |
| `* * *`  | café owner      | add a new drink to the menu                 | expand my offerings for customers                             |
| `* * *`  | café owner      | delete a drink from the menu                | remove items that are no longer available                      |
| `* * *`  | café owner      | record a purchase                           | track customer orders and spending habits                      |
| `* * *`  | café owner      | allow customers to redeem points for purchases | encourage customer loyalty and reward repeat visitors        |
| `* * *`  | café owner      | access a help command                       | quickly understand how to use the system when needed          |
| `* *`    | café owner      | use shortcut commands for adding customers and staff | speed up data entry for frequently used actions               |

### Use cases

(For all use cases below, the System is the Café Management System and the Actor is the café owner, unless specified otherwise)

#### **Use Case: Add a Customer**
**MSS**
1. Café owner requests to add a new customer.
2. System prompts for customer details.
3. Café owner provides required details.
4. System validates the input.
5. System adds the new customer.
6. System confirms the addition.
   Use case ends.

**Extensions**
- 4a. Invalid input format → System shows an error and resumes at step 2.
- 4b. Duplicate customer ID → System shows an error and use case ends.

---

#### **Use Case: Add a Customer (Shortcut)**
**MSS**
1. Café owner enters a shortcut command to add a customer.
2. System extracts and validates input details.
3. System adds the new customer.
4. System confirms the addition.
   Use case ends.

**Extensions**
- 2a. Invalid format → System shows an error and use case ends.

---

#### **Use Case: Delete a Customer**
**MSS**
1. Café owner requests to delete a customer.
2. System confirms the customer’s existence.
3. System deletes the customer.
4. System confirms deletion.
   Use case ends.

**Extensions**
- 2a. Customer does not exist → System shows an error and use case ends.

---

#### **Use Case: Edit a Customer**
**MSS**
1. Café owner requests to edit a customer’s details.
2. System prompts for details to edit.
3. Café owner provides updated details.
4. System validates and updates the details.
5. System confirms the update.
   Use case ends.

**Extensions**
- 4a. Invalid input format → System shows an error and resumes at step 2.
- 4b. Customer does not exist → System shows an error and use case ends.

---

#### **Use Case: Find a Customer**
**MSS**
1. Café owner searches for a customer.
2. System retrieves and displays matching customers.
   Use case ends.

**Extensions**
- 2a. No matches found → System shows an error and use case ends.

---

#### **Use Case: List All Customers**
**MSS**
1. Café owner requests to list all customers.
2. System displays all customers.
   Use case ends.

---

#### **Use Case: Add a Staff Member**
**MSS**
1. Café owner requests to add a new staff member.
2. System prompts for staff details.
3. Café owner provides required details.
4. System validates input and adds the staff member.
5. System confirms the addition.
   Use case ends.

**Extensions**
- 4a. Invalid input format → System shows an error and resumes at step 2.
- 4b. Duplicate staff ID → System shows an error and use case ends.

---

#### **Use Case: Add a Staff Member (Shortcut)**
**MSS**
1. Café owner enters a shortcut command to add a staff member.
2. System extracts and validates input details.
3. System adds the new staff member.
4. System confirms the addition.
   Use case ends.

**Extensions**
- 2a. Invalid format → System shows an error and use case ends.

---

#### **Use Case: Delete a Staff Member**
**MSS**
1. Café owner requests to delete a staff member.
2. System confirms the staff member’s existence.
3. System deletes the staff member.
4. System confirms deletion.
   Use case ends.

**Extensions**
- 2a. Staff member does not exist → System shows an error and use case ends.

---

#### **Use Case: Edit a Staff Member**
**MSS**
1. Café owner requests to edit a staff member’s details.
2. System prompts for details to edit.
3. Café owner provides updated details.
4. System validates and updates the details.
5. System confirms the update.
   Use case ends.

**Extensions**
- 4a. Invalid input format → System shows an error and resumes at step 2.
- 4b. Staff member does not exist → System shows an error and use case ends.

---

#### **Use Case: Find a Staff Member**
**MSS**
1. Café owner searches for a staff member.
2. System retrieves and displays matching staff.
   Use case ends.

**Extensions**
- 2a. No matches found → System shows an error and use case ends.

---

#### **Use Case: List All Staff Members**
**MSS**
1. Café owner requests to list all staff members.
2. System displays all staff.
   Use case ends.

---

#### **Use Case: Add a Drink**
**MSS**
1. Café owner requests to add a drink.
2. System prompts for drink details.
3. Café owner provides details.
4. System validates input and adds the drink.
5. System confirms the addition.
   Use case ends.

**Extensions**
- 4a. Invalid input format → System shows an error and resumes at step 2.
- 4b. Duplicate drink name → System shows an error and use case ends.

---

#### **Use Case: Delete a Drink**
**MSS**
1. Café owner requests to delete a drink.
2. System confirms the drink’s existence.
3. System deletes the drink.
4. System confirms deletion.
   Use case ends.

**Extensions**
- 2a. Drink does not exist → System shows an error and use case ends.

---

#### **Use Case: Purchase a Drink**
**MSS**
1. Café owner requests to process a purchase.
2. System verifies drink availability.
3. System completes the purchase.
4. System confirms the transaction.
   Use case ends.

**Extensions**
- 2a. Drink unavailable → System shows an error and use case ends.

---

#### **Use Case: Purchase a Drink (Shortcut)**
**MSS**
1. Café owner enters a shortcut command to process a purchase.
2. System extracts and validates input details.
3. System completes the purchase.
4. System confirms the transaction.
   Use case ends.

**Extensions**
- 2a. Invalid format → System shows an error and use case ends.

---

#### **Use Case: Help Command**
**MSS**
1. Café owner requests help.
2. System displays a list of available commands and their descriptions.
   Use case ends.



### Non-Functional Requirements

1. Performance & Scalability

  * The application should be able to handle up to 1000 total entries (staff, customers, and drinks combined) without noticeable sluggishness in performance.

  * The system should respond to user actions within 1 second for typical operations like adding, deleting, or searching for customers and staff.

  * The startup time should be no more than 2 seconds on a modern consumer-grade computer.

  * The application should consume no more than 200MB of RAM during normal operation with 1000 total entries.

2. Compatibility & Portability

  * The application should be compatible with Java 11 or above and run on any mainstream OS (Windows, Linux, macOS).

  * The application should work consistently across different screen resolutions and window sizes.

  * The system should be self-contained and should not require an internet connection or external databases.

3. Usability & Accessibility

  * A café owner with basic typing skills should be able to accomplish most tasks faster using commands than using a mouse-driven interface.

  * The tabbed interface should provide intuitive separation between staff management, customer records, and the drink catalog.

  * The application should provide clear, contextual error messages when a user makes an incorrect input.

  * Command shortcuts and aliases (like `c` and `s`) should make frequent operations more efficient.

4. Reliability & Robustness

  * The system should not crash or freeze when an invalid command is entered.

  * Customer, staff, and drink data should be persisted safely to prevent accidental loss due to application crashes.

  * The application should validate all inputs to prevent data corruption.

  * The system should be able to recover gracefully from unexpected failures (e.g., power loss, abrupt shutdowns).

5. Security & Privacy

  * The system should store customer and staff contact information securely.

  * The application should not expose private data unnecessarily in logs or error messages.

6. Maintainability & Extensibility

  * The codebase should maintain separation between the UI, Logic, Model, and Storage components.

  * New commands and features should be able to be added without modifying existing code.

  * The command structure should be consistent to make the application easier to learn and extend.

7. Domain-Specific Requirements

  * The reward points system should accurately track customer loyalty across multiple visits.

  * The application should support point redemption with clear feedback about points used and remaining.

  * Staff performance metrics should be maintainable and viewable.
### Glossary

* **Mainstream OS**: Operating systems commonly used by the majority of users, including Windows, Linux, Unix, and macOS.

* **Private contact detail**: A contact detail that is not meant to be shared with others, such as a personal phone number, home address, or private email.

* **Typical usage**: Standard operations performed within the application, including adding, editing, deleting, and searching for contacts, assuming a user base of up to 1000 persons.

* **Command-based interaction**: A method of input where users type textual commands to execute actions instead of using a graphical user interface (GUI).

* **Graphical User Interface (GUI)**: A visual interface that allows users to interact with the system through elements like buttons, forms, and icons instead of typing commands.

* **Error message**: A message displayed by the system when a user enters an invalid input or an operation cannot be completed, providing clear guidance on how to correct the issue.

* **Modern consumer-grade computer**: A personal computer with at least a quad-core processor and 8GB of RAM, manufactured within the last five years.

* **Modular codebase**: A structured code design where different components can be modified, replaced, or extended independently without affecting the overall system.

* **Persisted data**: Information that is stored and retained across application restarts, ensuring that user data is not lost when the application is closed.

* **Startup time**: The time taken from launching the application to when it is fully ready for user interaction.

* **Authorized user**: A user who has been granted specific permissions to access certain functionalities within the system.

* **Self-contained application**: An application that does not require external dependencies or an internet connection for its core features to function.

* **Scalability**: The system's ability to maintain performance and responsiveness even as the user base or data size increases.

* **Undo/Redo functionality**: A feature that allows users to reverse or reapply their last action, improving usability and error recovery.

* **Extensibility**: The ability to add new features or enhance existing ones without major rework of the system.

* **Logging and audit trail**: A system feature that records user actions and system events for security, debugging, or compliance purposes.
## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

> **_NOTE:_**  These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

### Launch

1. Initial launch
  1. Download the jar file and copy into an empty folder
  2. Run  `java -jar cafeconnect.jar` in a terminal.<br>
     Expected: The welcome window appears with buttons to navigate to view staff/customers or drink menu. The window size may not be optimum.

2. Saving window preferences
  1. After clicking on either of the two buttons, resize the window to an optimum size.<br>
     Move the window to a different location. Close the window.
  2. Re-launch the app by double-clicking the jar file.<br>
     Expected: The most recent window size and location is retained.

### Help Window

1. Opening help window via Command Line
  1. Prerequisites: Help window is not open
  2. Test case: `help`<br>
     Expected: Help window opens.

2. Opening help window via Tool bar
  1. Prerequisites: Help window is not open
  2. Test case: Click the `Help` menu, then click on the `Help` option<br>
     Expected: Help window opens.

3. Interacting the help window
  1. Prerequisites: Help window is now open
  2. Test case: Scroll through content<br>
     Expected: Help window content scrolls properly.

4. Closing the help window
  1. Prerequisites: Help window is open
  2. Test case: Click on the close button on the help window<br>
     Expected: Help window closes.

### Managing Customers

1. Adding a customer
   1. Prerequisites: The exact customer details shouldn't already be in the list
   2. Test case: `customeradd cid/C005 n/James Bond p/98765432 e/jamesbond@example.com a/123 Spy Street rp/0 vc/0 fi/Martini ts/0`<br>
      Expected: A new customer is successfully added with the specified details. The status message confirms the addition.
   3. Test case: `ca cid/C005 n/James Bond p/98765432 e/jamesbond@example.com a/123 Spy Street rp/0 vc/0 fi/Martini ts/0`<br>
      Expected: Same as above, using the command abbreviation.
   4. Test case: `customeradd cid/C005 n/Duplicate Customer p/12345678 e/dup@example.com a/Duplicate Address rp/0 vc/0 fi/Coffee ts/0`<br>
      Expected: No customer is added. Error details about duplicate customer ID shown in the status message.

2. Adding a customer using shortcut format
   1. Prerequisites: The customer ID shouldn't already exist in the list
   2. Test case: `qca C099:John Smith:98761234`<br>
      Expected: A new customer is added with the specified ID, name, and phone number. Default values are used for other fields.

3. Deleting a customer
   1. Prerequisites: At least one customer in the list
   2. Test case: `customerdelete 1`<br>
      Expected: First customer is deleted from the list. Details of the deleted customer shown in the status message.
   3. Test case: `cd 1`<br>
      Expected: Same as above, using the command abbreviation.
   4. Test case: `customerdelete 0`<br>
      Expected: No customer is deleted. Error details shown in the status message about invalid index.
   5. Other incorrect delete commands to try: `customerdelete`, `cd`, `customerdelete x`, `cd x`, `customerdelete 999`, `cd 999` (where x is non-numeric and 999 is larger than the list size)<br>
      Expected: Error message indicating invalid index.

4. Editing a customer
   1. Prerequisites: At least one customer in the list
   2. Test case: `customeredit 1 rp/500 vc/6`<br>
      Expected: The reward points and visit count for the first customer is updated. Status message confirms the update.
   3. Test case: `ce 1 rp/500 vc/6`<br>
      Expected: Same as above, using the command abbreviation.

5. Finding customers
   1. Test case: `customerfind John`<br>
      Expected: Displays all customers with "John" in their name.
   2. Test case: `cf n/John`<br>
      Expected: Same as above, using the command abbreviation.
   3. Test case: `customerfind all/true`<br>
      Expected: Displays all customers in the list.
   4. Test case: `cf all/true`<br>
      Expected: Same as above, using the command abbreviation.

### Managing Staff

1. Adding a staff member
   1. Prerequisites: The exact staff details shouldn't already be in the list
   2. Test case: `staffadd sid/S005 n/Emily Wong p/91234567 e/emily@example.com a/456 Worker Ave role/Manager shift/9am-5pm hours/0 rating/5.0`<br>
      Expected: A new staff member is successfully added with the specified details. The status message confirms the addition.
   3. Test case: `sa sid/S005 n/Emily Wong p/91234567 e/emily@example.com a/456 Worker Ave role/Manager shift/9am-5pm hours/0 rating/5.0`<br>
      Expected: Same as above, using the command abbreviation.

2. Adding a staff member using shortcut format
   1. Prerequisites: The staff ID shouldn't already exist in the list
   2. Test case: `qsa S099:Jane Doe:90001234`<br>
      Expected: A new staff member is added with the specified ID, name, and phone number. Default values are used for other fields.

3. Deleting a staff member
   1. Prerequisites: At least one staff member in the list
   2. Test case: `staffdelete 1`<br>
      Expected: First staff member is deleted from the list. Details of the deleted staff shown in the status message.
   3. Test case: `sd 1`<br>
      Expected: Same as above, using the command abbreviation.

4. Editing a staff member
   1. Prerequisites: At least one staff member in the list
   2. Test case: `staffedit 1 p/98956743 role/manager`<br>
      Expected: The phone number and role for the first staff member is updated. Status message confirms the update.
   3. Test case: `se 1 p/98956743 role/manager`<br>
      Expected: Same as above, using the command abbreviation.

5. Finding staff
   1. Test case: `stafffind n/Jane`<br>
      Expected: Displays all staff with "Jane" in their name.
   2. Test case: `sf Jane`<br>
      Expected: Same as above, using the command abbreviation.
   3. Test case: `stafffind all/true`<br>
      Expected: Displays all staff in the list.
   4. Test case: `sf all/true`<br>
      Expected: Same as above, using the command abbreviation.

### Managing Drinks and Purchases

1. Adding a drink to the catalog
   1. Prerequisites: The exact drink name shouldn't already be in the catalog
   2. Test case: `drinkadd n/Green Tea p/3.50 c/Tea`<br>
      Expected: A new drink is successfully added to the catalog. The status message confirms the addition.
   3. Test case: `da n/Green Tea p/3.50 c/Tea`<br>
      Expected: Same as above, using the command abbreviation.

2. Deleting a drink
   1. Prerequisites: At least one drink in the catalog
   2. Test case: `drinkdelete 1`<br>
      Expected: First drink is deleted from the catalog. Status message confirms the deletion.
   3. Test case: `dd 1`<br>
      Expected: Same as above, using the command abbreviation.

3. Recording a purchase
   1. Prerequisites: At least one customer and one drink in the catalog
   2. Test case: `purchase 1 n/Espresso`<br>
      Expected: Purchase is recorded for the first customer. Their reward points, visit count, and total spent are updated. Status message confirms the purchase details.
   3. Test case: `p 1 n/Espresso`<br>
      Expected: Same as above, using the command abbreviation.

4. Recording a purchase using shortcut format
   1. Prerequisites: At least one customer and one drink in the catalog
   2. Test case: `qp 1:Espresso`<br>
      Expected: Purchase is recorded for the first customer. Their reward points, visit count, and total spent are updated. Status message confirms the purchase details.

5. Redeeming points for a purchase
   1. Prerequisites: At least one customer with sufficient reward points and one drink in the catalog
   2. Test case: `purchase 1 n/Cappuccino redeem/true`<br>
      Expected: Points are redeemed for the purchase. Customer's reward points decrease, visit count increases, and total spent remains unchanged. Status message confirms the redemption.
   3. Test case: `p 1 n/Cappuccino redeem/true`<br>
      Expected: Same as above, using the command abbreviation.
   4. Test case: `qp 1:Cappuccino:r`<br>
      Expected: Same as above, using the shortcut format for redemption purchases.
   5. Test case: `purchase 1 n/Expensive Drink redeem/true` (where the customer doesn't have enough points)<br>
      Expected: No redemption is made. Error message indicates insufficient points.
   6. Test case: `qp 1:Expensive Drink:r` (where the customer doesn't have enough points)<br>
      Expected: Same as above, using the shortcut format.

### Tab Navigation

1. Switching between tabs
   1. Test case: Click on the "Staff" tab<br>
      Expected: The staff list is displayed.
   2. Test case: Enter any staff-related command (e.g., `sf all/true`)<br>
      Expected: The staff list is displayed and the command is executed.
   3. Test case: Click on the "Customers" tab<br>
      Expected: The customer list is displayed.
   4. Test case: Enter any customer-related command (e.g., `cf all/true`)<br>
      Expected: The customer list is displayed and the command is executed.
   5. Test case: Click on the "Drinks Menu" tab<br>
      Expected: The drinks catalog is displayed.
   6. Test case: Enter any drink-related command (e.g., `da n/New Drink p/4.50 c/Coffee`)<br>
      Expected: The drinks catalog is displayed and the command is executed.

### Exiting the Application

1. Exiting via command
  1. Test case: `exit`<br>
     Expected: Application closes and all data is saved.

2. Exiting via window controls
  1. Test case: Click on the X button at the top-right of the window<br>
     Expected: Application closes and all data is saved.

### Saving Data

1. Dealing with missing/corrupted data files
  1. Test case: Delete the addressbook.json file manually, then restart the application<br>
     Expected: Application starts with an empty customer and staff list, but creates a new addressbook.json file.
  2. Test case: Delete the drinkcatalog.json file manually, then restart the application<br>
     Expected: Application starts with an empty drink catalog, but creates a new drinkcatalog.json file.
  3. Test case: Corrupt the addressbook.json file by adding invalid JSON, then restart the application<br>
     Expected: Application starts with an empty customer and staff list, backing up the corrupted file.
