package fr.nicolas.jpa.DAO;

import java.util.List;

import fr.nicolas.jpa.Entity.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClientDAO2 {

	@PersistenceContext
	protected EntityManager entityManger;
	
	/**
	 * Find an order object by id
	 * @param id
	 * @return Client
	 */
	public Client find(Integer id) {
		return this.entityManger.find(Client.class, id);
	}
	
	/**
	 * Return all orders
	 * @return List<Client>
	 */
	public List<Client> getAllOrders() {
		Query query = this.entityManger.createQuery("select c from Client c", Client.class) ;
		return query.getResultList();
	}
	
	
	/**
	 * Saves a new and or an existent order
	 * @param order
	 * @return Client
	 */
	public Client save(Client order) {
		return this.entityManger.merge(order);
	}
	
	/**
	 * Destroys an order
	 * @param id
	 */
	public void delete(Integer id) {
		Client orderTODelete = this.find(id);
		this.entityManger.remove(orderTODelete);
	}
	
	
}
