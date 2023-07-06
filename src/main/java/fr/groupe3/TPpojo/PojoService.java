package fr.groupe3.TPpojo;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class PojoService {

//	@Inject
	private PojoDao pojoDao;

	public Pojo getPojo(Integer id) {
		return pojoDao.getPojo(id);
	}

}