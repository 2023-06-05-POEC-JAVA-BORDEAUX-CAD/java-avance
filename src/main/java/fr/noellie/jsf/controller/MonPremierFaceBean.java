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

	public void sauvegarde() {
		OrderJPA orderJPA = new OrderJPA();
		orderJPA.setTypePresta("Formation");
		orderJPA.setDesignation("Initiation Ruby");
		orderJPA.setClientId(4);
		orderJPADao.save(orderJPA);
	}

}