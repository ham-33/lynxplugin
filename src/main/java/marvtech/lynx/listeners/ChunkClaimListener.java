package marvtech.lynx.listeners;

/**
 * Listener used in tests to record claimed chunks.
 */
public class ChunkClaimListener {

    private int claims;

    /**
     * Simulate claiming a chunk.
     */
    public void onClaim() {
        claims++;
    }

    public int getClaims() {
        return claims;
    }
}
