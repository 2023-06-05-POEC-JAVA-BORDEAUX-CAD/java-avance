package fr.maboite.fabien.tpjsf;

import fr.maboite.fabien.tpjsf.jpamodel.Order;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {
	@Inject
	private OrderDao orderDao;

	public Order save(Order order) {
		return this.orderDao.save(order);
	}

	public Order load(Long id) {
	System.out.println("Chargement de order avec id : " + id);
	Order order = this.orderDao.load(id);

	if (order == null) {
		System.out.println("aucun order trouvé");
	} else {
	}		return this.orderDao.save(order);
	
	
}
