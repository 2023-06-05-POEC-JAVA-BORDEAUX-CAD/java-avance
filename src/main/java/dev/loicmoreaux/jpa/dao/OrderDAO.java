package dev.loicmoreaux.jpa.dao;

import dev.loicmoreaux.jpa.model.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderDAO {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public Order save(Order order) {
		return this.entityManager.merge(order);
	}
	
	public Order load(Integer id) {
		return this.entityManager.find(Order.class, id);
	}
}
