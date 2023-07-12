package fr.maboite.jpa;

import java.util.List;

import javax.management.Query;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Stateless
public class OrderDao {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Sauvegarde order, mais ne le modifie pas. Renvoie une instance qui correspond
	 * à l'Order en base de données.
	 * 
	 * @param order
	 * @return
	 */
	public OrderJpa save(OrderJpa orderJpa) {
		return this.entityManager.merge(orderJpa);

	}

	/**
	 * Charge (récupere) un order en fonction de l'id
	 * 
	 * @param id
	 * @return
	 */
	public OrderJpa load(Integer id) {
		return this.entityManager.find(OrderJpa.class, id);
	}
	
	

	

}
