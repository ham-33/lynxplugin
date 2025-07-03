package marvtech.lynx.util;

import java.io.File;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/** Utility class for creating JDBC data sources. */
public final class DatabaseProvider {

    private DatabaseProvider() {
    }

    /**
     * Create an SQLite {@link HikariDataSource} using a database file in the given folder.
     * If the folder does not exist it will be created.
     *
     * @param dataFolder plugin data folder
     * @param dbName     name of the database file
     * @return configured data source
     */
    public static HikariDataSource createSQLiteDataSource(File dataFolder, String dbName) {
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        File dbFile = new File(dataFolder, dbName);
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlite:" + dbFile.getAbsolutePath());
        config.setPoolName("Lynx-SQLite-Pool");
        return new HikariDataSource(config);
    }
}
