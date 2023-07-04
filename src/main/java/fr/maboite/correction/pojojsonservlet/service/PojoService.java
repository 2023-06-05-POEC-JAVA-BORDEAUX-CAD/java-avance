package fr.maboite.correction.pojojsonservlet.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

import org.omg.Security.DayOfTheWeek;

import fr.maboite.correction.pojojsonservlet.dao.PojoDaoInterface;
import fr.maboite.correction.pojojsonservlet.pojo.Pojo;
import jakarta.ejb.Stateless;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Qualifier;

@Stateless
public class PojoService {

	private static final String NOM_INTERDIT = "dangereux";

	@Inject
	private PojoDaoInterface pojoDaoInterfaceImplementation;

	public void setPojoDao(PojoDaoInterface pojoDao) {
		this.pojoDaoInterfaceImplementation = pojoDao;
	}

	public void save(Pojo pojo) {
		// ... ne fait rien
	}

	public Pojo get(Integer id) {
		
		Pojo pojo = pojoDaoInterfaceImplementation.getPojo(id);
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
