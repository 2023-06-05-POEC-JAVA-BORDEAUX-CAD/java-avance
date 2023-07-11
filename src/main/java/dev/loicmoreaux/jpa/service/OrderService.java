package dev.loicmoreaux.jpa.service;

import dev.loicmoreaux.jpa.dao.OrderDAO;
import dev.loicmoreaux.jpa.model.Order;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {
	
	@Inject
	private OrderDAO orderDAO;
	
	/**
	 * Method for save order into the database
	 * @param order
	 * @return
	 */
	public Order save(Order order) {
		System.out.println("Save into Database");
		return orderDAO.save(order);
	}
	
	
	/**
	 * Method for search into the database an order by id
	 * @param id
	 * @return
	 */
	public Order load(Integer id) {
		System.out.println("Search order by id = " + id + " into Database");
		return orderDAO.load(id);
	}
	
	
	/**
	 * Method for delete
	 * @param id
	 */
	public void delete(Integer id) {
		System.out.println("Delete order by id = " + id);
		orderDAO.delete(id);
	}
}
