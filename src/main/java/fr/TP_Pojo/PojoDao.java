package fr.TP_Pojo;

import java.util.Map;
import jakarta.ejb.Stateless;
import java.util.HashMap;





@Stateless
public class PojoDao {

	// Attributs

	private Map<Integer, Pojo> pojoMap;

	public PojoDao() {

		// Initialisation de la map avec des exemples de POJOs

		pojoMap = new HashMap<>();
		pojoMap.put(1, new Pojo(1, "Objet 1"));
		pojoMap.put(2, new Pojo(2, "Objet 2"));
		pojoMap.put(3, new Pojo(3, "Objet 3"));
	}

	public Pojo getPojo(Integer id) { // la fonction return une variable de type Pojo
		return pojoMap.get(id); // la  methode get est une methode de la class HashMap et pojoMap est un objet
	}
}
