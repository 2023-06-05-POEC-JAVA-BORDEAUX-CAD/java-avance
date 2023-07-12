package fr.fabien.tpjsf.jpadao;

import java.util.List;

import fr.fabien.tpjsf.jpamodel.Client;
import fr.fabien.tpjsf.jpamodel.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class OrderDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public Order find (Long id) {
		return this.entityManager.find(Order.class, id);
	}

	/**
	 * 
	 * @param order
	 * @return
	 */
	public Order save(Order order) { // charge cette entité en BDD
		return this.entityManager.merge(order);
	}

	/**
	 * 
	 * @param long1
	 */
	public void delete(Long long1) {
		if (long1==null) {
			return;
		}
		Order savedEntity = this.entityManager.find(Order.class, long1);
		if (savedEntity == null) {
			return;
		}
		this.entityManager.remove(savedEntity);
	}
	
	public List<Order> findByDesignation(String argumentDeMethodedesignation) {
		TypedQuery<Order> jpqlQuery = this.entityManager.createQuery(
				"select o "
				+ " from Order o "
				+ " where o.designation = :parametreDeRequeteDesignation", Order.class);
		jpqlQuery.setParameter("parametreDeRequeteDesignation", argumentDeMethodedesignation);
		return jpqlQuery.getResultList();
	}


	
}
