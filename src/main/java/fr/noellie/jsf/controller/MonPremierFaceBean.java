package fr.noellie.jsf.controller;

import fr.noellie.jpa.dao.OrderJPADao;
import fr.noellie.jpa.model.OrderJPA;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class MonPremierFaceBean {

	@Inject
	private OrderJPADao orderJPADao;

	private String message = "Ce message vient du controller MonPremierFaceBean";

	public String getMessage() {
		return message;
	}

	public void sauvegardeOrderJPA() {
		OrderJPA orderJPA = new OrderJPA();
		orderJPA.setTypePresta("Coaching");
		orderJPA.setDesignation("Git & GitHub");
		orderJPA.setClientId(4);
		OrderJPA savedOrder = orderJPADao.save(orderJPA);
		
		OrderJPA loadedOrder = orderJPADao.load(savedOrder.getId());
		System.out.println("En base, j'ai un order dont la désignation vaut : " 
				+ loadedOrder.getDesignation()
				+ " pour l'id " + loadedOrder.getId());
	}

}