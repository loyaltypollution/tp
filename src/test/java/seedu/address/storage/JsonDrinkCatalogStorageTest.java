package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.address.testutil.Assert.assertThrows;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.DrinkCatalog;

public class JsonDrinkCatalogStorageTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonDrinkCatalogStorageTest");

    @TempDir
    public Path testFolder;

    private Path validFilePath;
    private Path invalidFilePath;
    private Path malformedFilePath;

    @BeforeEach
    public void setUp() throws IOException {
        validFilePath = testFolder.resolve("validDrinkCatalog.json");
        invalidFilePath = testFolder.resolve("invalidDrinkCatalog.json");
        malformedFilePath = testFolder.resolve("malformedDrinkCatalog.json");

        // Create a valid JSON file
        Files.write(validFilePath, getValidJsonContent().getBytes(StandardCharsets.UTF_8));

        // Create an invalid JSON file (wrong format)
        Files.write(invalidFilePath, getInvalidJsonContent().getBytes(StandardCharsets.UTF_8));

        // Create a malformed JSON file (corrupt)
        Files.write(malformedFilePath, "{ invalid json ".getBytes(StandardCharsets.UTF_8));
    }

    private String getValidJsonContent() {
        return "{ \"drinks\": [ "
            + "{ \"name\": \"Latte\", \"price\": 4.50, \"size\": \"Medium\", \"ingredients\":"
            + " [\"Espresso\", \"Milk\"] }, "
            + "{ \"name\": \"Cappuccino\", \"price\": 4.00, \"size\": \"Small\", \"ingredients\":"
            + "[\"Espresso\", \"Milk\", \"Foam\"] } "
            + "] }";
    }

    private String getInvalidJsonContent() {
        return "{ \"drinks\": [ "
            + "{ \"name\": \"Espresso\", \"price\": \"invalid_price\", \"size\": \"Small\", \"ingredients\": [] } "
            + "] }";
    }

    @Test
    public void readDrinkCatalog_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new JsonDrinkCatalogStorage(null).readDrinkCatalog(null));
    }

    @Test
    public void read_missingFile_returnsEmptyOptional() throws Exception {
        JsonDrinkCatalogStorage storage = new JsonDrinkCatalogStorage(Paths.get("missing.json"));
        assertFalse(storage.readDrinkCatalog().isPresent());
    }

    @Test
    public void read_malformedFile_throwsDataLoadingException() {
        JsonDrinkCatalogStorage storage = new JsonDrinkCatalogStorage(malformedFilePath);
        assertThrows(DataLoadingException.class, () -> storage.readDrinkCatalog());
    }

    @Test
    public void read_invalidData_throwsDataLoadingException() {
        JsonDrinkCatalogStorage storage = new JsonDrinkCatalogStorage(invalidFilePath);
        assertThrows(DataLoadingException.class, () -> storage.readDrinkCatalog());
    }



    @Test
    public void saveDrinkCatalog_nullDrinkCatalog_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
            new JsonDrinkCatalogStorage(validFilePath).saveDrinkCatalog(null));
    }

    @Test
    public void saveDrinkCatalog_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
            new JsonDrinkCatalogStorage(validFilePath).saveDrinkCatalog(new DrinkCatalog(), null));
    }
}
