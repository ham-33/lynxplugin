package marvtech.lynx.commands;


import marvtech.lynx.economy.EconomyService;

/**
 * Minimal admin command for demonstration.
 */

public class AdminCommand {
    private final EconomyService economy;

    public AdminCommand(EconomyService economy) {
        this.economy = economy;
    }

    public String handle(String[] args) {
        if (args.length == 0) {
            return "Usage: /admin <validate|bank>";
        }
        switch (args[0].toLowerCase()) {
            case "validate":
                return "Validated";
            case "bank":
                return handleBank(args);
            default:
                return "Unknown subcommand";
        }
    }

    private String handleBank(String[] args) {
        if (args.length < 4) return "Usage: /admin bank <set|add|remove> <country> <amount>";
        String sub = args[1].toLowerCase();
        String country = args[2];
        double amt = Double.parseDouble(args[3]);
        switch (sub) {
            case "set":
                economy.set(country, amt);
                return "Set";
            case "add":
                economy.deposit(country, amt);
                return "Added";
            case "remove":
                if (economy.withdraw(country, amt)) return "Removed";
                return "Insufficient";
            default:
                return "Unknown bank command";
        }
    }
}
