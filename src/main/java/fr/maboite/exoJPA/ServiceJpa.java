package fr.maboite.exoJPA;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ServiceJpa {
	
	@Inject
	private OrderJpaDao orderJpaDao;
	

	public OrderEntity save(OrderEntity order) {
		System.out.println("Sauvegarde de : " + order);
		return this.orderJpaDao.save(order);
	}
	

	public OrderEntity load(Integer integer) {
		System.out.println("Chargement de order avec id : " + integer);
		OrderEntity order = this.orderJpaDao.load(integer);
		if(order == null) {
			System.out.println("Aucun order trouvé");
		}else {
			System.out.println("L'order trouvé est : " + order);
		}
		return order;
	}

}
