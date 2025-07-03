package marvtech.lynx;

import marvtech.lynx.commands.AdminCommand;
import marvtech.lynx.commands.BankCommand;
import marvtech.lynx.commands.CountryCommand;
import marvtech.lynx.commands.FactionCommand;
import marvtech.lynx.commands.LynxCommand;
import marvtech.lynx.country.repository.CountryRepository;
import marvtech.lynx.country.service.CountryService;
import marvtech.lynx.faction.repository.FactionRepository;
import marvtech.lynx.faction.service.FactionService;
import marvtech.lynx.listeners.ChunkClaimListener;
import marvtech.lynx.listeners.PlayerJoinListener;
import marvtech.lynx.listeners.VaultBalanceListener;
import marvtech.lynx.util.DatabaseProvider;
import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin class.
 */
public class Lynx extends JavaPlugin {
    private HikariDataSource dataSource;
    private CountryService countryService;
    private FactionService factionService;

    @Override
    public void onEnable() {
        // Initialize persistence
        dataSource = DatabaseProvider.createSQLiteDataSource(getDataFolder());
        CountryRepository countryRepository = new CountryRepository(dataSource);
        FactionRepository factionRepository = new FactionRepository(dataSource);
        try {
            countryRepository.init();
            factionRepository.init();
        } catch (Exception e) {
            getLogger().severe("Failed to initialise database: " + e.getMessage());
        }

        // Create services
        countryService = new CountryService(countryRepository);
        factionService = new FactionService(factionRepository);

        // Register command executors
        getCommand("lynx").setExecutor(new LynxCommand());
        getCommand("admin").setExecutor(new AdminCommand());
        getCommand("country").setExecutor(new CountryCommand());
        getCommand("bank").setExecutor(new BankCommand());
        getCommand("faction").setExecutor(new FactionCommand());

        // Register event listeners
        getServer().getPluginManager().registerEvents(new ChunkClaimListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new VaultBalanceListener(), this);

        getLogger().info("Lynx enabled");
    }

    @Override
    public void onDisable() {
        if (dataSource != null) {
            dataSource.close();
        }
        getLogger().info("Lynx disabled");
    }
}
