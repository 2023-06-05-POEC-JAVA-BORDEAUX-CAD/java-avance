package tpdate.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import jakarta.ejb.Stateless;

@Stateless
public class DateService {
	public boolean isWeek(Integer j, Integer m, Integer a) {
		DayOfWeek curDay = LocalDate.of(a, m, j).getDayOfWeek();
		return (curDay == DayOfWeek.SATURDAY || curDay == DayOfWeek.SUNDAY);
	}
}
