package fr.maboite.testjee;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class PojoDaoService {

	@Inject
	private PojoDao pojoDao;

    public PojoDaoService(PojoDao pojoDao) {
        this.pojoDao = pojoDao;
    }

    public Pojo getPojo(int id) {
        return pojoDao.get(id);
    }
}
