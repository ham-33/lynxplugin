package marvtech.lynx.commands;

import marvtech.lynx.economy.EconomyService;

/**
 * Simple bank subcommand handler.
 */
public class BankCommand {
    private final EconomyService economy;

    public BankCommand(EconomyService economy) {
        this.economy = economy;
    }

    public String handle(String[] args) {
        if (args.length == 0) {
            return "Usage: /country bank <info|deposit|withdraw>";
        }
        switch (args[0].toLowerCase()) {
            case "info":
                if (args.length < 2) return "Specify country";
                return "Balance: "+economy.getBalance(args[1]);
            case "deposit":
                if (args.length < 3) return "Specify country and amount";
                double amtD = Double.parseDouble(args[2]);
                economy.deposit(args[1], amtD);
                return "Deposited";
            case "withdraw":
                if (args.length < 3) return "Specify country and amount";
                double amtW = Double.parseDouble(args[2]);
                if (economy.withdraw(args[1], amtW)) return "Withdrawn";
                return "Insufficient";
            default:
                return "Unknown subcommand";
        }
    }
}
