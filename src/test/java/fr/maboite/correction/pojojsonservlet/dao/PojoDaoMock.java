package fr.maboite.correction.pojojsonservlet.dao;

import fr.maboite.correction.pojojsonservlet.pojo.Pojo;
import jakarta.ejb.Stateless;

/**
 * Mock du Pojo Dao
 */
public class PojoDaoMock implements PojoDaoInterface {

	@Override
	public Pojo getPojo(Integer id) {
		return new Pojo();
	}
	
}