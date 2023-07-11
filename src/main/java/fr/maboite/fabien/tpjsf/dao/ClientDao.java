package fr.maboite.fabien.tpjsf.dao;

import fr.maboite.fabien.tpjsf.jpamodel.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public Client find (Integer id) {
		return this.entityManager.find(Client.class, id);
	}

	/**
	 * 
	 * @param order
	 * @return
	 */
	public Client save(Client client) { // charge cette entité en BDD
		return this.entityManager.merge(client);
	}

	/**
	 * 
	 * @param orderToDelete
	 */
	public void delete(Client orderToDelete) {
		if (orderToDelete!=null) {
			return;
		}
		Client savedEntity = this.entityManager.find(Client.class, orderToDelete);
		if (savedEntity == null) {
			return;
		}
		this.entityManager.remove(savedEntity);
	}

	
}
