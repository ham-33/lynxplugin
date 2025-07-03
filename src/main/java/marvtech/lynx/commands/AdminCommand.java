package marvtech.lynx.commands;

/**
 * Minimal admin command for demonstration.
 */
public class AdminCommand {
    public String handle(String[] args) {
        if (args.length == 0) {
            return "Usage: /admin <lynxlog|validate>";
        }
        switch (args[0].toLowerCase()) {
            case "validate":
                return "Validated";
            case "lynxlog":
                return "Logs";
            default:
                return "Unknown subcommand";
        }
    }
}
