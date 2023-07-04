package fr.tpdate.entitydao;

import fr.tpdate.entity.DateEntity;
import jakarta.ejb.Stateless;


@Stateless
public class DateDAO {
	
	public DateEntity setDate(String day, String month, String year) {
		return new DateEntity(Integer.valueOf(day), Integer.valueOf(month), Integer.valueOf(year));
	}
}
