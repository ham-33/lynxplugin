package marvtech.lynx.commands;

import marvtech.lynx.country.model.Country;
import marvtech.lynx.country.service.CountryService;

/**
 * Very small command handler used for unit tests or demonstration.
 * Methods return strings to emulate command feedback.
 */
public class CountryCommand {
    private final CountryService service;

    public CountryCommand(CountryService service) {
        this.service = service;
    }

    /**
     * Execute a country command.
     * @param sender command sender name
     * @param args command arguments
     * @return result message
     */
    public String handle(String sender, String[] args) {
        if (args.length == 0) {
            return "Usage: /country <create|disband|invite|join|leave|info|list>";
        }
        switch (args[0].toLowerCase()) {
            case "create":
                if (args.length < 2) return "Specify a country name";
                Country created = service.createCountry(args[1], sender);
                return "Country "+created.getName()+" created";
            case "disband":
                if (args.length < 2) return "Specify a country name";
                service.disbandCountry(args[1]);
                return "Country "+args[1]+" disbanded";
            case "invite":
                if (args.length < 3) return "Usage: /country invite <name> <player>";
                service.invite(args[1], args[2]);
                return "Invited "+args[2];
            case "join":
                if (args.length < 3) return "Usage: /country join <name> <player>";
                boolean ok = service.join(args[1], args[2]);
                return ok ? "Joined" : "No invite";
            case "leave":
                if (args.length < 3) return "Usage: /country leave <name> <player>";
                service.leave(args[1], args[2]);
                return "Left";
            case "kick":
                if (args.length < 3) return "Usage: /country kick <name> <player>";
                service.kick(args[1], args[2]);
                return "Kicked";
            case "transfer":
                if (args.length < 3) return "Usage: /country transfer <name> <player>";
                service.transfer(args[1], args[2]);
                return "Transferred";
            case "setcolor":
                if (args.length < 3) return "Usage: /country setcolor <name> <#RRGGBB>";
                service.setColor(args[1], args[2]);
                return "Color set";
            case "setcapital":
                if (args.length < 4) return "Usage: /country setcapital <name> <x> <z>";
                int x = Integer.parseInt(args[2]);
                int z = Integer.parseInt(args[3]);
                service.setCapital(args[1], x, z);
                return "Capital set";
            case "info":
                if (args.length < 2) return "Specify a country name";
                Country c = service.getCountry(args[1]);
                if (c == null) return "Country not found";
                return c.getName()+" members: "+c.getMembers();
            case "list":
                return "Countries: "+service.getCountries();
            default:
                return "Unknown subcommand";
        }
    }
}
