package fr.groupe2.tpapi.dao;

import java.util.List;

import fr.groupe2.tpapi.model.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class OrderDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * Find an order object by id
	 * @param id
	 * @return Order
	 */
	public Order find(Integer id) {
		return this.entityManager.find(Order.class, id);
	}
	
	/**
	 * Return all orders
	 * @return List<Client>
	 */
	public List<Order> getAllOrders() {
		TypedQuery<Order> query = this.entityManager.createQuery("select o from Order o", Order.class) ;
		return query.getResultList();
	}	
	
	/**
	 * Saves a new and or an existent order
	 * @param order
	 * @return Order
	 */
	public Order save(Order order) {
		return this.entityManager.merge(order);
	}
	
	/**
	 * Destroys an order
	 * @param id
	 */
	public void delete(Integer id) {
		Order orderToDelete = this.find(id);
		
		if(orderToDelete != null) {
			this.entityManager.remove(orderToDelete);
		}
	}
	
	
}
