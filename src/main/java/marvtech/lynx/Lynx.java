package marvtech.lynx;

import java.util.Objects;

import org.bukkit.plugin.java.JavaPlugin;

import marvtech.lynx.commands.AdminCommand;
import marvtech.lynx.commands.CountryCommand;
import marvtech.lynx.commands.FactionCommand;
import marvtech.lynx.commands.LynxCommand;
import marvtech.lynx.country.service.CountryService;
import marvtech.lynx.faction.service.FactionService;
import marvtech.lynx.economy.EconomyService;

/**
 * Minimal plugin bootstrap to expose services.
 */
public class Lynx extends JavaPlugin {
    private static Lynx instance;
    private CountryService countryService;
    private FactionService factionService;
    private EconomyService economyService;

    public Lynx() {
        instance = this;
        countryService = new CountryService();
        factionService = new FactionService();
        economyService = new EconomyService();
    }

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("country"))
            .setExecutor(new CountryCommand(countryService));
        Objects.requireNonNull(getCommand("faction"))
            .setExecutor(new FactionCommand(factionService));
        Objects.requireNonNull(getCommand("lynx"))
            .setExecutor(new LynxCommand());
        Objects.requireNonNull(getCommand("admin"))
            .setExecutor(new AdminCommand(economyService));
    }

    public static Lynx getInstance() {
        return instance;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    public FactionService getFactionService() {
        return factionService;
    }

    public EconomyService getEconomyService() {
        return economyService;
    }

}
