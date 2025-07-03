package marvtech.lynx;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import marvtech.lynx.util.DatabaseProvider;

public class DatabaseMigrationTest {
    @Test
    void createDataSource() throws Exception {
        Path dir = Files.createTempDirectory("lynxdb");
        File folder = dir.toFile();
        assertDoesNotThrow(() ->
                DatabaseProvider.createSQLiteDataSource(folder, "test.db").close());
    }
}
