package fr.TpSolo;
import java.time.LocalDate;
import java.time.DayOfWeek;


public class SoloService {
	public String getStatutJourFerie(int jour, int mois, int annee) {
        LocalDate date = LocalDate.of(annee, mois, jour);

        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return "c'est le week-end !";
        } else {
            return "c'est jour de travail";
        }
    }
}
