package Florian.TP_entity;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {

	@Inject
	private OrdersEntityDao ordersEntityDao;

	/**
	 * Sauvegarde order, mais ne le modifie pas. Renvoie une instance qui correspond
	 * à l'Order en base de données.
	 * 
	 * @param order
	 * @return
	 */
	public OrderEntity save(OrderEntity order) {
		System.out.println("Sauvegarde de : " + order);
		return this.ordersEntityDao.save(order);
	}

	/**
	 * Récupère un order par id
	 * 
	 * @param id
	 * @return
	 */
	public OrderEntity load(Integer id) {
		System.out.println("Chargement de order avec id : " + id);
		OrderEntity order = this.ordersEntityDao.load(id);
		if (order == null) {
			System.out.println("Aucun order trouvé");
		} else {
			System.out.println("L'order trouvé est : " + order);
		}
		return order;
	}

}
