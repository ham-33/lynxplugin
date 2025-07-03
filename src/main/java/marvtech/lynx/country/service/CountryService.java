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
}
