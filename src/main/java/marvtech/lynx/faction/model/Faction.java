package marvtech.lynx.faction.model;


import java.util.HashSet;
import java.util.Set;

/**
 * Minimal faction model storing member countries.
 */
public class Faction {
    private final String name;
    private final Set<String> countries = new HashSet<>();

    public Faction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<String> getCountries() {
        return countries;
    }

    public void addCountry(String country) {
        countries.add(country);
    }

    public void removeCountry(String country) {
        countries.remove(country);
    }
}
