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
            return "Usage: /country <create|disband|info|list>";
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
