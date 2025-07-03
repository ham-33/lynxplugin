package marvtech.lynx.commands;

import marvtech.lynx.faction.model.Faction;
import marvtech.lynx.faction.service.FactionService;

/**
 * Simple faction command handler.
 */
public class FactionCommand {
    private final FactionService service;

    public FactionCommand(FactionService service) {
        this.service = service;
    }

    public String handle(String[] args) {
        if (args.length == 0) {
            return "Usage: /faction <create|delete|join|leave|list>";
        }
        switch (args[0].toLowerCase()) {
            case "create":
                if (args.length < 2) return "Specify a faction name";
                Faction f = service.createFaction(args[1]);
                return "Faction "+f.getName()+" created";
            case "delete":
                if (args.length < 2) return "Specify a faction name";
                service.deleteFaction(args[1]);
                return "Faction "+args[1]+" deleted";
            case "join":
                if (args.length < 3) return "Usage: /faction join <faction> <country>";
                service.addCountry(args[1], args[2]);
                return "Joined";
            case "leave":
                if (args.length < 3) return "Usage: /faction leave <faction> <country>";
                service.removeCountry(args[1], args[2]);
                return "Left";
            case "list":
                return "Factions: "+service.getFactions();
            default:
                return "Unknown subcommand";
        }
    }
=======
/** Command placeholder for faction. */
public class FactionCommand {

}
