package fr.group2.webserver;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class CatService {
	
	@Inject
	private CatDAO catDAO;
	
	
	public Cat getCat(Integer id) {
		return catDAO.getCat(id);
	}
	
	
}
