package marvtech.lynx.map;

import java.util.Random;

/**
 * Utility for generating hex colour codes.
 */
public final class ColorUtil {

    private static final Random RANDOM = new Random();

    private ColorUtil() {
    }

    /**
     * Generate a random HTML style hexadecimal colour string.
     *
     * @return colour string in the form <code>#RRGGBB</code>
     */
    public static String randomColor() {
        int rgb = RANDOM.nextInt(0x1000000);
        return String.format("#%06X", rgb);
    }
}
