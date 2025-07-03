package marvtech.lynx.commands;

/**
 * Basic lynx utility command handler.
 */
public class LynxCommand {
    public String handle(String[] args) {
        if (args.length == 0) {
            return "Usage: /lynx <reload|version>";
        }
        switch (args[0].toLowerCase()) {
            case "version":
                return "Lynx version 0";
            case "reload":
                return "Reloaded";
            default:
                return "Unknown subcommand";
        }
    }
}
