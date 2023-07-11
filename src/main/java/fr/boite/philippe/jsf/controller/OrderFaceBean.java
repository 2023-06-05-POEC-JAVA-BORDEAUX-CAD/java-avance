package fr.boite.philippe.jsf.controller;

import fr.boite.philippe.OrderJpa;
import fr.boite.philippe.OrderJpaDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrderFaceBean {

	@Inject
	private OrderJpaDao orderJpaDao;

	@Inject
	private OrderJpaService orderJpaService;

	public void saveOrderJpa() {
		OrderJpa orderJpa = new OrderJpa();
		orderJpa.setType_presta("Formation1");
		orderJpa.setDesignation("rien");
		orderJpa.setClient_id(1);
		orderJpaDao.save(orderJpa);
		OrderJpa savedOrderJpa = orderJpaService.save(orderJpa);
		
		OrderJpa loadedOrderJpa = orderJpaService.load(savedOrderJpa.getId());
		System.out.println("la désignation d'order : " 
			+ loadedOrderJpa.getDesignation() + " pour l'id : " 
			+ loadedOrderJpa.getId());
	}
}
