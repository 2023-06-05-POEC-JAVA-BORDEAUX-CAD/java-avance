package fr.maboite.correction.jpa.dao;

import fr.maboite.correction.jpa.model.Order;
import fr.maboite.correction.jpa.model.PojoJpa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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
	
	public void save(Order order) {
		System.out.println("TRIGGER save");
		this.entityManager.merge(order);
	}
	public void find(int id) {
		System.out.println("TRIGGER onLoad");
		System.out.println(this.entityManager.find(Order.class, id));
	}
	
	
	
}