package fr.maboite.correction.jpa.service;

import fr.maboite.correction.jpa.dao.OrderJpaDao;
import fr.maboite.correction.jpa.model.Order;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {
	
	@Inject
	private OrderJpaDao orderJpaDao;
	
	/**
	 * Sauvegarde order, mais ne le modifie pas. Renvoie une instance
	 * qui correspond à l'Order en base de données.
	 * @param order
	 * @return
	 */
	public Order save(Order order) {
		System.out.println("Sauvegarde de : " + order);
		return this.orderJpaDao.save(order);
	}
	
	/**
	 * Récupère un order par id
	 * @param id
	 * @return
	 */
	public Order load(Long id) {
		System.out.println("Chargement de order avec id : " + id);
		Order order = this.orderJpaDao.load(id);
		if(order == null) {
			System.out.println("Aucun order trouvé");
		}else {
			System.out.println("L'order trouvé est : " + order);
		}
		return order;
	}
	
	/**
	 * Supprime order. Ne fait rien
	 * si order == null ou si aucune ligne
	 * ayant la même clé primaire n'existe en base de données.
	 * @param order
	 */
	public void delete(Order order) {
		if(order == null) {
			return;
		}
		this.orderJpaDao.delete(order.getId());
	}

}
