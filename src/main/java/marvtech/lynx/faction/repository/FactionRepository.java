package marvtech.lynx.faction.repository;

import com.zaxxer.hikari.HikariDataSource;
import marvtech.lynx.faction.model.Faction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Persistence operations for factions. */
public class FactionRepository {
    private final HikariDataSource dataSource;

    public FactionRepository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /** Initialize database table. */
    public void init() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS factions (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "name TEXT UNIQUE NOT NULL)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }

    /** Persist a new faction. */
    public Faction save(String name) throws SQLException {
        String sql = "INSERT INTO factions(name) VALUES (?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return new Faction(keys.getInt(1), name);
                }
            }
        }
        return null;
    }

    /** Find a faction by id. */
    public Faction find(int id) throws SQLException {
        String sql = "SELECT id, name FROM factions WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Faction(rs.getInt("id"), rs.getString("name"));
                }
            }
        }
        return null;
    }
}
