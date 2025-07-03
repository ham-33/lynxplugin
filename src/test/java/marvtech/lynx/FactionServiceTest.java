package marvtech.lynx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import marvtech.lynx.faction.model.Faction;
import marvtech.lynx.faction.service.FactionService;

public class FactionServiceTest {
    @Test
    void createAndManageFaction() {
        FactionService service = new FactionService();
        Faction f = service.createFaction("Allies");
        service.addCountry("Allies", "Japan");
        assertTrue(f.getCountries().contains("Japan"));
        service.removeCountry("Allies", "Japan");
        assertFalse(f.getCountries().contains("Japan"));
        service.deleteFaction("Allies");
        assertNull(service.getFaction("Allies"));
    }
}
