package fr.jpa.Orders;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class OrdersService {

  @Inject
  OrdersDao ordersDao;

  /**
	 * Sauvegarde order, mais ne le modifie pas. Renvoie une instance
	 * qui correspond à l'Order en base de données.
	 * @param orders
	 * @return
	 */
	public Orders save(Orders orders) {
		System.out.println("Sauvegarde de : " + orders);
		return this.ordersDao.save(orders);
	}


  /**
	 * Récupère un order par id
	 * @param id
	 * @return
	 */
  public Orders load(Integer id) {
		System.out.println("Chargement de order avec id : " + id);
		Orders orders = this.ordersDao.load(id);
		if(orders == null) {
			System.out.println("Aucun order trouvé");
		}else {
			System.out.println("L'order trouvé est : " + orders);
		}
		return orders;
	}
}
