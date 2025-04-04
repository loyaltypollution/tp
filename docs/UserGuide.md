---
  layout: default.md
  title: "User Guide"
  pageNav: 4
---

# CaféConnect User Guide

## Welcome to CaféConnect!

Thank you for choosing **CaféConnect** to streamline your café management experience. With so many details to track in a busy café environment, managing customers, staff, and inventory becomes a real challenge. **CaféConnect** is here to keep you organized and focused on what matters most—providing excellent service to your customers.

*Use CaféConnect to bring efficiency to your café management!*

**What is CaféConnect?**

CaféConnect is a streamlined desktop application that helps you manage customers, staff, and your drink menu all in one place.

* **Easy to use**
  * **Type simple commands:** If you can type fast, CaféConnect can get your café management tasks done faster than traditional apps.
  * **Simple design:** View all your customer and staff information at a glance.
* **Efficient management**
  * **Core features:** Add, delete, edit, and find customer and staff entries quickly.
  * **Advanced features:** Record purchases, manage reward points, and track customer visits.
* **Comprehensive tracking**
  * **Customer insights:** Track customer preferences, visit history, and favorite items.
  * **Staff organization:** Manage staff details, roles, shifts, and performance ratings.

## Why would you enjoy CaféConnect?  

Because countless other café owners and managers already do!  

If you're a café owner who **values efficiency**, can **type quickly**, and wants to **streamline your operations**, CaféConnect is the perfect solution for you!  

Managing café operations efficiently is crucial for success—that's why we created CaféConnect. Our application streamlines three core aspects into three beautiful tabs:

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: left; max-width: 18%;">
    <p>1. <b>Staff Tab</b></p>
    Manage staff efficiently to build a strong team!
  </div>
  <div style="text-align: center; max-width: 78%;">
    <img src="images/UG_Ui_Images/initial_staff.png" alt="Initial Staff Screen" style="max-width: 100%; height: auto;"/>
    <p><i>Customer Tab: manage staff information</i></p>
  </div>
</div>



<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: left; max-width: 18%;">
    <p>2. <b>Customers Tab</b></p>
    Remember your customers with ease and see them smile!
  </div>
  <div style="text-align: center; max-width: 78%;">
    <img src="images/UG_Ui_Images/initial_customer.png" alt="Initial Customer Screen" style="max-width: 100%; height: auto;"/>
    <p><i>Customer Tab: manage customer information</i></p>
  </div>
</div>

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: left; max-width: 18%;">
    <p>3. <b>Drinks Tab</b></p>
    <p>Browse your drink catalog for the perfect cup!</p>
  </div>
  <div style="text-align: center; max-width: 78%;">
    <img src="images/UG_Ui_Images/initial_drink.png" alt="Initial Drinks Screen" style="max-width: 100%; height: auto;"/>
    <p><i>Drinks Tab: manage drink offerings</i></p>
  </div>
</div>

--------------------------------------------------------------------------------------------------------------------

## Getting Started with the User Guide

First time using **CaféConnect**? Don't worry! We've got you covered! This guide will help maximize your usage of **CaféConnect**.

* To get started, refer to the [**Understanding Command Syntax**](#understanding-command-syntax) section below, which will walk you through the basics of entering commands.
* Need a quick reference of the commands available? Check out the [**Command Summary**](#command-summary) at the end of this guide.
* Have a specific question? Browse through the relevant sections for detailed information.

**Getting Around This Guide**

* *Note boxes* provide important information that you should take note of.

  <box type="info" seamless>
  
  **Note:** This is a Note box.
  </box>

* *Warning boxes* highlight potential errors and serve as precautions against incorrect usage.

  <box type="warning" seamless>

  **Warning:** This is a warning box.
  </box>

--------------------------------------------------------------------------------------------------------------------

### Table of Contents

<!-- Table of Contents -->

  * [Welcome to CaféConnect!](#welcome-to-cafeconnect)
  * [Why would you enjoy CaféConnect?](#why-would-you-enjoy-cafeconnect)
  * [Getting Started with the User Guide](#getting-started-with-the-user-guide)
  * [Quick start](#quick-start)
  * [Understanding Command Syntax](#understanding-command-syntax)
    * [Basic Command Rules](#basic-command-rules)
    * [Parameter Command Rules](#parameter-command-rules)
    * [Command Alias](#command-alias)
  * [Features](#features)
    * [Adding a customer: `customeradd` or `ca`](#adding-a-customer-customeradd-or-ca)
    * [Quickly adding a customer: `quickcustomeradd` or `qca`](#quickly-adding-a-customer-quickcustomeradd-or-qca)
    * [Deleting a customer: `customerdelete` or `cd`](#deleting-a-customer-customerdelete-or-cd)
    * [Editing customer details: `customeredit` or `ce`](#editing-customer-details-customeredit-or-ce)
    * [Finding a customer: `customerfind` or `cf`](#finding-a-customer-customerfind-or-cf)
    * [Adding a staff: `staffadd` or `sa`](#adding-a-staff-staffadd-or-sa)
    * [Quickly adding a staff: `quickstaffadd` or `qsa`](#quickly-adding-a-staff-quickstaffadd-or-qsa)
    * [Deleting a staff: `staffdelete` or `sd`](#deleting-a-staff-staffdelete-or-sd)
    * [Editing staff details: `staffedit` or `se`](#editing-staff-details-staffedit-or-se)
    * [Finding a staff: `stafffind` or `sf`](#finding-a-staff-stafffind-or-sf)
    * [Adding a drink: `drinkadd` or `da`](#adding-a-drink-drinkadd-or-da)
    * [Deleting a drink: `drinkdelete` or `dd`](#deleting-a-drink-drinkdelete-or-dd)
    * [Recording a purchase: `purchase` or `p`](#recording-a-purchase-purchase)
    * [Quickly recording a purchase: `qp` shortcut](#quickly-recording-a-purchase-quickpurchase-or-qp)
  * [FAQ](#faq)
  * [Known Issues](#known-issues)
  * [Command Summary](#command-summary)
  * [Glossary](#glossary)
  * [Acknowledgements](#acknowledgements)

<!-- TOC -->

--------------------------------------------------------------------------------------------------------------------
## Quick start

1. Ensure you have Java `17` or above installed on your computer.<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

2. Download the latest `.jar` file from [here](https://github.com/se-edu/addressbook-level3/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your **CaféConnect** application.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar cafeconnect.jar` command to run the application.<br>

   The **CaféConnect** home screen will appear in a few seconds, displaying the application title and navigation options.

   <div style="text-align: center; max-width: 80%; margin: 0 auto;">
     <img src="images/UG_Ui_Images/welcome_screen.png" alt="CafeConnect Welcome Screen" style="max-width: 100%; height: auto;"/>
     <p><i>CaféConnect Welcome Screen</i></p>
   </div>

5. From the home screen, you have two navigation options:
   * Click on **Staff & Customer Management** to access staff and customer data directly.
   * Click on **Drinks Menu** to view and manage the drink catalog directly.

<div style="display: flex; justify-content: space-between; gap: 20px;">
   <div style="flex: 1; text-align: center;">
     <p><b>Staff & Customer Management</b></p>
     <img src="images/UG_Ui_Images/initial_staff.png" alt="Initial Staff Screen" style="max-width: 100%; height: auto;"/>
     <p><i>Initial Staff Screen</i></p>
   </div>

   <div style="flex: 1; text-align: center;">
     <p><b>Drinks Menu</b></p>
     <img src="images/UG_Ui_Images/initial_drink.png" alt="Initial Drinks Menu" style="max-width: 100%; height: auto;"/>
     <p><i>Initial Drinks Menu</i></p>
   </div>
</div>


<box type="info" seamless>

**Note:** The application comes with sample data to help you get started.
</box>

6. Type the command in the command box and press Enter to execute it. e.g., typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `help` : Opens the help window with the command guide.

   * `customeradd cid/C001 n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 rp/150 vc/8 fi/Cappuccino ts/120` : Adds a customer named `John Doe` to **CaféConnect**.

   * `staffadd sid/S1001 n/Alice Tan p/81234567 e/alice@example.com a/123, Jurong West Ave 6, #08-111 role/Barista shift/9am-5pm hours/40 rating/4.5` : Adds a staff member named `Alice Tan` to **CaféConnect**.

   * `purchase 1 n/Espresso` : Records a purchase of Espresso for the 1st customer in the list.

   * `customerdelete 3` : Deletes the 3rd customer shown in the current customer list.

   * `qca C0102:Charlie:97285712` : Quickly adds a customer.

   * `exit` : Exits the app.

7. Refer to the [Features](#features) below for details of each command. Be sure to check the [Understanding Command Syntax](#understanding-command-syntax) section to understand how to properly enter commands in CaféConnect.

--------------------------------------------------------------------------------------------------------------------


## Understanding Command Syntax

Let's start with a simple example to understand how commands work in CaféConnect:

> `help` *- This is a basic command that opens the help window.*

Breaking this down:
- A **command** is an instruction you give to CaféConnect to perform a specific action.
- Some commands, like `help`, are simple and don't need any additional information.
- Other commands require **parameters** (additional details) to work properly.

Let's look at a more complex example:
> `customeradd cid/C001 n/John Doe`

In this example:
- `customeradd` is the command.
- `cid/C001` and `n/John Doe` are parameters.
- Each parameter has a **prefix** (like `cid/`, `n/`) that tells CaféConnect what kind of information follows.

### Basic Command Rules

* Commands are **case-insensitive** - `HELP`, `help`, and `Help` all work the same way.

* Parameters shown in `UPPER_CASE` are placeholders that you need to replace with actual values:
  - Example: `cid/CUSTOMER_ID n/NAME` have placeholders `CUSTOMER_ID` and `NAME`.
  > `customeradd cid/C0001 n/John Doe` - *"C0001" replaces CUSTOMER_ID, "John Doe" replaces NAME*

* Optional parameters are shown in square brackets `[]`:
  - Example: `[t/TAG]` means you can add a tag or leave it out.
  > `customeradd cid/C0001 n/John Doe t/regular` - *Here, "regular" is an optional tag that was added*

* Some parameters can be repeated (shown with `…`):
  - Example: `[t/TAG]…` means you can add multiple tags or none at all.
  > `customeradd cid/C0001 n/John Doe t/regular t/vip` - *Here, both "regular" and "vip" are optional tags that were added*

### Parameter Order Rules

* For most commands, you can enter parameters in any order:
  - `n/John Doe p/98765432` works the same as `p/98765432 n/John Doe`

* Quick commands (like `quickcustomeradd`) need parameters in a specific order:
  - Example: `quickcustomeradd C001:John Doe:98765432` must be in ID:Name:Phone order
  > `quickcustomeradd C001:John Doe:98765432` - *Here, "C001" is the CUSTOMER_ID, "John Doe" is the NAME, and "98765432" is the PHONE*

### Command Alias

To make typing easier, CaféConnect provides alias for common commands:

* Customer Management:
  - `ca` instead of `customeradd`
  - `cd` instead of `customerdelete`
  - `cf` instead of `customerfind`

* Staff Management:
  - `sa` instead of `staffadd`
  - `sd` instead of `staffdelete`
  - `sf` instead of `stafffind`

* Drink Management:
  - `da` instead of `drinkadd`
  - `dd` instead of `drinkdelete`

* Purchase Operations:
  - `p` instead of `purchase`
  - `qp` instead of `quickpurchase`

<box type="info" seamless>

If you're using a PDF version of this guide, be careful when copying commands that span multiple lines. Some spaces might be lost when copying to the application.
</box>

## Features

Before using any commands, make sure you understand the [Understanding Command Syntax](#understanding-command-syntax) rules that apply to all commands in CaféConnect.

* When using staff-specific commands (like `staffadd`, `staffdelete`, etc.), the interface will automatically switch to the Staff tab.

* Similarly, when using customer-specific commands (like `customeradd`, `customerdelete`, etc.), the interface will automatically switch to the Customers tab.

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding a customer: `customeradd` or `ca`

Adds a customer to the customer list with required details such as customer ID, name, phone, email, address, reward points, visit count, favourite item, and total spent.

Format: `customeradd cid/CUSTOMER_ID n/NAME p/PHONE e/EMAIL a/ADDRESS rp/REWARD_POINTS vc/VISIT_COUNT fi/FAVOURITE_ITEM ts/TOTAL_SPENT [t/TAG]…`

* `CUSTOMER_ID` should start with a 'C' (case-insensitive) followed by digits, e.g., C1001, c1001, and must not be longer than 10 characters. Duplicate customer IDs are not allowed
* `NAME` should only contain alphanumeric characters and spaces, and it should not be blank and must not be longer than 50 characters
* `PHONE` should only contain digits, and it should be between 3 and 20 digits long
* `EMAIL` must be a valid email address.
* `ADDRESS` can take any value, and it should not be blank and must not be longer than 100 characters
* `REWARD_POINTS` should only contain digits
* `VISIT_COUNT` should only contain digits
* `FAVOURITE_ITEM` can take any value, and it should not be blank and must not be longer than 30 characters
* `TOTAL_SPENT` should only contain digits, representing the amount in dollars

Examples:
* `customeradd cid/C001 n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 rp/150 vc/8 fi/Cappuccino ts/120`
* `ca cid/C002 n/Betsy Crowe p/1234567 e/betsycrowe@example.com a/Newgate Prison rp/300 vc/15 fi/Mocha ts/250 t/vip t/regular`

These are the before and after images of the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_customeradd.png" alt="Before adding the customer" style="max-width: 100%; height: auto;"/>
    <p><i>Before adding the customer</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_customeradd.png" alt="After adding the customer" style="max-width: 100%; height: auto;"/>
    <p><i>After adding the customer</i></p>
  </div>
</div>

<box type="info" seamless>
Note: If you add more than one each of the compulsory prefixes, the command will be treated as invalid
</box>

### Quickly adding a customer: `quickcustomeradd` or `qca`

A quick way to add customer members with minimal required information.

Format: `quickcustomeradd <CUSTOMER_ID>:<NAME>:<PHONE>`

* `CUSTOMER_ID` should start with a 'C' (case-insensitive) followed by digits, e.g., C1001, c1001, and must not be longer than 10 characters. Duplicate customer IDs are not allowed
* `NAME` should only contain alphanumeric characters and spaces, and it should not be blank and must not be longer than 50 characters
* `PHONE` should only contain digits, and it should be between 3 and 20 digits long

Examples:
* `quickcustomeradd C0102:Charlie:97285712`
* `qca S0103:Bob:80192832`

These are the before and after images of the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_quickcustomeradd.png" alt="Before adding the customer" style="max-width: 100%; height: auto;"/>
    <p><i>Before adding the customer</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_quickcustomeradd.png" alt="After adding the customer" style="max-width: 100%; height: auto;"/>
    <p><i>After adding the customer</i></p>
  </div>
</div>

### Deleting a customer: `customerdelete` or `cd`

Deletes the specified customer from CaféConnect.

Format: `customerdelete INDEX`

* Deletes the customer at the specified `INDEX`.
* The `INDEX` refers to the index number shown in the displayed customer list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* The `INDEX` **must be a valid index number** (e.g. 5 is not valid when there is less than five customers in the displayed list).

Examples:
* `customerdelete 2` deletes the 2nd customer in the customer list.
* `cd 4` when you only have three customers returns an error message.

These are the before and after images of the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_customerdelete.png" alt="Before deleting the customer" style="max-width: 100%; height: auto;"/>
    <p><i>Before deleting the customer</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_customerdelete.png" alt="After deleting the customer" style="max-width: 100%; height: auto;"/>
    <p><i>After deleting the customer</i></p>
  </div>
</div>

### Editing customer details: `customeredit` or `ce`

Edits the details of an existing customer in the customer list.

Format: `customeredit INDEX [cid/CUSTOMER_ID] [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [rp/REWARD_POINTS] [vc/VISIT_COUNT] [fi/FAVOURITE_ITEM] [ts/TOTAL_SPENT] [t/TAG]...`

* Edits the customer at the specified `INDEX`.
* The `INDEX` refers to the index number shown in the displayed customer list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* The `INDEX` **must be a valid index number** (e.g., 5 is not valid when there are fewer than five customers in the displayed list).
* At least one of the optional fields must be provided.
* Existing values will be overwritten by the input values.
* When editing tags, all of the current existing tags of the customer will be removed i.e., adding of tags is not cumulative.
* You can remove all the customer's tags by typing `t/` without specifying any tags after it.
* Character length restrictions apply as in customeradd command: NAME (max 50 chars), CUSTOMER_ID (max 10 chars), ADDRESS (max 100 chars), PHONE (3-20 chars), FAVOURITE_ITEM (max 30 chars)

Examples:
* `customeredit 1 p/99994567 e/newemail@example.com` edits the phone number and email address of the 1st customer to be `99994567` and `newemail@example.com` respectively.
* `ce 2 n/Betsy Crower rp/5000 t/` edits the name of the 2nd customer to be `Betsy Crower`, updates their reward points to `5000`, and clears all existing tags.

These are the before and after images of the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_customeredit.png" alt="Before editing customer details" style="max-width: 100%; height: auto;"/>
    <p><i>Before editing customer details</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_customeredit.png" alt="After editing customer details" style="max-width: 100%; height: auto;"/>
    <p><i>After editing customer details</i></p>
  </div>
</div>

<box type="info" seamless>
Note: If you add more than one each of the compulsory prefixes, the command will be treated as invalid
</box>

### Finding a customer: `customerfind` or `cf`

Finds and lists all customers in the customer list whose names contain any of the specified keywords. The search is case-insensitive, meaning it will match names regardless of letter casing.

Format: `customerfind [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [cid/CUSTOMER_ID] [rp/REWARD_POINTS] [vc/VISIT_COUNT] [fi/FAVOURITE_ITEM] [ts/TOTAL_SPENT] [t/TAG]...`
Format: `customerfind all/true` (to list all customers)

* The search will return all customers who matches the specified search criteria.
* At least one of the optional fields must be provided or `all/true`.
* The keyword search for `[n/NAME]` do not need to match the full name exactly; partial matches within the name are included. For example, searching `n/john doe` will match `John Doe`, `John Tan`, or `Jane Doe`.
* The keywords search for [n/NAME] will return close matches as well. For example, searching for `n/all` will match ali.
* The keywords search for `[n/NAME]` is case-insensitive. For example, searching for `alice` will match `Alice`, `ALICE`, or `aLiCe`.
* The keywords search for `[p/PHONE]` `[e/EMAIL]` `[a/ADDRESS]` `[cid/CUSTOMER_ID]` `[rp/REWARD_POINTS]` `[vc/VISIT_COUNT]` `[fi/FAVOURITE_ITEM]` `[ts/TOTAL_SPENT]` `[t/TAG]` MUST match the field exactly and is case-sensitive. For example , searching `fi/Cappuccin` will return nothing if drink should be `fi/Cappucino`; searching `fi/latte` will return nothing if drink should be `fi/Latte`
* Use `customerfind all/true` or `cf all/true` to display the complete list of all customers in CaféConnect.

Examples:
* `customerfind n/Alice` or `cf n/Alice` finds and lists all customers whose names contain `Alice`.
* `customerfind n/John Doe` or `cf n/John Doe` finds and lists all customers whose names contain either `John` or `Doe`.
* `customerfind fi/Latte` or `cf fi/Latte` finds and lists all customers who has favourite item `Latte`
* `customerfind vc/8` or `cf vc/8` finds and lists all customers who has `Visit Count` of 8.

* `customerfind all/true` or `cf all/true` lists all customers in CaféConnect.

These are the before and after images of the second example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_customerfind.png" alt="Before searching for a customer" style="max-width: 100%; height: auto;"/>
    <p><i>Before searching for a customer</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_customerfind.png" alt="After searching for a customer" style="max-width: 100%; height: auto;"/>
    <p><i>After searching for a customer</i></p>
  </div>
</div>

### Adding a staff: `staffadd` or `sa`

Adds a staff to the staff list with required details such as staff ID, name, phone, email, address, role, shift, hours worked, and performance rating.

Format: `staffadd sid/STAFF_ID n/NAME p/PHONE e/EMAIL a/ADDRESS role/ROLE shift/SHIFT_TIMING hours/HOURS_WORKED rating/PERFORMANCE_RATING [t/TAG]...…`

* `STAFF_ID` should start with an 'S' (case-insensitive) followed by digits (e.g., S1001, s1001) and must not exceed 10 characters. Duplicate staff IDs are not allowed
* `NAME` should only contain alphanumeric characters and spaces, and it should not be blank and must not be longer than 50 characters
* `PHONE` should only contain digits, and it should be between 3 and 20 digits long
* `EMAIL` must be a valid email address
* `ADDRESS` can take any value, and it should not be blank and must not be longer than 100 characters
* `ROLE` can take any value, and it should not be blank and must not be longer than 50 characters
* `SHIFT_TIMING` can take any value, and it should not be blank and must not be longer than 50 characters
* `HOURS_WORKED` should only contain digits
* `PERFORMANCE_RATING` should only contain digits, and it should be between 0 to 5.0 (inclusive) with at most one decimal place.
* `TAG` can take any value, optional field

Examples:
* `staffadd sid/S1234 n/Alice Tan p/81234567 e/alice@example.com a/123, Jurong West Ave 6, #08-111 role/Barista shift/9am-5pm hours/40 rating/4.5 t/fullTime t/experienced`
* `sa sid/S0101 n/Bob Lim p/82019292 e/bob@example.com a/123, Tampines West Ave 7, #09-121 role/Barista shift/5pm-11pm hours/30 rating/4.5 t/fullTime`

These are the before and after images of the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_staffadd.png" alt="Before adding the staff" style="max-width: 100%; height: auto;"/>
    <p><i>Before adding the staff</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_staffadd.png" alt="After adding the customer" style="max-width: 100%; height: auto;"/>
    <p><i>After adding the staff</i></p>
  </div>
</div>
<box type="info" seamless>
Note: If you add more than one each of the compulsory prefixes, the command will be treated as invalid
</box>

### Quickly adding a staff: `quickstaffadd` or `qsa`

A quick way to add staff with minimal required information.

Format: `quickstaffadd <STAFF_ID>:<NAME>:<PHONE>`

* `STAFF_ID` should start with an 'S' (case-insensitive) followed by digits (e.g., S1001, s1001) and must not exceed 10 characters. Duplicate staff IDs are not allowed
* `NAME` should only contain alphanumeric characters and spaces, and it should not be blank and must not be longer than 50 characters
* `PHONE` should only contain digits, and it should be between 3 and 20 digits long

Examples:
* `quickstaffadd S0102:Ali:98291029`
* `qsa S0103:Bali:89201029`

These are the before and after images of the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_quickstaffadd.png" alt="Before adding the staff" style="max-width: 100%; height: auto;"/>
    <p><i>Before adding the staff</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_quickstaffadd.png" alt="After adding the customer" style="max-width: 100%; height: auto;"/>
    <p><i>After adding the staff</i></p>
  </div>
</div>

### Deleting a staff: `staffdelete` or `sd`

Deletes the specified staff from the address book.

Format: `staffdelete INDEX`

* Deletes the staff at the specified `INDEX`.
* The `INDEX` refers to the index number shown in the displayed staff list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* The `INDEX` **must be a valid index number** (e.g. 5 is not valid when there is less than five staff in the displayed list).

Examples:
* `staffdelete 2` deletes the 2nd staff in the address book.
* `sd 4` when you only have three staff returns an error message.

These are the before and after images of the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_staffdelete.png" alt="Before deleting the customer" style="max-width: 100%; height: auto;"/>
    <p><i>Before deleting the staff</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_staffdelete.png" alt="After deleting the customer" style="max-width: 100%; height: auto;"/>
    <p><i>After deleting the staff</i></p>
  </div>
</div>

### Editing staff details: `staffedit` or `se`

Edits the details of an existing staff in the staff list.

Format: `staffedit INDEX [sid/STAFF_ID] [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [role/ROLE] [shift/SHIFT_TIMING] [hours/HOURS_WORKED] [rating/PERFORMANCE_RATING] [t/TAG]...`

* Edits the staff at the specified `INDEX`.
* The `INDEX` refers to the index number shown in the displayed staff list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* The `INDEX` **must be a valid index number** (e.g., 5 is not valid when there are fewer than five staff members in the displayed list).
* At least one of the optional fields must be provided.
* Existing values will be overwritten by the input values.
* When editing tags, all of the current existing tags of the staff will be removed i.e., adding of tags is not cumulative.
* You can remove all the staff's tags by typing `t/` without specifying any tags after it.
* Character length restrictions apply as in staffadd command: NAME (max 50 chars), STAFF_ID (max 10 chars), ADDRESS (max 100 chars), PHONE (3-20 chars), ROLE (max 50 chars), SHIFT_TIMING (max 50 chars)

Examples:
* `staffedit 1 p/99994567 e/newemail@example.com` edits the phone number and email address of the 1st staff to be `99994567` and `newemail@example.com` respectively.
* `se 2 n/Betsy Crower sid/S002 t/` edits the name of the 2nd staff to be `Betsy Crower`, changes the staff ID to `S002`, and clears all existing tags.

These are the before and after images of the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_staffedit.png" alt="Before editing staff details" style="max-width: 100%; height: auto;"/>
    <p><i>Before editing staff details</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_staffedit.png" alt="After editing staff details" style="max-width: 100%; height: auto;"/>
    <p><i>After editing staff details</i></p>
  </div>
</div>
<box type="info" seamless>
Note: If you add more than one each of the compulsory prefixes, the command will be treated as invalid
</box>

### Finding a staff: `stafffind` or `sf`

Finds and lists all staffs in the staff list whose names contain any of the specified keywords. The search is case-insensitive, meaning it will match names regardless of letter casing.

Format: `stafffind [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [sid/STAFF_ID] [role/ROLE] [shift/SHIFT_TIMING] [hours/HOURS_WORKED] [rating/PERFORMANCE_RATING] [t/TAG]...`
Format: `stafffind all/true` (to list all staff)

* The search will return all staffs who matches the specified search criteria.
* At least one of the optional fields must be provided or `all/true`.
* The keyword search for `[n/NAME]` do not need to match the full name exactly; partial matches within the name are included. For example, searching `n/john doe` will match `John Doe`, `John Tan`, or `Jane Doe`.
* The keywords search for `[n/NAME]` is case-insensitive. For example, searching for `alice` will match `Alice`, `ALICE`, or `aLiCe`.
* The keywords search for [n/NAME] will return close matches as well. For example, searching for `n/all` will match ali.
* The keywords search for `[p/PHONE]` `[e/EMAIL]` `[a/ADDRESS]` `[sid/STAFF_ID]` `[role/ROLE]` `[shift/SHIFT_TIMING]` `[hours/HOURS_WORKED]` `[rating/PERFORMANCE_RATING]` `[t/TAG]` MUST match the field exactly and is case-sensitive. For example , searching `role/Barist` will return nothing if role should be `role/Barista`; searching `role/chef` will return nothing if drink should be `role/Chef`
* Use `stafffind all/true` or `sf all/true` to display the complete list of all staff in CaféConnect.

Examples:
* `stafffind n/Alice` or `sf n/Alice` finds and lists all staffs whose names contain `Alice`.
* `stafffind n/John Doe` or `sf n/John Doe` finds and lists all staffs whose names contain either `John` or `Doe`.
* `stafffind role/Chef` or `sf role/Chef` finds and lists all staffs whose role is `Chef`.
* `stafffind hours/10` or `sf hours/10` finds and lists all customers who have `Hours Worked` of 10.
* `stafffind all/true` or `sf all/true` lists all staff in CaféConnect.

These are the before and after images of the second example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_stafffind.png" alt="Before searching for a staff" style="max-width: 100%; height: auto;"/>
    <p><i>Before searching for a staff</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_stafffind.png" alt="After searching for a staff" style="max-width: 100%; height: auto;"/>
    <p><i>After searching for a staff</i></p>
  </div>
</div>



### Adding a drink: `drinkadd` or `da`

Adds a new drink to the drink catalog with details such as name, price, and category.

Format: `drinkadd n/NAME p/PRICE c/CATEGORY`

* `NAME` is the name of the drink
* `PRICE` should be a positive number with up to 2 decimal places and must be at least $1.00.
* `CATEGORY` is the classification of the drink (e.g., Coffee, Tea, etc.)

Examples:
* `drinkadd n/Iced Latte p/4.50 c/Coffee` adds an Iced Latte under the Coffee category with a price of $4.50
* `da n/Chai Tea p/3.80 c/Tea` adds a Chai Tea under the Tea category with a price of $3.80

These are the before and after images of the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_drinkadd.png" alt="Before adding the drink" style="max-width: 100%; height: auto;"/>
    <p><i>Before adding the drink</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_drinkadd.png" alt="After adding the drink" style="max-width: 100%; height: auto;"/>
    <p><i>After adding the drink</i></p>
  </div>
</div>
<box type="info" seamless>
Note: If you add more than one each of the compulsory prefixes, the command will be treated as invalid
</box>

### Deleting a drink: `drinkdelete` or `dd`

Deletes the specified customer from CaféConnect.

Format: `drinkdelete INDEX`

* Deletes the customer at the specified `INDEX`.
* The `INDEX` refers to the index number shown in the displayed drink list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* The `INDEX` **must be a valid index number** (e.g. 5 is not valid when there is less than five drinks in the displayed list).

Examples:
* `drinkdelete 1` deletes the 1st drink in the drink list.
* `dd 4` when you only have three drinks returns an error message.

These are the before and after images of the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_drinkdelete.png" alt="Before deleting the drink" style="max-width: 100%; height: auto;"/>
    <p><i>Before deleting the drink</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_drinkdelete.png" alt="After deleting the drink" style="max-width: 100%; height: auto;"/>
    <p><i>After deleting the drink</i></p>
  </div>
</div>


### Recording a purchase: `purchase` or `p`

Records a purchase for a customer, updating their total spent, visit count, and reward points. Optionally, allows users to redeem reward points to pay for the purchase.

Format: `purchase INDEX n/DRINK_NAME [redeem/true]`

* Records a purchase for the customer at the specified `INDEX`.
* The `INDEX` refers to the index number shown in the displayed customer list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* The `INDEX` **must be a valid index number** (e.g., 5 is not valid when there are fewer than five customers in the displayed list).
* `DRINK_NAME` must match a drink that exists in the drink catalog.
* For standard purchases (without redemption):
  * For every $1 spent, customers earn 10 reward points.
  * Total spent is updated with the drink price.
* For redemption purchases (with `redeem/true`):
  * Reward points are deducted at a rate of 100 points = $1 (e.g., a $4.50 drink costs 450 points).
  * Total spent is not updated as the purchase is made with points.
* Visit count will be incremented by 1 for each purchase, including redemptions.

Examples:
* `purchase 1 n/Espresso` records a regular purchase of an Espresso for the 1st customer, updating their total spent and adding reward points.
* `p 2 n/Cappuccino redeem/true` redeems a Cappuccino for the 2nd customer using their reward points.

##### Standard Purchase

These are the before and after images of a standard purchase using the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_purchase.png" alt="Before standard purchase" style="max-width: 100%; height: auto;"/>
    <p><i>Before standard purchase</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_purchase.png" alt="After standard purchase (points added and total spent increased)" style="max-width: 100%; height: auto;"/>
    <p><i>After standard purchase (points added and total spent increased)</i></p>
  </div>
</div>

##### Redemption Purchase

These are the before and after images of a redemption purchase using the second example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_purchase_redeem.png" alt="Before redemption purchase" style="max-width: 100%; height: auto;"/>
    <p><i>Before redemption purchase</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_purchase_redeem.png" alt="After redemption purchase" style="max-width: 100%; height: auto;"/>
    <p><i>After redemption purchase (points deducted, total spent unchanged)</i></p>
  </div>
</div>
<box type="info" seamless>
Note: If you add more than one each of the compulsory prefixes, the command will be treated as invalid
</box>

### Quickly Recording a purchase: `quickpurchase` or `qp`

A quick way to record purchases with minimal required information.

Format: `quickpurchase INDEX:DRINK_NAME[:r]`

* Records a purchase for the customer at the specified `INDEX`.
* `DRINK_NAME` must match a drink that exists in the drink catalog.
* Add `:r` at the end to indicate this is a redemption purchase using reward points.
* Without `:r`, it will be processed as a standard purchase.

Examples:
* `quickpurchase 1:Espresso` records a regular purchase of an Espresso for the 1st customer.
* `qp 1:Espresso:r` redeems an Espresso for the 1st customer using reward points.

##### Standard Quick Purchase

These are the before and after images of a standard quick purchase using the first example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_quickpurchase.png" alt="Before standard purchase" style="max-width: 100%; height: auto;"/>
    <p><i>Before standard purchase</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_quickpurchase.png" alt="After standard purchase" style="max-width: 100%; height: auto;"/>
    <p><i>After standard purchase (points added and total spent increased)</i></p>
  </div>
</div>

##### Redemption Quick Purchase

These are the before and after images of a redemption quick purchase using the second example

<div style="display: flex; justify-content: center; align-items: flex-start; gap: 20px; flex-wrap: wrap; margin-bottom: 20px;">
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/before_quickpurchase_redeem.png" alt="Before redemption purchase" style="max-width: 100%; height: auto;"/>
    <p><i>Before redemption purchase</i></p>
  </div>
  <div style="text-align: center; max-width: 48%;">
    <img src="images/UG_Ui_Images/after_quickpurchase_redeem.png" alt="After redemption purchase" style="max-width: 100%; height: auto;"/>
    <p><i>After redemption purchase (points deducted, total spent unchanged)</i></p>
  </div>
</div>
<box type="info" seamless>
Note: If you add more than one each of the compulsory prefixes, the command will be treated as invalid
</box>

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

CaféConnect data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

CaféConnect data are saved automatically in the following JSON files:
- Address book data: `[JAR file location]/data/addressbook.json`
- Drink catalog data: `[JAR file location]/data/drinkcatalog.json`
- User preferences: `[JAR file location]/preferences.json`

Advanced users are welcome to update data directly by editing these data files.


<box type="warning" seamless>

**Caution:**
If your changes to any data file makes its format invalid, CaféConnect will discard all data in that file and start with an empty data file at the next run. Hence, it is recommended to take a backup of the files before editing them.<br>
Furthermore, certain edits can cause CaféConnect to behave in unexpected ways (e.g., if a value entered is outside the acceptable range for the address book, drink catalog, or user preferences). Therefore, edit the data files only if you are confident that you can update them correctly.
</box>
--------------------------------------------------------------------------------------------------------------------

## FAQ

Get your questions or doubts about CaféConnect's functionality and details answered here. If you have further questions, you can contact us through our email <font color="#dd0000">cafeconnect@gmail.com</font>.

#### Q1: Where is the data for the application stored?

Ans: CaféConnect's data is saved automatically as JSON files `[JAR file location]/data/addressbook.json` for customer and staff data, `[JAR file location]/data/drinkcatalog.json` for drink catalog data, and `[JAR file location]/preferences.json` for user preferences. You can make a backup of these files if you wish to.

#### Q2: How do I transfer my data to another computer?

Ans: Install CaféConnect on the other computer. Then copy and replace the following files from your current installation to the new one:
- `[JAR file location]/data/addressbook.json` (for customer and staff data)
- `[JAR file location]/data/drinkcatalog.json` (for drink catalog data)
- `[JAR file location]/preferences.json` (for user preferences)

#### Q3: Can I edit the data files directly?

Ans: You are strongly encouraged to **not** edit the JSON data files directly. You can use the commands as mentioned above to manage any data. Should the changes made to the data files cause the format to be invalid, CaféConnect will discard all data and start with an empty data file. It is highly recommended to make a copy of the data files before editing them.

Users should only edit the data files only if they are confident in updating them correctly.

#### Q4: What is considered valid, when editing the JSON data files directly?

Ans: Data entries are valid as long as it follows the data entry rules enforced by the application, and are achievable using the available commands.

Examples:
Having `C001` is an invalid `customerId` field for a customer, if it's already assigned to another customer, as there is no sequence of commands that will lead to duplicate customer IDs.

Having `regular` is a valid `tag` field for a customer, as the user can `customeradd` a customer and add the tag via `t/regular`.

#### Q5: How are reward points calculated?

Ans: Currently, customers earn 10 points for every $1 spent on purchases. Points are automatically updated when you record a purchase using the `purchase` command.

#### Q6: Will my customer's reward points expire?

Ans: CaféConnect doesn't have a built-in expiration for reward points. Points accumulate indefinitely until used.

#### Q7: What happens if I try to record a purchase for a drink that's not in the catalog?

Ans: The system will display an error message indicating that the drink was not found in the catalog.

#### Q8: After I add a new customer or staff, where will they appear in the list?

Ans: New entries will not be inserted in any specific order. They are inserted to the bottom of the list.

#### Q9: Will adding/deleting customers or staff be reflected immediately in the UI?

Ans: Yes, all changes to customer or staff data are immediately reflected in the UI. The information panels will update to show the current state of your data.

#### Q10: Are there quicker means to add customers and staff quickly?

Ans: Yes, you can use the quick version of these commands:
- For customers: `qca C0102:Charlie:97285712`
- For staff: `qsa S0102:Ali:98291029`

In fact, the corresponding quick version works for purchases made:
- For purchase: `qp 1:Latte`
- For purchase (redeem): `qp 1:Latte:r`

Quick commands streamline operations by minimizing keystrokes and simplifying syntax, making them ideal for fast-paced café environments.

#### Q11: Can I import existing customer data from CSV or Excel files?

Ans: Currently, CaféConnect doesn't support direct importing from spreadsheet files. You'll need to enter customer and staff data manually.

#### Q12: How do I track staff working hours?

Ans: Use the `staffedit` command to edit worked hours to a staff member's record.

#### Q13: Can I edit a customer's visit count manually?

Ans: Yes, the visit count can be edited via the `customeredit`.

#### Q14: How do I view all staff or customers again after using find commands?

Ans: Use the `stafffind all/true` command to show all staff, or `customerfind all/true` to show all customers again.

--------------------------------------------------------------------------------------------------------------------

## Troubleshooting

If you are facing problems while setting up or using CaféConnect, we want to help you. This section covers some of the common problems and ways to solve them.

### CaféConnect application setup failed

Check that you have the `cafeconnect.jar` in the correct folder and copied the correct file path into the terminal. Check that you have Java `17` or above installed on your computer. Follow the correct set of instructions based on your operating system.

### Getting errors when using the commands

- Check that you have typed the correct command syntax as explained in the [Understanding Command Syntax](#understanding-command-syntax) section.
- Verify you have included all necessary parameters.
- Ensure you have used valid inputs within character limits:
  - NAME must not exceed 50 characters
  - CUSTOMER_ID/STAFF_ID must not exceed 10 characters
  - ADDRESS must not exceed 100 characters
  - PHONE must be between 3 and 20 characters
  - FAVOURITE_ITEM must not exceed 30 characters
  - ROLE and SHIFT_TIMING must not exceed 50 characters

### "Unknown command" error appears

- Check for typos in the command name (e.g., `customeradd` vs `customradd`)
- Verify you're using the correct command syntax as specified in the [Understanding Command Syntax](#understanding-command-syntax) section
- Remember commands are case-insensitive, but parameter prefixes must be exact (e.g., `n/` for name)

### Interface not showing all information

- Try resizing the application window to view more content
- Use the appropriate tab (Staff, Customers, or Drinks Menu) to view specific information
- If information appears cut off, try scrolling within panels to view additional content

### Missing customer or staff data after adding

- Verify you've entered all required fields
- Check if you're in the correct tab to view the newly added entry
- Try using the find command with `all/true` parameter to refresh the list view

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard alias `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command Summary

Command | Format | Examples
--------|--------|---------
**Add Customer** | `customeradd cid/CUSTOMER_ID n/NAME p/PHONE e/EMAIL a/ADDRESS rp/REWARD_POINTS vc/VISIT_COUNT fi/FAVOURITE_ITEM ts/TOTAL_SPENT [t/TAG]…` | `customeradd cid/C001 n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 rp/150 vc/8 fi/Cappuccino ts/120 t/regular`
**Add Customer (Alias)** | `ca cid/CUSTOMER_ID n/NAME p/PHONE e/EMAIL a/ADDRESS rp/REWARD_POINTS vc/VISIT_COUNT fi/FAVOURITE_ITEM ts/TOTAL_SPENT [t/TAG]…` | `ca cid/C001 n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 rp/150 vc/8 fi/Cappuccino ts/120 t/regular`
**Quick Add Customer** | `quickcustomeradd <CUSTOMER_ID>:<NAME>:<PHONE>` | `quickcustomeradd C0102:Charlie:97285712`
**Quick Add Customer (Alias)** | `qca <CUSTOMER_ID>:<NAME>:<PHONE>` | `qca C0102:Charlie:97285712`
**Delete Customer** | `customerdelete INDEX` | `customerdelete 2`
**Delete Customer (Alias)** | `cd INDEX` | `cd 2`
**Edit Customer** | `customeredit INDEX [cid/CUSTOMER_ID] [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [rp/REWARD_POINTS] [vc/VISIT_COUNT] [fi/FAVOURITE_ITEM] [ts/TOTAL_SPENT] [t/TAG]...` | `customeredit 1 p/99994567 e/newemail@example.com`
**Edit Customer (Alias)** | `ce INDEX [cid/CUSTOMER_ID] [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [rp/REWARD_POINTS] [vc/VISIT_COUNT] [fi/FAVOURITE_ITEM] [ts/TOTAL_SPENT] [t/TAG]...` | `ce 1 p/99994567 e/newemail@example.com`
**Find Customer** | `customerfind [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [cid/CUSTOMER_ID] [rp/REWARD_POINTS] [vc/VISIT_COUNT] [fi/FAVOURITE_ITEM] [ts/TOTAL_SPENT] [t/TAG]...` | `customerfind n/John Doe`
**Find Customer (Alias)** | `cf [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [cid/CUSTOMER_ID] [rp/REWARD_POINTS] [vc/VISIT_COUNT] [fi/FAVOURITE_ITEM] [ts/TOTAL_SPENT] [t/TAG]...` | `cf n/John Doe`
**List All Customers** | `customerfind all/true` | -
**List All Customers (Alias)** | `cf all/true` | -
**Add Staff** | `staffadd sid/STAFF_ID n/NAME p/PHONE e/EMAIL a/ADDRESS role/ROLE shift/SHIFT_TIMING hours/HOURS_WORKED rating/PERFORMANCE_RATING [t/TAG]...` | `staffadd sid/S1234 n/Alice Tan p/81234567 e/alice@example.com a/123, Jurong West Ave 6, #08-111 role/Barista shift/9am-5pm hours/40 rating/4.5 t/fullTime`
**Add Staff (Alias)** | `sa sid/STAFF_ID n/NAME p/PHONE e/EMAIL a/ADDRESS role/ROLE shift/SHIFT_TIMING hours/HOURS_WORKED rating/PERFORMANCE_RATING [t/TAG]...` | `sa sid/S1234 n/Alice Tan p/81234567 e/alice@example.com a/123, Jurong West Ave 6, #08-111 role/Barista shift/9am-5pm hours/40 rating/4.5 t/fullTime`
**Quick Add Staff** | `quickstaffadd <STAFF_ID>:<NAME>:<PHONE>` | `quickstaffadd S0102:Ali:98291029`
**Quick Add Staff (Alias)** | `qsa <STAFF_ID>:<NAME>:<PHONE>` | `qsa S0102:Ali:98291029`
**Delete Staff** | `staffdelete INDEX` | `staffdelete 2`
**Delete Staff (Alias)** | `sd INDEX` | `sd 2`
**Edit Staff** | `staffedit INDEX [sid/STAFF_ID] [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [role/ROLE] [shift/SHIFT_TIMING] [hours/HOURS_WORKED] [rating/PERFORMANCE_RATING] [t/TAG]...` | `staffedit 1 p/99994567 e/newemail@example.com`
**Edit Staff (Alias)** | `se INDEX [sid/STAFF_ID] [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [role/ROLE] [shift/SHIFT_TIMING] [hours/HOURS_WORKED] [rating/PERFORMANCE_RATING] [t/TAG]...` | `se 1 p/99994567 e/newemail@example.com`
**Find Staff** | `stafffind [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [sid/STAFF_ID] [role/ROLE] [shift/SHIFT_TIMING] [hours/HOURS_WORKED] [rating/PERFORMANCE_RATING] [t/TAG]...` | `stafffind n/Alice`
**Find Staff (Alias)** | `sf [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [sid/STAFF_ID] [role/ROLE] [shift/SHIFT_TIMING] [hours/HOURS_WORKED] [rating/PERFORMANCE_RATING] [t/TAG]...` | `sf n/Alice`
**List All Staff** | `stafffind all/true` | -
**List All Staff (Alias)** | `sf all/true` | -
**Add Drink** | `drinkadd n/NAME p/PRICE c/CATEGORY` | `drinkadd n/Iced Latte p/4.50 c/Coffee`
**Add Drink (Alias)** | `da n/NAME p/PRICE c/CATEGORY` | `da n/Iced Latte p/4.50 c/Coffee`
**Purchase** | `purchase INDEX n/DRINK_NAME [redeem/true]` | `purchase 1 n/Espresso` or `purchase 2 n/Cappuccino redeem/true`
**Purchase (Alias)** | `p INDEX n/DRINK_NAME [redeem/true]` | `p 1 n/Espresso` or `p 2 n/Cappuccino redeem/true`
**Quick Purchase** | `quickpurchase INDEX:DRINK_NAME[:r]` | `quickpurchase 1:Espresso` or `quickpurchase 2:Cappuccino:r`
**Quick Purchase (Alias)** | `qp INDEX:DRINK_NAME[:r]` | `qp 1:Espresso` or `qp 2:Cappuccino:r`
**Help** | `help` | -

--------------------------------------------------------------------------------------------------------------------

## Glossary

Term | Definition
-----|------------
Action | The task carried out by the CaféConnect application such as Add, Delete, Edit entries.
Alphanumeric | Consisting of both letters and numbers.
Command | The input the user types into the CaféConnect application's command box to carry out a particular action.
Command Box | The input bar at the bottom of the CaféConnect application which allows users to type in a string command.
Command Line Interface (CLI) | An interface that the user interacts with by typing text commands instead of using a mouse to click on buttons or icons.
Customer ID | A unique identifier for each customer in the system, starting with 'C' followed by digits (e.g., C001).
Favourite Item | A drink or food item that a particular customer frequently orders or prefers.
Graphical User Interface (GUI) | An interface that the user interacts with using visual elements like buttons, icons and windows.
Index | The application number of the customer or staff displayed in the list.
Parameter | The details needed to perform specific commands (e.g., Add command has parameters for name, phone, etc.).
Performance Rating | A numeric value between 0 and 5.0 that represents a staff member's performance evaluation.
Prefix | A character or set of characters at the beginning of a parameter that identifies its type (e.g., 'n/' for name, 'p/' for phone).
Redemption | Using accumulated reward points to pay for a purchase instead of cash.
Reward Points | Points earned by customers with each purchase that can be redeemed for future purchases.
Shift Timing | The working hours of a staff member (e.g., "9am-5pm").
Staff ID | A unique identifier for each staff member in the system, starting with 'S' followed by digits (e.g., S001).
Tab | A section of the CaféConnect interface that organizes related information (Staff, Customers, or Drinks Menu).
Tag | An optional label that can be attached to a customer or staff entry for easy categorization.
Total Spent | The cumulative amount a customer has spent at the café, excluding redemption purchases.
Visit Count | The number of times a customer has visited the café, including both standard purchases and redemptions.

--------------------------------------------------------------------------------------------------------------------

## Acknowledgements

We would like to acknowledge the following contributions:

We started with a general [AB3 user guide](https://se-education.org/addressbook-level3/UserGuide.html) template and adapted it to the functional requirements of CaféConnect. We also used [MarkBind](https://markbind.org/) which is a third party library to generate a dynamic user guide website from Markdown text.

AI tools such as ChatGPT were also used to check for grammatical errors.
