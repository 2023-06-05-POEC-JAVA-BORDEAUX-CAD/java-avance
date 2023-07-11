package fr.maboite.ebru.jpa.entity;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientJpaDao {
	
	
	@PersistenceContext // on inject objet entitymanager
	protected EntityManager entityManager;

	// on sauvegarde (insert ou update)
	
	public ClientJPA save(ClientJPA clientJpa) { 
		return this.entityManager.merge(clientJpa);
	}

	
	//on retourne une instance par son id
	public ClientJPA load(Integer id) {

		return this.entityManager.find(ClientJPA.class, id);
	}


}
