package fr.noellie.jpa.dao;

import fr.noellie.jpa.model.ClientJPA;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientJPADao {

	@PersistenceContext
	protected EntityManager entityManager;

	public ClientJPA save(ClientJPA clientJPA) {
		return this.entityManager.merge(clientJPA);
	}

	public ClientJPA load(Long id) {
		return this.entityManager.find(ClientJPA.class, id);
	}

}