package fr.maboite.jpa2.order;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {

	@Inject
	private OrderJpaDao orderJpaDao;

	public Order save(Order order) {
		System.out.println("Sauvegarde de la commande : " + order.getDesignation());
		return this.orderJpaDao.save(order);
	}

	public Order load(Long id) {
		System.out.println("Chargement de la commande avec id : " + id);
		Order order = this.orderJpaDao.load(id);
		if (order == null) {
			System.out.println("Aucune commande trouvé pour l'id " + id);
		} else {
			System.out.println("La commande a été trouvée et est : " + order.getDesignation());
		}
		return order;
	}

	public void delete(Long id) {
		System.out.println("Suppression de la commande davec l'id : " + id);
		this.orderJpaDao.delete(id);
		System.out.println("Element supprimé ");
	}

}