package tp.jpa;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderJpaService {
	@Inject
	private OrderDao ordao;

	/**
	 * Load all OrderModel
	 * 
	 * @return List<OrderModel>
	 */
	public List<OrderModel> getAll() {
		return ordao.getAll();
	}

	/**
	 * Load a OrderModel by this identifier
	 * 
	 * @param id the OrderModel identifier
	 * @return OrderModel
	 */
	public OrderModel load(Integer id) {
		return ordao.load(id);
	}

	/**
	 * Save or update a OrderModel
	 * 
	 * @param order the OrderModel instance
	 * @return OrderModel
	 */
	public OrderModel save(OrderModel order) {
		return ordao.save(order);
	}

	/**
	 * Delete a OrderModel by this identifier
	 * 
	 * @param id the OrderModel identifier
	 * @return OrderModel
	 */
	public OrderModel delete(Integer id) {
		return ordao.delete(id);
	}
}
