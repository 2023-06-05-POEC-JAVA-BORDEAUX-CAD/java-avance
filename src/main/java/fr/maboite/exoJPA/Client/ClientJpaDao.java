package fr.maboite.exoJPA.Client;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientJpaDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	

	public ClientEntity save(ClientEntity client) {
		return this.entityManager.merge(client);
	}

	public ClientEntity load(Integer integer) {
		return this.entityManager.find(ClientEntity.class, integer);
	}

}
