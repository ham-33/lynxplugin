package marvtech.lynx.economy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Very small economy service storing balances in memory.
 */
public class EconomyService {
    private final Map<String, Double> balances = new ConcurrentHashMap<>();

    public double getBalance(String country) {
        return balances.getOrDefault(country.toLowerCase(), 0.0);
    }

    public void deposit(String country, double amount) {
        balances.merge(country.toLowerCase(), amount, Double::sum);
    }

    public boolean withdraw(String country, double amount) {
        String key = country.toLowerCase();
        double bal = balances.getOrDefault(key, 0.0);
        if (bal < amount) return false;
        balances.put(key, bal - amount);
        return true;
    }
}
