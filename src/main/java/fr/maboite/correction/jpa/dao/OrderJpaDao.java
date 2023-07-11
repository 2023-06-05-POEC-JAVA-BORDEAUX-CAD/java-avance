package fr.maboite.correction.jpa.dao;

import fr.maboite.correction.jpa.model.Order;
import fr.maboite.correction.jpa.model.PojoJpa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Data Access Object: classe permettant d'accéder en lecture ou écriture au
 * référentiel de données des Pojos : ici, on se base sur JPA.
 */
@Stateless
public class OrderJpaDao {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Ceci est une Javadoc de méthode
	 * @param order
	 * @return
	 */
	public Order save(Order order) {
		return this.entityManager.merge(order);
	}
	
	/**
	 * Récupère un order par id
	 * 
	 * @param id
	 * @return
	 */
	public Order load(Long id) {
		return this.entityManager.find(Order.class, id);
	}

	/**
	 * Supprime order par son id. Ne fait rien si id == null ou si aucun order n'a
	 * l'id en base de données.
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		if (id == null) {
			return;
		}
		
		Order savedEntity = this.entityManager.find(Order.class, id);
		if (savedEntity == null) {
			return;
		}
		this.entityManager.remove(savedEntity);
	}

}