package fr.maboite.ebru.jpa.entity;

import jakarta.inject.Inject;
import fr.maboite.ebru.jpa.entity.OrderJPA;

public class OrderJpaService {

	@Inject
	private OrderDao orderDao;

	/**
	 * Sauvegarde order, mais ne le modifie pas. Renvoie une instance qui correspond
	 * à l'Order en base de données.
	 * 
	 * @param order
	 * @return
	 */

	public OrderJPA save(OrderJPA orderJpa) {
		System.out.println("Sauvegarde de : " + orderJpa);
		return this.orderDao.save(orderJpa);
	}

	/**
	 * Récupère un order par id
	 * 
	 * @param id
	 * @return
	 */
	public OrderJPA load(Integer id) {
		System.out.println("Chargement de order avec id : " + id);
		OrderJPA order = this.orderDao.load(id);
		if (order == null) {
			System.out.println("Aucun order trouvé");
		} else {
			System.out.println("L'order trouvé est : " + order);
		}
		return order;
	}

}
