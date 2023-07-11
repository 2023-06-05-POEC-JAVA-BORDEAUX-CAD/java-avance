package fr.noellie.jpa.dao;

import fr.noellie.jpa.model.OrderJPA;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderJPADao {

	@PersistenceContext
	protected EntityManager entityManager;

	public OrderJPA save(OrderJPA orderJPA) {
		return this.entityManager.merge(orderJPA);
	}
	
	public OrderJPA load(Long id) {
		return this.entityManager.find(OrderJPA.class, id);
	}

}