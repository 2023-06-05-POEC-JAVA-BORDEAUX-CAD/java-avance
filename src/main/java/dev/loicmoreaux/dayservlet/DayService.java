package dev.loicmoreaux.dayservlet;

import java.time.DayOfWeek;
import java.time.LocalDate;

import jakarta.ejb.Stateless;

@Stateless
public class DayService {
	
	public String getDayOfWeek(int day, int month, int year){
		LocalDate date  = LocalDate.of(year, month, day);
		
		if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return "C'est le weekend ! :)";
		}
		else return "C'est un jour travaillé :(";
	}
}
