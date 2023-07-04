package fr.tpdate.service;

import java.time.DayOfWeek;
import java.time.LocalDate;

import fr.tpdate.entity.DateEntity;
import fr.tpdate.entitydao.DateDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class DateService {

	@Inject
	private DateDAO dateDAO;
	
	
	public String isThisDateIsInWeekend(String day, String month, String year) {
		DateEntity date = dateDAO.setDate(day, month, year);
		String sentence = new String();
		
		
		if(LocalDate.of(date.getYear(),date.getMonth(), date.getDay()).getDayOfWeek() == DayOfWeek.SATURDAY
				|| LocalDate.of(date.getYear(),date.getMonth(), date.getDay()).getDayOfWeek() == DayOfWeek.SUNDAY) {
			sentence = "c'est le week-end !";
		} else {
			sentence = "c'est jour travaillé !";
		}
		
		return sentence;
	}
	
}
