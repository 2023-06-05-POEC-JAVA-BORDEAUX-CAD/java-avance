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
	public Order save(Order order) {
		System.out.println("Sauvegarde de : " + order);
		return this.orderDao.save(order);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Order load(Long id) {
		System.out.println("Chargement de order avec id : " + id);
		Order order = this.orderDao.load(id);
		if (order == null) {
			System.out.println("aucun order trouvé");
			;
		} else {
			System.out.println("La commande 'order' trouvée est : " + order);
		}
		return order;

	}
}
