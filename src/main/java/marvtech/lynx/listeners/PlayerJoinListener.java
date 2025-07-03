package marvtech.lynx.listeners;

/**
 * Simple listener for join notifications used in tests.
 */
public class PlayerJoinListener {

    private int joinCount = 0;

    /**
     * Record that a player has joined the server.
     *
     * @param player player name
     */
    public void onJoin(String player) {
        joinCount++;
    }

    /**
     * Get the number of join events received.
     */
    public int getJoinCount() {
        return joinCount;
    }
}
