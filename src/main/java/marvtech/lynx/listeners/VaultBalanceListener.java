package marvtech.lynx.listeners;

/**
 * Listener that tracks balance change events.
 */
public class VaultBalanceListener {

    private double lastAmount;

    /**
     * Called when a balance update occurs.
     *
     * @param newAmount the new balance
     */
    public void onBalanceChange(double newAmount) {
        lastAmount = newAmount;
    }

    public double getLastAmount() {
        return lastAmount;
    }
}
