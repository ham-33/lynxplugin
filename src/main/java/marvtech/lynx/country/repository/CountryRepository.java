package marvtech.lynx.country.repository;

import com.zaxxer.hikari.HikariDataSource;
import marvtech.lynx.country.model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Persistence operations for countries. */
public class CountryRepository {
    private final HikariDataSource dataSource;

    public CountryRepository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /** Initialize database table. */
    public void init() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS countries (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "name TEXT UNIQUE NOT NULL)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }

    /** Persist a new country. */
    public Country save(String name) throws SQLException {
        String sql = "INSERT INTO countries(name) VALUES (?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return new Country(keys.getInt(1), name);
                }
            }
        }
        return null;
    }

    /** Find a country by id. */
    public Country find(int id) throws SQLException {
        String sql = "SELECT id, name FROM countries WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Country(rs.getInt("id"), rs.getString("name"));
                }
            }
        }
        return null;
    }
}
