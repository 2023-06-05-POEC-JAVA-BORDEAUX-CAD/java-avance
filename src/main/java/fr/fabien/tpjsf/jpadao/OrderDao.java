package fr.fabien.tpjsf.jpadao;

import java.util.List;

import fr.fabien.tpjsf.jpamodel.OrderModel;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderDao {
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Load all OrderModel
	 * 
	 * @return List<OrderModel>
	 */
	public List<OrderModel> getAll() {
		String QLS = "select o from OrderModel o";
		TypedQuery<OrderModel> request = this.entityManager.createQuery(QLS, OrderModel.class);
		return request.getResultList();
	}

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
		order.setClient(null);
		if (order != null) {
			this.entityManager.remove(order);
		}
		return order;
	}
}
