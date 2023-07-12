package fr.maboite.ebru.jpa.entity;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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

	
	public List<ClientJPA> findByCompanyName(String companyName) {
		
		TypedQuery<ClientJPA> jpqlQuery= this.entityManager.createQuery("select c "
				+" from ClientJPA c "  // on met le nom de la classe Client dans java
				+ " where c.companyName = :companyname", ClientJPA.class); 
		// c.companyName ( on met l'attribut companyName definit dans la classe clientjpa
		jpqlQuery.setParameter("companyname", companyName);
		
		
		return jpqlQuery.getResultList();
	}

}
