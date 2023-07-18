package fr.groupe3.tpfilrouge.clients;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class ClientDao {

	@PersistenceContext // on inject objet entitymanager
	protected EntityManager entityManager;

	// on sauvegarde (insert ou update)

	public Client save(Client client) {
		return this.entityManager.merge(client);
	}

	// on retourne une instance par son id
	public Client load(Long id) {

		return this.entityManager.find(Client.class, id);
	}
	
	
	public List<Client> findAll() {
		
		 TypedQuery<Client> jpqlQuery = this.entityManager.createQuery("select c " + " from Client c ", Client.class) ; 
		 
		 return jpqlQuery.getResultList();
	}


//	public List<Client> findByCompanyName(String companyName) {
//
//		TypedQuery<Client> jpqlQuery = this.entityManager.createQuery("select c " + " from Client c " // on met le nom
//																										// de la classe
//																										// Client dans
//																										// java
//				+ " where c.companyName = :companyname", Client.class);
//		// c.companyName ( on met l'attribut companyName definit dans la classe
//		// client
//		jpqlQuery.setParameter("companyname", companyName);
//
//		return jpqlQuery.getResultList();
//	}

	
}