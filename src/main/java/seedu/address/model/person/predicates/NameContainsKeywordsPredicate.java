package seedu.address.model.person.predicates;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.TextMatchUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 * Supports both exact matching and fuzzy matching.
 */
public class NameContainsKeywordsPredicate implements Predicate<Person> {

    private static final int FUZZY_MATCH_THRESHOLD = 85; // Token set ratio threshold for fuzzy matching
    private static final int DEFAULT_MAX_LEVENSHTEIN_DISTANCE = 2; // Default max Levenshtein distance

    private final List<String> keywords;
    private final boolean useFuzzyMatching;

    /**
     * Constructs a predicate with the given keywords using exact matching.
     */
    public NameContainsKeywordsPredicate(List<String> keywords) {
        this(keywords, false);
    }

    /**
     * Constructs a predicate with the given keywords and matching strategy.
     *
     * @param keywords List of keywords to match against
     * @param useFuzzyMatching If true, uses fuzzy matching in addition to exact matching
     */
    public NameContainsKeywordsPredicate(List<String> keywords, boolean useFuzzyMatching) {
        this.keywords = keywords;
        this.useFuzzyMatching = useFuzzyMatching;
    }

    @Override
    public boolean test(Person person) {
        if (keywords.isEmpty()) {
            return false;
        }

        String personName = person.getName().fullName;

        // Check for exact matches first (faster)
        boolean exactMatch = keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(personName, keyword));

        if (exactMatch || !useFuzzyMatching) {
            return exactMatch;
        }

        // Convert keywords list back to a single string for fuzzy matching
        String keywordsString = String.join(" ", keywords);

        // If no exact match and fuzzy matching is enabled, check for fuzzy matches
        return TextMatchUtil.areSimilarStrings(
                keywordsString.toLowerCase(),
                personName.toLowerCase(),
                DEFAULT_MAX_LEVENSHTEIN_DISTANCE,
                FUZZY_MATCH_THRESHOLD);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NameContainsKeywordsPredicate)) {
            return false;
        }

        NameContainsKeywordsPredicate otherNameContainsKeywordsPredicate = (NameContainsKeywordsPredicate) other;
        return keywords.equals(otherNameContainsKeywordsPredicate.keywords)
                && useFuzzyMatching == otherNameContainsKeywordsPredicate.useFuzzyMatching;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("keywords", keywords)
                .add("useFuzzyMatching", useFuzzyMatching)
                .toString();
    }
}
