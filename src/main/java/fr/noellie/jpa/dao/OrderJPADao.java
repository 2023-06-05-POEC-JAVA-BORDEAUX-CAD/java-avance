package fr.noellie.jpa.dao;

import java.util.List;

import fr.noellie.jpa.model.OrderJPA;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Data Access Object: classe permettant d'accéder en lecture ou écriture au
 * référentiel de données des Pojos : ici, on se base sur JPA.
 */
@Stateless
public class OrderJPADao {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Sauvegarde un order
	 * 
	 * @param orderJPA
	 * @return
	 */
	public OrderJPA save(OrderJPA orderJPA) {
		return this.entityManager.merge(orderJPA);
	}

	/**
	 * Récupère un order par ID
	 * 
	 * @param id
	 * @return
	 */
	public OrderJPA load(Long id) {
		return this.entityManager.find(OrderJPA.class, id);
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

		OrderJPA savedEntity = this.entityManager.find(OrderJPA.class, id);
		if (savedEntity == null) {
			return;
		}
		this.entityManager.remove(savedEntity);
	}

	/**
	 * Renvoie tous les orders dont la désignation vaut designation
	 * 
	 * @param designation
	 * @return
	 */
	public List<OrderJPA> findByDesignation(String designation) {
		TypedQuery<OrderJPA> createQuery = this.entityManager
				.createQuery("select o " + "from OrderJPA o " + "where o.designation = :designation", OrderJPA.class);
		createQuery.setParameter("designation", designation);
		return createQuery.getResultList();
	}

}