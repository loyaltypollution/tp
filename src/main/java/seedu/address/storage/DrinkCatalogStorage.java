package seedu.address.storage;

import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.DrinkCatalog;
import seedu.address.model.drink.ReadOnlyDrinkCatalog;

/**
 * Represents a storage for {@link DrinkCatalog}.
 */
public interface DrinkCatalogStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getDrinkCatalogFilePath();

    /**
     * Returns DrinkCatalog data as a {@link ReadOnlyDrinkCatalog}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataLoadingException if the data file is not in the correct format.
     */
    Optional<ReadOnlyDrinkCatalog> readDrinkCatalog() throws DataLoadingException;

    /**
     * @see #getDrinkCatalogFilePath()
     */
    Optional<ReadOnlyDrinkCatalog> readDrinkCatalog(Path filePath) throws DataLoadingException;

    /**
     * Saves the given {@link ReadOnlyDrinkCatalog} to the storage.
     * @param drinkCatalog cannot be null.
     * @throws java.io.IOException if there was any problem writing to the file.
     */
    void saveDrinkCatalog(ReadOnlyDrinkCatalog drinkCatalog) throws java.io.IOException;

    /**
     * @see #saveDrinkCatalog(ReadOnlyDrinkCatalog)
     */
    void saveDrinkCatalog(ReadOnlyDrinkCatalog drinkCatalog, Path filePath) throws java.io.IOException;
}
