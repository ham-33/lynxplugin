package marvtech.lynx.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;

/** Utility for creating database connections. */
public final class DatabaseProvider {
    private DatabaseProvider() {
    }

    /**
     * Create a SQLite based data source stored in the plugin data folder.
     *
     * @param dataFolder plugin data directory
     * @return configured data source
     */
    public static HikariDataSource createSQLiteDataSource(File dataFolder) {
        File dbFile = new File(dataFolder, "lynx.db");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlite:" + dbFile.getPath());
        config.setConnectionTestQuery("SELECT 1");
        config.setPoolName("LynxPool");
        return new HikariDataSource(config);
    }
}
