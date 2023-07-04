package fr.noellie.tp;

import java.time.DayOfWeek;
import java.time.LocalDate;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class DateService {

	@Inject
	private DateDao dateDao;

	public Date getDate(Integer id) {
//		return dateDao.getDate(id);
		
		Date date = dateDao.getDate(id);
		if (date == null) {
			return null;
		}
		if (date.getJour() != null && date.getMois() != null && date.getAnnee() != null) {
			
		}
		return date;
	}
	
	public static boolean jourEnSemaine(Integer jour, Integer mois, Integer annee) {
	    LocalDate date = LocalDate.of(annee, mois, jour);
	    DayOfWeek jourSemaine = date.getDayOfWeek(); 
	    
	    if (jourSemaine == DayOfWeek.SATURDAY || jourSemaine == DayOfWeek.SUNDAY) {
	        return false;
	    }

	    return true;
	}
}
