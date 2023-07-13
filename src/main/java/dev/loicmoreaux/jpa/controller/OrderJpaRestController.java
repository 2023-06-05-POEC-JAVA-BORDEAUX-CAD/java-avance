package dev.loicmoreaux.jpa.controller;

import java.util.List;

import dev.loicmoreaux.jpa.model.OrderJpa;
import dev.loicmoreaux.jpa.service.OrderJpaService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderJpaRestController {
	
	@Inject
	OrderJpaService orderService;
	
	@GET
	@Path("/test")
	public String getTest() {
		return "Test orders ok";
	}
	
	@GET
	@Path("/{id}")
	public OrderJpa getOrderById(@PathParam("id") Integer id) {
		 return orderService.getOrderById(id);
	}
	
	@GET
	public List<OrderJpa> getOrders() {
		 return orderService.getOrders();
	}	
}
