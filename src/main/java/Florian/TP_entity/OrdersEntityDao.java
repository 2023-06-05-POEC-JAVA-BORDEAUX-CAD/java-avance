package Florian.TP_entity;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrdersEntityDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public void save(OrderEntity order) {
		this.entityManager.merge(order);
	}
}
