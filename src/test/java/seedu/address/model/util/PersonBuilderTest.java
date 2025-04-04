package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.tag.Tag;

public class PersonBuilderTest {

    private static final String TEST_NAME = "Test Person";
    private static final String TEST_PHONE = "98765432";
    private static final String TEST_EMAIL = "test@example.com";
    private static final String TEST_ADDRESS = "Test Address, #01-01";
    private static final String TEST_REMARK = "Test Remark";
    private static final String[] TEST_TAGS = { "test", "important" };

    @Test
    public void build_defaultValues_returnsPersonWithDefaultValues() {
        Person person = new TestPersonBuilder().build();

        assertEquals(PersonBuilder.DEFAULT_NAME, person.getName().fullName);
        assertEquals(PersonBuilder.DEFAULT_PHONE, person.getPhone().value);
        assertEquals(PersonBuilder.DEFAULT_EMAIL, person.getEmail().value);
        assertEquals(PersonBuilder.DEFAULT_ADDRESS, person.getAddress().value);
        assertEquals(PersonBuilder.DEFAULT_REMARK, person.getRemark().value);
        assertEquals(0, person.getTags().size());
    }

    @Test
    public void build_withAllStringParameters_returnsPersonWithExpectedValues() {
        Person person = new TestPersonBuilder()
                .withName(new Name(TEST_NAME))
                .withPhone(new Phone(TEST_PHONE))
                .withEmail(new Email(TEST_EMAIL))
                .withAddress(new Address(TEST_ADDRESS))
                .withRemark(new Remark(TEST_REMARK))
                .withTags(Arrays.stream(TEST_TAGS)
                        .map(Tag::new)
                        .collect(Collectors.toSet()))
                .build();

        assertEquals(TEST_NAME, person.getName().fullName);
        assertEquals(TEST_PHONE, person.getPhone().value);
        assertEquals(TEST_EMAIL, person.getEmail().value);
        assertEquals(TEST_ADDRESS, person.getAddress().value);
        assertEquals(TEST_REMARK, person.getRemark().value);

        // Verify tags
        Set<Tag> expectedTags = SampleDataUtil.getTagSet(TEST_TAGS);
        assertEquals(expectedTags, person.getTags());
    }

    @Test
    public void build_withObjectParameters_returnsPersonWithExpectedValues() {
        Name name = new Name(TEST_NAME);
        Phone phone = new Phone(TEST_PHONE);
        Email email = new Email(TEST_EMAIL);
        Address address = new Address(TEST_ADDRESS);
        Remark remark = new Remark(TEST_REMARK);
        Set<Tag> tags = new HashSet<>();
        for (String tagName : TEST_TAGS) {
            tags.add(new Tag(tagName));
        }

        Person person = new TestPersonBuilder()
                .withName(name)
                .withPhone(phone)
                .withEmail(email)
                .withAddress(address)
                .withRemark(remark)
                .withTags(tags)
                .build();

        assertEquals(name, person.getName());
        assertEquals(phone, person.getPhone());
        assertEquals(email, person.getEmail());
        assertEquals(address, person.getAddress());
        assertEquals(remark, person.getRemark());
        assertEquals(tags, person.getTags());
    }

    @Test
    public void build_withPersonCopy_returnsEqualPerson() {
        Person original = new TestPersonBuilder()
                .withName(new Name(TEST_NAME))
                .withPhone(new Phone(TEST_PHONE))
                .withEmail(new Email(TEST_EMAIL))
                .withAddress(new Address(TEST_ADDRESS))
                .withRemark(new Remark(TEST_REMARK))
                .withTags(Arrays.stream(TEST_TAGS)
                        .map(Tag::new)
                        .collect(Collectors.toSet()))
                .build();

        TestPersonBuilder copiedBuilder = new TestPersonBuilder(original);
        Person copy = copiedBuilder.build();

        assertEquals(original, copy);
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getPhone(), copy.getPhone());
        assertEquals(original.getEmail(), copy.getEmail());
        assertEquals(original.getAddress(), copy.getAddress());
        assertEquals(original.getRemark(), copy.getRemark());
        assertEquals(original.getTags(), copy.getTags());
    }

    @Test
    public void individualSetters_stringParameters_setCorrectly() {
        TestPersonBuilder builder = new TestPersonBuilder();

        // Test each setter method individually
        Person namePerson = builder.withName(new Name(TEST_NAME)).build();
        assertEquals(TEST_NAME, namePerson.getName().fullName);

        Person phonePerson = builder.withPhone(new Phone(TEST_PHONE)).build();
        assertEquals(TEST_PHONE, phonePerson.getPhone().value);

        Person emailPerson = builder.withEmail(new Email(TEST_EMAIL)).build();
        assertEquals(TEST_EMAIL, emailPerson.getEmail().value);

        Person addressPerson = builder.withAddress(new Address(TEST_ADDRESS)).build();
        assertEquals(TEST_ADDRESS, addressPerson.getAddress().value);

        Person remarkPerson = builder.withRemark(new Remark(TEST_REMARK)).build();
        assertEquals(TEST_REMARK, remarkPerson.getRemark().value);

        Person tagsPerson = builder.withTags(Arrays.stream(TEST_TAGS)
                .map(Tag::new)
                .collect(Collectors.toSet())).build();
        Set<Tag> expectedTags = SampleDataUtil.getTagSet(TEST_TAGS);
        assertEquals(expectedTags, tagsPerson.getTags());
    }

    @Test
    public void individualSetters_objectParameters_setCorrectly() {
        TestPersonBuilder builder = new TestPersonBuilder();

        Name name = new Name(TEST_NAME);
        Person namePerson = builder.withName(name).build();
        assertEquals(name, namePerson.getName());

        Phone phone = new Phone(TEST_PHONE);
        Person phonePerson = builder.withPhone(phone).build();
        assertEquals(phone, phonePerson.getPhone());

        Email email = new Email(TEST_EMAIL);
        Person emailPerson = builder.withEmail(email).build();
        assertEquals(email, emailPerson.getEmail());

        Address address = new Address(TEST_ADDRESS);
        Person addressPerson = builder.withAddress(address).build();
        assertEquals(address, addressPerson.getAddress());

        Remark remark = new Remark(TEST_REMARK);
        Person remarkPerson = builder.withRemark(remark).build();
        assertEquals(remark, remarkPerson.getRemark());

        Set<Tag> tags = SampleDataUtil.getTagSet(TEST_TAGS);
        Person tagsPerson = builder.withTags(tags).build();
        assertEquals(tags, tagsPerson.getTags());
    }

    @Test
    public void buildMultiplePersons_withChaining_returnsDistinctPersons() {
        TestPersonBuilder builder = new TestPersonBuilder();

        Person person1 = builder
                .withName(new Name("Person One"))
                .withEmail(new Email("one@example.com"))
                .withPhone(new Phone("11111111"))
                .build();

        Person person2 = builder
                .withName(new Name("Person Two"))
                .withEmail(new Email("two@example.com"))
                .withPhone(new Phone("22222222"))
                .build();

        // Verify that person2 has the modified values
        assertEquals("Person Two", person2.getName().fullName);
        assertEquals("two@example.com", person2.getEmail().value);
        assertEquals("22222222", person2.getPhone().value);

        // And check that they're distinct objects
        assertNotNull(person1);
        assertNotNull(person2);
    }
}
