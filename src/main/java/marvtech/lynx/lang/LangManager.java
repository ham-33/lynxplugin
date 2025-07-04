package marvtech.lynx.lang;

import java.util.EnumMap;
import java.util.Map;

import marvtech.lynx.lang.keys.LangKey;

/**
 * Very small localisation manager used by tests.
 * Values are kept in memory for simplicity.
 */
public class LangManager {

    private final Map<LangKey, String> values = new EnumMap<>(LangKey.class);

    /**
     * Register a translation value.
     *
     * @param key  translation key
     * @param text translation text
     */
    public void register(LangKey key, String text) {
        values.put(key, text);
    }

    /**
     * Fetch a translation value.
     *
     * @param key translation key
     * @return stored value or the key name if missing
     */
    public String get(LangKey key) {
        return values.getOrDefault(key, key.name());
    }
}
