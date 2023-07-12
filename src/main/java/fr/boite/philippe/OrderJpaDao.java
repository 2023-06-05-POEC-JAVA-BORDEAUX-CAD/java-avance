package fr.boite.philippe;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class OrderJpaDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public OrderJpa save(OrderJpa orderJpa) {
		return this.entityManager.merge(orderJpa);
	}

	public OrderJpa load(Integer id) {
		return this.entityManager.find(OrderJpa.class, id);
	}

	public List<OrderJpa> findByDesignation(String designation) {
		TypedQuery<OrderJpa> jpqlQuery = this.entityManager.createQuery("select o " + "from OrderJpa o "
				+ "where o.designation = :designation", OrderJpa.class);
		jpqlQuery.setParameter("designation", designation);
		return jpqlQuery.getResultList();
			
	}
}
