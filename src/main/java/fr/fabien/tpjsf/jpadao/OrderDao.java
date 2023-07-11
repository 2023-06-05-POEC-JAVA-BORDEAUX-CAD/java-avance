package fr.fabien.tpjsf.jpadao;

import fr.fabien.tpjsf.jpamodel.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public Order find (Long id) {
		return this.entityManager.find(Order.class, id);
	}

	/**
	 * 
	 * @param order
	 * @return
	 */
	public Order save(Order order) { // charge cette entité en BDD
		return this.entityManager.merge(order);
	}

	/**
	 * 
	 * @param orderToDelete
	 */
	public void delete(Order orderToDelete) {
		if (orderToDelete!=null) {
			return;
		}
		Order savedEntity = this.entityManager.find(Order.class, orderToDelete);
		if (savedEntity == null) {
			return;
		}
		this.entityManager.remove(savedEntity);
	}
	
}
