package fr.jpa.Orders;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


/**
 * Data Access Object: classe permettant d'accéder en lecture ou écriture au
 * référentiel de données des Pojos : ici, on se base sur JPA.
 */
@Stateless
public class OrdersDao {

  @PersistenceContext
  protected EntityManager entityManager;

  /**
	 * Sauvegarde order, mais ne le modifie pas. Renvoie une instance
	 * qui correspond à l'Order en base de données.
	 * @param orders
	 */
  public Orders save(Orders orders) {
  return this.entityManager.merge(orders);
 }


 /**
	 * Récupère un order par id
	 * @param id
	 * @return
	 */
  public Orders load(Integer id) {
  return this.entityManager.find(Orders.class, id);
}
  
}
