package fr.boite.philippe;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderJpaDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public OrderJpa save(OrderJpa orderJpa) {
		return this.entityManager.merge(orderJpa);
	}
	
	public OrderJpa load(Integer id) {
		return this.entityManager.find(OrderJpa.class, id);
	}
}
