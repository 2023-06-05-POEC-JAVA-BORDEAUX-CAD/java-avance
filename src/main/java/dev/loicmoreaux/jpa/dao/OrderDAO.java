package dev.loicmoreaux.jpa.dao;

import dev.loicmoreaux.jpa.model.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderDAO {

	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	public Order save(Order order) {
		return this.entityManager.merge(order);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Order load(Integer id) {
		return this.entityManager.find(Order.class, id);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		Order order = this.load(id);
		if(order != null) {
			this.entityManager.remove(order);
		} 			
	}
}
