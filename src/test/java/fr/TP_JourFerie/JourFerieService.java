package fr.TP_JourFerie;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import jakarta.ejb.Stateless;
import junit.framework.Assert;

@Stateless
public class JourFerieService {
    public boolean estJourFerie(LocalDate date) {
        return false;
    }
    
    private JourFerieService jourFerieService;

    @BeforeAll
    public void setUp() {
        jourFerieService = new JourFerieService();
    }

    @Test
    public void testEstJourFerie() {
        LocalDate date = LocalDate.of(2023, 12, 25);
        boolean estJourFerie = jourFerieService.estJourFerie(date);
        Assert.assertTrue(estJourFerie);
    }
 
}