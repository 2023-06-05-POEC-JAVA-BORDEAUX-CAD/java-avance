package fr.TP_Pojo;

import java.util.Map;

import jakarta.ejb.Singleton;
import jakarta.ejb.Stateless;

import java.util.HashMap;

@Singleton
public class PojoDao {

	private Map<Integer, Pojo> pojoMap;

	public PojoDao() {
		pojoMap = new HashMap<>();
		pojoMap.put(1, new Pojo(1, "Pojo 1"));
		pojoMap.put(2, new Pojo(2, "Pojo 2"));
		pojoMap.put(3, new Pojo(3, "Pojo 3"));
		pojoMap.put(4, new Pojo(4, "Pojo 4"));
		pojoMap.put(5, new Pojo(5, "Pojo 5"));
	}

	public Pojo getPojo(Integer id) {
		return pojoMap.get(id);
	}
}