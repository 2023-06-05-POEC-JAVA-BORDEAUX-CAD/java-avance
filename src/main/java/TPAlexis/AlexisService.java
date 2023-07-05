package TPAlexis;

import java.time.DayOfWeek;
import java.time.LocalDate;

import jakarta.ejb.Stateless;


@Stateless
public class AlexisService {

	public boolean isWeekEnd(Integer j, Integer m, Integer a) {

		LocalDate bugun = LocalDate.of(a, m, j); // une nouvelle Localdate

		//sinon avec un || on peut mettre tout sur une seule ligne
		
		if (bugun.getDayOfWeek() == DayOfWeek.SATURDAY) {

			return true;

		} else if (bugun.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return true;

		} else {
			return false;
		} 
	

	}
}