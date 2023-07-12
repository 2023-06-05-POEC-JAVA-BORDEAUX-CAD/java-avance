package dev.loicmoreaux.jpa.dao;

import java.util.List;

import dev.loicmoreaux.jpa.model.OrderJpa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

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
	 * Get all orders into database
	 * @return List<OrderJpa>
	 */
	public List<OrderJpa> getOrders(){
		Query jpqlQuery = this.entityManager.createQuery("select o from OrderJpa o", OrderJpa.class);
		return jpqlQuery.getResultList();
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
