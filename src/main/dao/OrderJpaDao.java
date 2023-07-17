package fr.maboite.correction.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.model.Order;
import fr.maboite.correction.jpa.model.PojoJpa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Data Access Object: classe permettant 
 * d'accéder en lecture ou écriture au référentiel 
 * de données des Pojos (ici, une simple Map)
 */
@Stateless
public class OrderJpaDao {
	
	@PersistenceContext
	protected EntityManager entityManager;

	public void test() {
		System.out.println(entityManager);
	}
	

	public Order save(Order order) {
		System.out.println("TRIGGER save");
	return 	this.entityManager.merge(order);
		
	}
	
	
	public Order find(int id) {
		System.out.println(this.entityManager.find(Order.class, id));
		return this.entityManager.find(Order.class, id);
	}
	

	public void delete(int id) {
        Order order = entityManager.find(Order.class, id);
        if (order != null) {
            entityManager.remove(order);
        }
    }

	/**
	 * 
	 * @param designation
	 * @return
	 */
	/*public List<Order> findByDesignation(String designation) {
		Query createdQuery = this.entityManager.createQuery("select o from Order o where o.designation= :designation ", Order.class);
		createdQuery.setParameter("designation", designation);
		return createdQuery.getResultList();
	}
	*/
	
	
	
}