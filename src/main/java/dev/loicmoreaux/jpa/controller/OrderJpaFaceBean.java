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
		order.setClient(getClientOne());
		orderService.save(order);
		System.out.println("sauvegarde de order dans la BDD");
	}
	
	public String getOrders() throws JsonProcessingException {
		//String ul = "<ul>";
		String ul = "";
		List<OrderJpa> orders = orderService.getOrders();
		for(OrderJpa order : orders) {
			//ul += "<li>" + this.toString(order) + "</li>";
			ul += this.toString(order);
		}
		
		//return ul += "</ul>";
		return ul;
	}
	
	public String toString(OrderJpa order) throws JsonProcessingException{
		if(order == null) return null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(order);
	}
	
	public ClientJpa getClientOne() {
		return clientService.getClientById(1);
	}
}
