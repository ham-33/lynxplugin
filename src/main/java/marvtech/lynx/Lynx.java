package marvtech.lynx;

import marvtech.lynx.country.service.CountryService;
import marvtech.lynx.faction.service.FactionService;
import marvtech.lynx.economy.EconomyService;

/**
 * Minimal plugin bootstrap to expose services.
 */
public class Lynx {
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
