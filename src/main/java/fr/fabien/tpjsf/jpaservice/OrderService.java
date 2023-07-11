package fr.fabien.tpjsf.jpaservice;

import fr.fabien.tpjsf.jpadao.OrderDao;
import fr.fabien.tpjsf.jpamodel.Order;
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

	public Order getOrderById(Long id) {
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
	public void delete(Long id) {
		this.orderDao.delete(id);
	}
}
