package fr.boite.philippe;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientJpaDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public ClientJpa save(ClientJpa clientJpa) {
		return this.entityManager.merge(clientJpa);
	}
	
	public ClientJpa load(Integer id) {
		return this.entityManager.find(ClientJpa.class, id);
	}
}
