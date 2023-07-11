package fr.maboite.fabien.tpjsf;

import fr.maboite.fabien.tpjsf.jpamodel.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderDao {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * 
	 * @param order
	 * @return
	 */
	public Order save(Order order) {
		return this.entityManager.merge(order);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Order load(Long id) {
		return this.entityManager.find(Order.class, id);
	}
}
