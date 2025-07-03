package marvtech.lynx.util;

/**
 * Utility methods for working with simple 3D coordinates.
 */
public final class LocationUtil {

    private LocationUtil() {
    }

    /**
     * Serialise three integer coordinates to a string.
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @return comma separated string
     */
    public static String serialize(int x, int y, int z) {
        return x + "," + y + "," + z;
    }
}
