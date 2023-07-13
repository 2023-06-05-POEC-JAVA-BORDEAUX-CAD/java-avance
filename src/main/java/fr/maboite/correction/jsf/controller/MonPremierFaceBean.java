package fr.maboite.correction.jsf.controller;

import java.time.LocalDateTime;

import fr.maboite.correction.jpa.dao.PojoJpaDao;
import fr.maboite.correction.jpa.model.Order;
import fr.maboite.correction.jpa.model.PojoJpa;
import fr.maboite.correction.jpa.service.JpaOrderService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MonPremierFaceBean {
	
	@Inject
	private PojoJpaDao pojoJpaDao;
	
	@Inject
	private JpaOrderService orderService;

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
		Order savedOrder = orderService.save(order);
		
		Order loadedOrder = orderService.load(savedOrder.getId());
		System.out.println("En base, j'ai un order dont la désignation vaut : " 
				+ loadedOrder.getDesignation() + " pour l'id : " + loadedOrder.getId());
	}

}
