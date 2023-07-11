package tp.jpa;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderDao {
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Load a OrderModel by this identifier
	 * 
	 * @param id the OrderModel identifier
	 * @return OrderModel
	 */
	public OrderModel load(Integer id) {
		return this.entityManager.find(OrderModel.class, id);
	}

	/**
	 * Save or update a OrderModel
	 * 
	 * @param order the OrderModel instance
	 * @return OrderModel
	 */
	public OrderModel save(OrderModel order) {
		return this.entityManager.merge(order);
	}

	/**
	 * Delete a OrderModel by this identifier
	 * 
	 * @param id the OrderModel identifier
	 * @return OrderModel
	 */
	public OrderModel delete(Integer id) {
		OrderModel order = load(id);
		if (order != null) {
			this.entityManager.remove(order);
		}
		return order;
	}
}
