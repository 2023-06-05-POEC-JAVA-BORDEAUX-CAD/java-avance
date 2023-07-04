package fr.maboite.correction.pojojsonservlet.dao;

import java.util.HashMap;
import java.util.Map;

import fr.maboite.correction.pojojsonservlet.pojo.Pojo;
import jakarta.ejb.Stateless;

/**
 * Data Access Object: classe permettant 
 * d'accéder en lecture ou écriture au référentiel 
 * de données des Pojos (ici, une simple Map)
 */
@Stateless
public class PojoDao implements PojoDaoInterface {
	
	private Map<Integer, Pojo> pojos = new HashMap<>();
	
	public PojoDao() {
		Pojo pojo1 = new Pojo();
		pojo1.setId(1);
		pojo1.setName("Hey!");
		pojo1.setValid(Boolean.TRUE);
		this.pojos.put(pojo1.getId(), pojo1);
		
		Pojo pojo2 = new Pojo();
		pojo2.setId(2);
		pojo2.setName("Hé bien!");
		pojo1.setValid(Boolean.FALSE);
		this.pojos.put(pojo2.getId(), pojo2);

		Pojo pojo3 = new Pojo();
		pojo3.setId(3);
		pojo3.setName("Voilà un POJO");
		pojo1.setValid(Boolean.TRUE);
		this.pojos.put(pojo3.getId(), pojo3);
	}

	@Override
	public Pojo getPojo(Integer id) {
		return this.pojos.get(id);
	}
	
}