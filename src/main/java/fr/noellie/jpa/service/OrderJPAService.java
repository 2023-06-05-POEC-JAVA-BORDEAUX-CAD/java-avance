package fr.noellie.jpa.service;

import fr.noellie.jpa.dao.OrderJPADao;
import fr.noellie.jpa.model.OrderJPA;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderJPAService {
	@Inject
	private OrderJPADao orderJPADao;
	
	/**
	 * Sauvegarde orderJPA, mais ne le modifie pas. Renvoie une instance
	 * qui correspond à l'OrderJPA en base de données.
	 * @param orderJPA
	 * @return
	 */
	public OrderJPA save(OrderJPA orderJPA) {
		System.out.println("Sauvegarde de : " + orderJPA);
		return this.orderJPADao.save(orderJPA);
	}
	
	/**
	 * Récupère un orderJPA par id
	 * @param id
	 * @return
	 */
	public OrderJPA load(Long id) {
		System.out.println("Chargement de orderJPA avec id : " + id);
		OrderJPA orderJPA = this.orderJPADao.load(id);
		if(orderJPA == null) {
			System.out.println("Aucun orderJPA trouvé");
		}else {
			System.out.println("L'orderJPA trouvé est : " + orderJPA);
		}
		return orderJPA;
	}
}