package fr.boite.philippe.jsf.controller;

import fr.boite.philippe.OrderJpa;
import fr.boite.philippe.OrderJpaDao;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
@Stateless
public class OrderJpaService {

	@Inject
	private OrderJpaDao orderJpaDao;
	
	public OrderJpa save(OrderJpa orderJpa) {
		System.out.println("Sauvegarde de : " + orderJpa);
		return this.orderJpaDao.save(orderJpa);
	}
	
	public OrderJpa load(Integer id) {
		System.out.println("Chargement de orderJpa avec id : " + id);
		OrderJpa orderJpa = this.orderJpaDao.load(id);
		if(orderJpa == null) {
			System.out.println("Aucun orderJpa trouvé");
		} else {
			System.out.println("L'orderJpa trouvé est : " + orderJpa);
		}
		return orderJpa;
	}
}
