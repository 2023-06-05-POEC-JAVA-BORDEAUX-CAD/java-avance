package fr.maboite.jpa;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class ClientJpaDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * Sauvegarde Client, mais ne le modifie pas. Renvoie une instance
	 * qui correspond à l'Client en base de données.
	 * @param Client
	 * @return
	 */
	public ClientJpa saveClient(ClientJpa clientJpa) {
		return this.entityManager.merge(clientJpa);
		
	}
	
	/**
	 * trouve un Client en fonction de l'id
	 * @param id
	 * @return
	 */
	public ClientJpa findClient(Integer id) {
		return this.entityManager.find(ClientJpa.class,id);
	}
	
	public List<ClientJpa> findByCompanyName(String  companyName){
		TypedQuery<ClientJpa> jpqlQuery= this.entityManager.createQuery("select c "
				+ " from ClientJpa c " //travaille du coté objet/classe pas du coté base de donnée
				+ " where c.companyName = :companyName"
				    , ClientJpa.class);
		jpqlQuery.setParameter("companyName", companyName);
		return jpqlQuery.getResultList();
		
	}
	

}
