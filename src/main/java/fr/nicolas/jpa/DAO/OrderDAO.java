package fr.nicolas.jpa.DAO;

import fr.nicolas.jpa.Entity.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderDAO {
	@PersistenceContext
	protected EntityManager entityManger;

	public Order find(Integer id) {
		return this.entityManger.find(Order.class, id);
	}
	
	public void save(Order order) {
		this.entityManger.merge(order);
	}
}
