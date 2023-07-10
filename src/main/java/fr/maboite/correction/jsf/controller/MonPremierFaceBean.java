package fr.maboite.correction.jsf.controller;

import java.time.LocalDateTime;

import fr.maboite.correction.jpa.dao.OrderJpaDao;
import fr.maboite.correction.jpa.dao.PojoJpaDao;
import fr.maboite.correction.jpa.model.Order;
import fr.maboite.correction.jpa.model.PojoJpa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MonPremierFaceBean {
	
	@Inject
	private PojoJpaDao pojoJpaDao;
	
	@Inject
	private OrderJpaDao orderJpaDao;

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
	
	public void sauvegardePojo() {
		PojoJpa pojoJpa = new PojoJpa();
		pojoJpa.setNom("Salut");
		pojoJpa.setAdresse(message);
		pojoJpaDao.save(pojoJpa);
	}
	
	public void sauvegardeOrder() {
		Order order = new Order();
		order.setClientId(1l);
		order.setDesignation("commande Web");
		order.setTypePresta("Bien");
		orderJpaDao.save(order);
		
		
		Order order2 = orderJpaDao.load(1l);
		System.out.println(order2);
	}

}
