package dev.loicmoreaux.jpa.dao;

import dev.loicmoreaux.jpa.model.ClientJpa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientJpaDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * 
	 * @param client
	 * @return savedClient
	 */
	public ClientJpa save(ClientJpa client){
		return this.entityManager.merge(client);
	}
	
	/**
	 * 
	 * @param id
	 * @return Client
	 */
	public ClientJpa load(Integer id) {
		return this.entityManager.find(ClientJpa.class, id);
	}
	
	public void delete(Integer id) {
		ClientJpa client = this.load(id);
		if(client != null) {
			this.entityManager.remove(client);
		}
	}
	
}
