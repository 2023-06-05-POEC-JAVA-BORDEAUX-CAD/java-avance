package dev.loicmoreaux.jpa.dao;

import dev.loicmoreaux.jpa.model.OrderJpa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderJpaDAO {

	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	public OrderJpa save(OrderJpa order) {
		return this.entityManager.merge(order);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public OrderJpa getOrderById(Integer id) {
		return this.entityManager.find(OrderJpa.class, id);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		OrderJpa order = this.getOrderById(id);
		if(order != null) {
			this.entityManager.remove(order);
		} 			
	}
}
