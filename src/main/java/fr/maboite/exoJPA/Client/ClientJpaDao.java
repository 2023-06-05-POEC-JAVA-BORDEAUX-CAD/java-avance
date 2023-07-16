package fr.maboite.exoJPA.Client;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

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
	
	/**
	 * Renvoie tous les Clients dont l'attribut companyName vaut l'argument companyName de la méthode
	 * 
	 * @param argumentDeMethodedesignation
	 * @return
	 */
	
	public List<ClientEntity> findByCompanyName(String companyName) {
		Query jpqlQuery = this.entityManager.createQuery(
				"select o "
				+ " from ClientEntity o "
				+ " where o.companyName = :Companyname", ClientEntity.class);
		jpqlQuery.setParameter("Companyname", companyName);
		return jpqlQuery.getResultList();
	}

}
