package fr.noellie.jpa.dao;

import fr.noellie.jpa.model.OrderJPA;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderJPADao {

	@PersistenceContext
	protected EntityManager entityManager;

	public void save(OrderJPA orderJPA) {
		this.entityManager.merge(orderJPA);
	}

}