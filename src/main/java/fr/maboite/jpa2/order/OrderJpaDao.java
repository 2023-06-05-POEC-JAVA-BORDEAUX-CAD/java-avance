package fr.maboite.jpa2.order;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderJpaDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public Order save(Order order) {
		return this.entityManager.merge(order);
	}

	public Order load(Long id) {
		return this.entityManager.find(Order.class, id);

	}

	public void delete(Long id) {
		entityManager.remove(entityManager.find(Order.class, id));
	}

}