package fr.noellie.jsf.controller;

import fr.noellie.jpa.dao.OrderJPADao;
import fr.noellie.jpa.model.EtatCommande;
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
		orderJPA.setTypePresta("Test Enum");
		orderJPA.setDesignation("Test Enum");
		orderJPA.setClientId(3);
		orderJPA.setState(EtatCommande.CANCELLED);
		OrderJPA savedOrder = orderJPADao.save(orderJPA);

		OrderJPA loadedOrder = orderJPADao.load(savedOrder.getId());
		System.out.println("En base, j'ai un order dont l'id est " + loadedOrder.getId() + " et la désignation : "
				+ loadedOrder.getDesignation() + " et dont le statut est " + loadedOrder.getState().toString());
	}

}