package fr.boite.philippe.jsf.controller;

import fr.boite.philippe.OrderJpa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrderController {

	@Inject 
	private OrderJpa orderJpa;
	
	private ClientFormBean message = new ClientFormBean();

	public ClientFormBean getMessage() {
		return message;
	}
	
		
	public void sauvegarde() {
		OrderJpa orderJpa = new OrderJpa();
		orderJpaDao.setType_presta("Formation1");
		orderJpaDao.setDesignation("rien");
		orderJpaDao.setClient_id(12);
		orderJpaDao.save(orderJpa);
	}
}
