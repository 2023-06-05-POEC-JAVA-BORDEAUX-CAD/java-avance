package fr.maboite.correction.jpa.dao;

import java.util.List;

import fr.maboite.correction.jpa.model.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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
	 * 
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
	
	public void deleteJpql(Long id) {
		Query jpqlQuery = this.entityManager.createQuery(
				"delete o "
				+ " from Order o "
				+ " where o.id = :id");
		jpqlQuery.setParameter("id", id);
		jpqlQuery.executeUpdate();
	}

	/**
	 * Renvoie tous les Order dont la désignation vaut designation. Inutile
	 * car this.entityManager.find(...) propose déjà cette fonctionnalité.
	 * 
	 * @param argumentDeMethodedesignation
	 * @return
	 */
	public List<Order> findByDesignation(String argumentDeMethodedesignation) {
		TypedQuery<Order> jpqlQuery = this.entityManager.createQuery(
				"select o "
				+ " from Order o "
				+ " where o.designation = :parametreDeRequeteDesignation ", Order.class);
		jpqlQuery.setParameter("parametreDeRequeteDesignation", argumentDeMethodedesignation);
		return jpqlQuery.getResultList();
	}

}