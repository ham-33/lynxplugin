package marvtech.lynx.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility for loading simple key/value configuration files.
 */
public final class ConfigUtil {

    private ConfigUtil() {
    }

    /**
     * Load a {@link Properties} file from disk.
     *
     * @param file path to the properties file
     * @return loaded properties or an empty instance on failure
     */
    public static Properties loadProperties(java.io.File file) {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(file)) {
            props.load(in);
        } catch (IOException ignored) {
        }
        return props;
    }
}
