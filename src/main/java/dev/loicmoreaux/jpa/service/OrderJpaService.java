package dev.loicmoreaux.jpa.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.loicmoreaux.jpa.dao.OrderJpaDAO;
import dev.loicmoreaux.jpa.model.OrderJpa;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderJpaService {
	
	@Inject
	private OrderJpaDAO orderDAO;
	
	/**
	 * Create or update order into database
	 * @param order
	 * @return OrderJpa
	 */
	public OrderJpa save(OrderJpa order) {
		System.out.println("Save Order into Database");
		return orderDAO.save(order);
	}
	
	
	/**
	 * Get an order by id into database
	 * @param id
	 * @return OrderJpa
	 */
	public OrderJpa getOrderById(Integer id) {
		System.out.println("Search order by id = " + id + " into Database");
		return orderDAO.getOrderById(id);
	}
	
	/**
	 * Get all orders into database
	 * @return List<OrderJpa>
	 */
	public List<OrderJpa> getOrders(){
		return orderDAO.getOrders();
	}
		
	/**
	 * Delete order into the database
	 * @param id
	 */
	public void delete(Integer id) {
		System.out.println("Delete order by id = " + id);
		orderDAO.delete(id);
	}
}
