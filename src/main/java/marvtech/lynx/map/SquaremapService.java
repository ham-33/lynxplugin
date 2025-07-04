package marvtech.lynx.map;

import java.util.HashSet;
import java.util.Set;

/**
 * Extremely small service that keeps track of updated countries.
 */
public class SquaremapService {

    private final Set<String> updatedCountries = new HashSet<>();

    /**
     * Mark a country as needing a map update.
     *
     * @param name country name
     */
    public void updateCountry(String name) {
        updatedCountries.add(name.toLowerCase());
    }

    /**
     * Retrieve and clear the pending updates.
     *
     * @return set of pending country names
     */
    public Set<String> consumeUpdates() {
        Set<String> copy = new HashSet<>(updatedCountries);
        updatedCountries.clear();
        return copy;
    }
}
