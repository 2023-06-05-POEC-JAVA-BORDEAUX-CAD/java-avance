package fr.maboite.correction.pojojsonservlet.service;

import fr.maboite.correction.pojojsonservlet.dao.PojoDao;
import fr.maboite.correction.pojojsonservlet.pojo.Pojo2;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class PojoService {

	private static final String NOM_INTERDIT = "dangereux";

	@Inject
	private PojoDao pojoDao;

	public void setPojoDao(PojoDao pojoDao) {
		this.pojoDao = pojoDao;
	}

	public void save(Pojo2 pojo) {
		// ... ne fait rien
	}

	public Pojo2 get(Integer id) {
		
		Pojo2 pojo = pojoDao.getPojo(id);
		if (pojo == null) {
			return null;
		}
		if (pojo.getName() != null
				&& pojo.getName().equals(NOM_INTERDIT)) {
			//équivaut à	if(Objects.equals(pojo.getName(), NOM_INTERDIT)) {
			throw new IllegalArgumentException("Un pojo dangereux a été chargé, ce qui est interdit");
		}
		return pojo;
	}

}
