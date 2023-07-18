package fr.groupe2.tpapi.dao;

import java.util.List;

import fr.groupe2.tpapi.model.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class OrderDao {

	@PersistenceContext
	protected EntityManager entityManger;
	
	/**
	 * Find an order object by id
	 * @param id
	 * @return Client
	 */
	public Order find(Integer id) {
		return this.entityManger.find(Order.class, id);
	}
	
	/**
	 * Return all orders
	 * @return List<Client>
	 */
	public List<Order> getAllOrders() {
		TypedQuery<Order> query = this.entityManger.createQuery("select o from Client o", Order.class) ;
		return query.getResultList();
	}	
	
	/**
	 * Saves a new and or an existent order
	 * @param order
	 * @return Client
	 */
	public Order save(Order order) {
		return this.entityManger.merge(order);
	}
	
	/**
	 * Destroys an order
	 * @param id
	 */
	public void delete(Integer id) {
		Order orderTODelete = this.find(id);
		this.entityManger.remove(orderTODelete);
	}
	
	
}
