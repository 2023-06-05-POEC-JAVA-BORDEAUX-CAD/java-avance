package fr.maboite.correction.jsf.controller;

import java.time.LocalDateTime;

import fr.maboite.correction.jpa.dao.PojoJpaDao;
import fr.maboite.correction.jpa.model.PojoJpa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MonPremierFaceBean {
	
	@Inject
	private PojoJpaDao pojoJpaDao;

	private String message = "Ce message vient du contrôleur";

	public String getMessage() {
		return LocalDateTime.now().toString();
	}
	
	public String getCoucou() {
		return "Salut ! ";
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void sauvegarde() {
		PojoJpa pojoJpa = new PojoJpa();
		pojoJpa.setNom("Salut");
		pojoJpa.setAdresse("4 rue barbe");
		pojoJpaDao.save(pojoJpa);
	}

}
