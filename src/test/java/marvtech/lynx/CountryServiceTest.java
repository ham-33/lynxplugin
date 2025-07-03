package marvtech.lynx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import marvtech.lynx.country.model.Country;
import marvtech.lynx.country.service.CountryService;

public class CountryServiceTest {
    @Test
    void createAndRetrieveCountry() {
        CountryService service = new CountryService();
        Country c = service.createCountry("Japan", "Alice");
        assertEquals("Japan", c.getName());
        assertEquals(c, service.getCountry("japan"));
        assertTrue(c.getMembers().contains("Alice"));
    }
}
