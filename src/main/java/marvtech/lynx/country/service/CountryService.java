package marvtech.lynx.country.service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import marvtech.lynx.country.model.Country;

/**
 * Simple in-memory implementation of country management.
 */
public class CountryService {
    private final Map<String, Country> countries = new ConcurrentHashMap<>();

    public Country createCountry(String name, String founder) {
        Country country = new Country(name, founder);
        countries.put(name.toLowerCase(), country);
        return country;
    }

    public void disbandCountry(String name) {
        countries.remove(name.toLowerCase());
    }

    public Country getCountry(String name) {
        return countries.get(name.toLowerCase());
    }

    public Collection<Country> getCountries() {
        return countries.values();
    }

    public void invite(String name, String player) {
        Country c = getCountry(name);
        if (c != null) {
            c.invite(player);
        }
    }

    public boolean join(String name, String player) {
        Country c = getCountry(name);
        if (c != null && c.getInvites().contains(player)) {
            c.addMember(player);
            return true;
        }
        return false;
    }

    public void leave(String name, String player) {
        Country c = getCountry(name);
        if (c != null) {
            c.removeMember(player);
        }
    }

    public void kick(String name, String player) {
        leave(name, player);
    }

    public void transfer(String name, String newFounder) {
        Country c = getCountry(name);
        if (c != null) {
            c.addMember(newFounder);
        }
    }

    public void setColor(String name, String color) {
        Country c = getCountry(name);
        if (c != null) c.setColor(color);
    }

    public void setCapital(String name, int x, int z) {
        Country c = getCountry(name);
        if (c != null) c.setCapital(x, z);
    }
=======
/** Service placeholder for country business logic. */
public class CountryService {

}
