package fr.groupe2.tpapi.dao;

import java.util.List;

import fr.groupe2.tpapi.model.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class ClientDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * Find an client object by id
	 * @param id
	 * @return Client
	 */
	public Client find(Integer id) {
		return this.entityManager.find(Client.class, id);
	}
	
	/**
	 * Return all clients
	 * @return List<Client>
	 */
	public List<Client> getAllClients() {
		TypedQuery<Client> query = this.entityManager.createQuery("select c from Client c", Client.class) ;
		return query.getResultList();
	}
	
	
	/**
	 * Saves a new and or an existent client
	 * @param client
	 * @return Client
	 */
	public Client save(Client client) {
		return this.entityManager.merge(client);
	}
	
	/**
	 * Destroys an client
	 * @param id
	 */
	public void delete(Integer id) {
		Client clientToDelete = this.find(id);
		
		if(clientToDelete != null) {
			this.entityManager.remove(clientToDelete);
		}
	}
	
	
}
