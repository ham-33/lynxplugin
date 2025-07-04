package marvtech.lynx.util;

import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

/** Utility class for creating JDBC data sources. */
public final class DatabaseProvider {

    private DatabaseProvider() {
    }

    /**
     * Create a very small SQLite {@link DataSource} using a database file in the given folder.
     * If the folder does not exist it will be created.
     *
     * @param dataFolder plugin data folder
     * @param dbName     name of the database file
     * @return configured data source
     */
    public static DataSource createSQLiteDataSource(File dataFolder, String dbName) {
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        File dbFile = new File(dataFolder, dbName);
        final String url = "jdbc:sqlite:" + dbFile.getAbsolutePath();
        return new DataSource() {
            @Override
            public Connection getConnection() throws SQLException {
                return DriverManager.getConnection(url);
            }

            @Override
            public Connection getConnection(String username, String password) throws SQLException {
                return getConnection();
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                throw new SQLException("Not a wrapper");
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) {
                return false;
            }

            @Override
            public java.io.PrintWriter getLogWriter() {
                return null;
            }

            @Override
            public void setLogWriter(java.io.PrintWriter out) {
            }

            @Override
            public void setLoginTimeout(int seconds) {
            }

            @Override
            public int getLoginTimeout() {
                return 0;
            }

            @Override
            public java.util.logging.Logger getParentLogger() {
                return java.util.logging.Logger.getGlobal();
            }
        };
    }
}
