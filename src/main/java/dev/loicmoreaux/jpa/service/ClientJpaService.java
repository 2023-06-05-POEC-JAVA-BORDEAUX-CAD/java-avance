package dev.loicmoreaux.jpa.service;

import dev.loicmoreaux.jpa.dao.ClientJpaDAO;
import dev.loicmoreaux.jpa.model.ClientJpa;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientJpaService {

	@Inject
	private ClientJpaDAO clientDAO;
	
	/**
	 * 
	 * Method for save client into the database
	 * @param client
	 * @return savedClient
	 */
	public ClientJpa save(ClientJpa client) {
		System.out.println("Save Client into Database");
		return clientDAO.save(client);
	}
	
	/**
	 * 
	 * Method for search into the database a client by id
	 * @param id
	 * @return Client
	 */
	public ClientJpa load(Integer id) {
		System.out.println("Search Client by id = " + id + " into Database");
		return clientDAO.load(id);
	}
	
	/**
	 * 
	 * Method for delete a client
	 * @param id
	 */
	public void delete(Integer id) {
		System.out.println("Delete order by id = " + id);
		clientDAO.delete(id);
	}
}
