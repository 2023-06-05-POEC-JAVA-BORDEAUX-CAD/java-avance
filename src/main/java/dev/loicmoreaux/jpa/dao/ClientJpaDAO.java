package dev.loicmoreaux.jpa.dao;

import java.util.List;

import dev.loicmoreaux.jpa.model.ClientJpa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClientJpaDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	/**
	 * Create or update client into database
	 * @param client
	 * @return ClientJpa
	 */
	public ClientJpa save(ClientJpa client){
		return this.entityManager.merge(client);
	}
	
	/**
	 * Get a client by id into database
	 * @param id
	 * @return Client
	 */
	public ClientJpa getClientById(Integer id) {
		return this.entityManager.find(ClientJpa.class, id);
	}
	
	/**
	 * Get all clients into database
	 * @return List<ClientJpa>
	 */
	public List<ClientJpa> getClients(){
		Query jpqlQuery = this.entityManager.createQuery("select c from ClientJpa c", ClientJpa.class);
		return jpqlQuery.getResultList();
	}
	
	/**
	 * Get clients into the Database By Compagny name
	 * @param companyName
	 * @return List<ClientJpa>
	 */
	public List<ClientJpa> getClientByCompagnyName(String companyName){
		Query jpqlQuery = this.entityManager.createQuery(
				"select c "
				+ "from ClientJpa c "
				+ "where c.companyName = :companyName", ClientJpa.class);
		jpqlQuery.setParameter("companyName", companyName);
		return jpqlQuery.getResultList();	
	}
	
	/**
	 * Get clients into the Database By Compagny name and city
	 * @param companyName
	 * @param city
	 * @return
	 */
	public List<ClientJpa> getClientByCompagnyNameAndCity(String companyName, String city){
		Query jpqlQuery = this.entityManager.createQuery(
				"select c "
				+ "from ClientJpa c "
				+ "where c.companyName = :companyName "
				+ "and c.city = :city", ClientJpa.class);
		jpqlQuery.setParameter("companyName", companyName);
		jpqlQuery.setParameter("city", city);
		return jpqlQuery.getResultList();	
	}
	
	/**
	 * Delete Client into the database
	 * @param id
	 */
	public void delete(Integer id) {
		ClientJpa client = this.getClientById(id);
		if(client != null) {
			this.entityManager.remove(client);
		}
	}
	
}
