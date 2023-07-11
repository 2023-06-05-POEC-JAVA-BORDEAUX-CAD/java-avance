package fr.maboite.fabien.tpjsf;

import fr.maboite.fabien.tpjsf.jpamodel.Order;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {

	@Inject
	private OrderDao orderDao;

	/**
	 * 
	 * @param order
	 * @return
	 */

	public Order getOrderById(Integer id) {
		return this.orderDao.find(id);
	}

	public void save(Order order) {
		System.out.println("Sauvegarde de : " + order);
		this.orderDao.save(order);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public void deleteById(Integer id) {
		Order orderToDelete = this.orderDao.find(id);
		this.orderDao.delete(orderToDelete);
	}
}
