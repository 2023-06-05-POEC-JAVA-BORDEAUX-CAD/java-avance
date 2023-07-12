package fr.nicolas.jpa.DAO;

import java.util.List;

import fr.nicolas.jpa.Entity.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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
		TypedQuery<Client> query = this.entityManger.createQuery("select c from Client c", Client.class) ;
		return query.getResultList();
	}
	
	/**
	 * Returns clients by a company name
	 * @param companyName
	 * @return
	 */
	public List<Client> getClientByCompName(String companyName) {
		TypedQuery<Client> query = this.entityManger.createQuery("select c from Client c where c.companyName= :compName", Client.class);
		query.setParameter("compName", companyName);
		return query.getResultList();
	}
	
	
	/**
	 * Returns clients by two company names
	 * @param name
	 * @param name2
	 * @return
	 */
	public List<Client> getClientsByCompanyNameOr(String name, String name2) {
		TypedQuery<Client> query = this.entityManger.createQuery("select c "
				+ "from Client c "
				+ "where c.companyName= :compName "
				+ "or c.companyName= :compName2", Client.class);
		query.setParameter("compName", name);
		query.setParameter("compName2", name2);
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
