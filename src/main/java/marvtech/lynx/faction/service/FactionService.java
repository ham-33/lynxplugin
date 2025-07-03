package marvtech.lynx.faction.service;

import marvtech.lynx.faction.model.Faction;
import marvtech.lynx.faction.repository.FactionRepository;

import java.sql.SQLException;

/** Service layer for factions. */
public class FactionService {
    private final FactionRepository repository;

    public FactionService(FactionRepository repository) {
        this.repository = repository;
    }

    /** Create and persist a new faction. */
    public Faction createFaction(String name) {
        try {
            return repository.save(name);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create faction", e);
        }
    }

    /** Retrieve a faction by id. */
    public Faction getFaction(int id) {
        try {
            return repository.find(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch faction", e);
        }
    }
}
