package marvtech.lynx.util;

import java.util.regex.Pattern;

/**
 * Helper methods for validating command arguments.
 */
public final class ValidationUtil {

    private static final Pattern NAME_PATTERN = Pattern.compile("[A-Za-z0-9_]{3,16}");

    private ValidationUtil() {
    }

    /**
     * Validate a simple player or country name.
     *
     * @param input string to validate
     * @return true if the input is a valid name
     */
    public static boolean isValidName(String input) {
        return NAME_PATTERN.matcher(input).matches();
    }
}
