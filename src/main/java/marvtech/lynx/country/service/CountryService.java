package marvtech.lynx.country.service;

import marvtech.lynx.country.model.Country;
import marvtech.lynx.country.repository.CountryRepository;

import java.sql.SQLException;

/** Service layer using {@link CountryRepository}. */
public class CountryService {
    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    /** Create and persist a new country. */
    public Country createCountry(String name) {
        try {
            return repository.save(name);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create country", e);
        }
    }

    /** Retrieve a country by id. */
    public Country getCountry(int id) {
        try {
            return repository.find(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch country", e);
        }
    }
}
