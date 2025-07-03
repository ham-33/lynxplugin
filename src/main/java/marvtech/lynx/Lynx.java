package marvtech.lynx;

import marvtech.lynx.commands.AdminCommand;
import marvtech.lynx.commands.BankCommand;
import marvtech.lynx.commands.CountryCommand;
import marvtech.lynx.commands.FactionCommand;
import marvtech.lynx.commands.LynxCommand;
import marvtech.lynx.listeners.ChunkClaimListener;
import marvtech.lynx.listeners.PlayerJoinListener;
import marvtech.lynx.listeners.VaultBalanceListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin class.
 */
public class Lynx extends JavaPlugin {

    @Override
    public void onEnable() {
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
        getLogger().info("Lynx disabled");
    }
}
