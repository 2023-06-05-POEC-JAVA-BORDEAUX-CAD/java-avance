package dev.loicmoreaux.jpa;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderDAO {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public void save(Order order) {
		this.entityManager.merge(order);
	}
}
