package marvtech.lynx.faction.service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import marvtech.lynx.faction.model.Faction;

/**
 * Simple in-memory implementation of faction management.
 */
public class FactionService {
    private final Map<String, Faction> factions = new ConcurrentHashMap<>();

    public Faction createFaction(String name) {
        Faction faction = new Faction(name);
        factions.put(name.toLowerCase(), faction);
        return faction;
    }

    public void deleteFaction(String name) {
        factions.remove(name.toLowerCase());
    }

    public Faction getFaction(String name) {
        return factions.get(name.toLowerCase());
    }

    public Collection<Faction> getFactions() {
        return factions.values();
    }
}
