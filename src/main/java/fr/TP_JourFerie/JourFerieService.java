package fr.TP_JourFerie;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jakarta.ejb.Stateless;

@Stateless
public class JourFerieService {
	
    public boolean estJourFerie(LocalDate date) {
    	return false;
    }
    
    
    
    private JourFerieService jourFerieService;

    @Before
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







    