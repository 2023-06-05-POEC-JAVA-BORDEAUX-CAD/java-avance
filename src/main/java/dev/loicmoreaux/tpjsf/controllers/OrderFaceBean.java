package dev.loicmoreaux.tpjsf.controllers;

import dev.loicmoreaux.jpa.model.Order;
import dev.loicmoreaux.jpa.service.OrderService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrderFaceBean {
	private Order order = new Order();
	
	@Inject
	private OrderService orderService;
	
	/*
	 * Constructor
	 */	
	public OrderFaceBean() {}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	};
	
	public void save() {
		orderService.save(order);
		System.out.println("sauvegarde de order dans la BDD");
	}
}
