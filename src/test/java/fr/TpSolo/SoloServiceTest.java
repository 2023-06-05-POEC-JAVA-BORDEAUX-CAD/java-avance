package fr.TpSolo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoloServiceTest {
    private final SoloService soloService = new SoloService();

    @Test
    public void testJourFerieService() {
        // Samedi 01-07-2023
        assertEquals("C'est le week-end !", soloService.getStatutJourFerie(1, 7, 2023));
        // Mercredi 05-07-2023
        assertEquals("C'est un jour de la semaine.", soloService.getStatutJourFerie(5, 7, 2023));
    }
}

