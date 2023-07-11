package fr.maboite.exoJPA;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderJpaDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	

	public OrderEntity save(OrderEntity order) {
		return this.entityManager.merge(order);
	}

	public OrderEntity load(Integer integer) {
		return this.entityManager.find(OrderEntity.class, integer);
	}

}
