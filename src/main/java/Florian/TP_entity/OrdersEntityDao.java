package Florian.TP_entity;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Data Access Object: classe permettant d'accéder en lecture ou écriture au
 * référentiel de données des Pojos : ici, on se base sur JPA.
 */
@Stateless
public class OrdersEntityDao {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Sauvegarde order, mais ne le modifie pas. Renvoie une instance qui correspond
	 * à l'Order en base de données.
	 * 
	 * @param order
	 * @return
	 */
	public OrderEntity save(OrderEntity order) {
		return this.entityManager.merge(order);
	}

	/**
	 * Récupère un order par id
	 * 
	 * @param id
	 * @return
	 */
	public OrderEntity load(Integer id) {
		return this.entityManager.find(OrderEntity.class, id);
	}
}
