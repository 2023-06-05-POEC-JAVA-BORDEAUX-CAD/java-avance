package fr.boite.philippe;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderJpaDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public void save(OrderJpa orderJpa) {
		this.entityManager.merge(orderJpa);
	}

}
