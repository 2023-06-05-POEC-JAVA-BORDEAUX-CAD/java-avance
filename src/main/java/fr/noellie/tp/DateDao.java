package fr.noellie.tp;

import java.util.HashMap;
import java.util.Map;

import jakarta.ejb.Stateless;

@Stateless
public class DateDao {
	private Map<Integer, Date> dateMap;

	public DateDao() {
		dateMap = new HashMap<>();
		dateMap.put(1, new Date(15, 1, 2024));
		dateMap.put(2, new Date(2, 6, 2021));
		dateMap.put(3, new Date(23, 8, 2020));
		dateMap.put(4, new Date(10, 10, 1996));
		dateMap.put(5, new Date(8, 3, 2023));
	}

	public Date getDate(Integer id) {
		return dateMap.get(id);
	}
}