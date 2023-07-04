package fr.maboite.correction.pojojsonservlet.dao;

import fr.maboite.correction.pojojsonservlet.pojo.Pojo2;
import jakarta.ejb.Stateless;

/**
 * Mock du Pojo Dao
 */
@Stateless
public class PojoDaoMock implements PojoDaoInterface {

	@Override
	public Pojo2 getPojo(Integer id) {
		return new Pojo2();
	}
	
}