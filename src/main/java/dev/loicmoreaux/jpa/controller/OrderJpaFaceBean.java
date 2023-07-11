package dev.loicmoreaux.jpa.controller;

import dev.loicmoreaux.jpa.model.OrderJpa;
import dev.loicmoreaux.jpa.service.OrderJpaService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrderJpaFaceBean {
	private OrderJpa order = new OrderJpa();
	
	@Inject
	private OrderJpaService orderService;
	
	/*
	 * Constructor
	 */	
	public OrderJpaFaceBean() {}

	public OrderJpa getOrder() {
		return order;
	}

	public void setOrder(OrderJpa order) {
		this.order = order;
	};
	
	public void save() {
		orderService.save(order);
		System.out.println("sauvegarde de order dans la BDD");
	}
	
	public void load() {
		String order = orderService.load(1).toString();
		System.out.println(order);		
	}
}
