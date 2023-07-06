package fr.maboite.correction.pojojsonservlet.dao;

import java.util.HashMap;
import java.util.Map;

import fr.TP_Pojo.Pojo;
import fr.maboite.correction.pojojsonservlet.pojo.Pojo2;
import jakarta.ejb.Stateless;

/**
 * Data Access Object: classe permettant 
 * d'accéder en lecture ou écriture au référentiel 
 * de données des Pojos (ici, une simple Map)
 */
@Stateless
public class PojoDao {
	
	private Map<Integer, Pojo2> pojos = new HashMap<>();
	
	public void PojoDao2() {
		Pojo2 pojo1 = new Pojo2();
		pojo1.setId(1);
		pojo1.setName("Hey!");
		pojo1.setValid(Boolean.TRUE);
		this.pojos.put(pojo1.getId(), pojo1);
		
		Pojo2 pojo2 = new Pojo2();
		pojo2.setId(2);
		pojo2.setName("Hé bien!");
		pojo1.setValid(Boolean.FALSE);
		this.pojos.put(pojo2.getId(), pojo2);

		Pojo2 pojo3 = new Pojo2();
		pojo3.setId(3);
		pojo3.setName("Voilà un POJO");
		pojo1.setValid(Boolean.TRUE);
		this.pojos.put(pojo3.getId(), pojo3);
	}

	public Pojo getPojo(Integer id) {
		return this.pojos.get(id);
	}
	
}