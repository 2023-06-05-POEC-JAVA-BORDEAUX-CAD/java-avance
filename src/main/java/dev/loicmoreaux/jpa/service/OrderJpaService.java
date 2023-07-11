package dev.loicmoreaux.jpa.service;

import dev.loicmoreaux.jpa.dao.OrderJpaDAO;
import dev.loicmoreaux.jpa.model.OrderJpa;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderJpaService {
	
	@Inject
	private OrderJpaDAO orderDAO;
	
	/**
	 * Method for save order into the database
	 * @param order
	 * @return
	 */
	public OrderJpa save(OrderJpa order) {
		System.out.println("Save Order into Database");
		return orderDAO.save(order);
	}
	
	
	/**
	 * Method for search into the database an order by id
	 * @param id
	 * @return
	 */
	public OrderJpa load(Integer id) {
		System.out.println("Search order by id = " + id + " into Database");
		return orderDAO.load(id);
	}
	
	
	/**
	 * Method for delete an order
	 * @param id
	 */
	public void delete(Integer id) {
		System.out.println("Delete order by id = " + id);
		orderDAO.delete(id);
	}
}
