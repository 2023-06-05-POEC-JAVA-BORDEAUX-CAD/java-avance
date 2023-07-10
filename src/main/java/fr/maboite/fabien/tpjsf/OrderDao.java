package fr.maboite.fabien.tpjsf;

import fr.maboite.fabien.tpjsf.jpamodel.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderDao {
	
	@PersistenceContext
	protected EntityManager entityManager;

	public void save(Order orders) {
		this.entityManager.merge(orders);
	}
}
