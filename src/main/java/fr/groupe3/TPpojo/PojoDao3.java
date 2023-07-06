package fr.groupe3.TPpojo;

import java.util.Map;

import jakarta.ejb.Stateless;

import java.util.HashMap;

@Stateless
public class PojoDao3 {

	private Map<Integer, Pojo> pojoMap;

	public PojoDao3() {
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