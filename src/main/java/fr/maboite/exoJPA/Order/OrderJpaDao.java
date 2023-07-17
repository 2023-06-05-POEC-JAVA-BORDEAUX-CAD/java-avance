package fr.maboite.exoJPA.Order;

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
	
	public void delete(Integer integer) {
		if (integer == null) {
			return;
		}
		OrderEntity savedEntity = this.entityManager.find(OrderEntity.class, integer);
		if (savedEntity == null) {
			return;
		}
		this.entityManager.remove(savedEntity);
	}

}
