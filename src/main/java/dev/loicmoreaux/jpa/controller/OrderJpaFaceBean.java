package dev.loicmoreaux.jpa.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.loicmoreaux.jpa.model.ClientJpa;
import dev.loicmoreaux.jpa.model.OrderJpa;
import dev.loicmoreaux.jpa.service.ClientJpaService;
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
	
	@Inject
	private ClientJpaService clientService;
	
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
		ClientJpa clientOne = clientService.getClientById(1);
		order.setClient(clientOne);
		orderService.save(order);
		System.out.println("sauvegarde de order dans la BDD");
	}
	
	public String getOrders(){
		String ul = "";
		List<OrderJpa> orders = orderService.getOrders();
		for(OrderJpa order : orders) {
			ul += "<tr>";
			ul += "<td>" + order.getId() + "</td>";
			ul += "<td>" + order.getTypePresta() + "</td>";
			ul += "<td>" + order.getDesignation() + "</td>";
			ul += "<td>" + order.getNbDays() + "</td>";
			ul += "<td>" + order.getUnitPrice() + "€</td>";
			ul += "<td>" + order.getState() + "</td>";
			ul += "<td>" + order.getClient().getCompanyName() + "</td>";
			ul += "</tr>";
		}
		return ul;
	}
}
