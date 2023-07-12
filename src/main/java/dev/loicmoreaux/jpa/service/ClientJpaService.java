package dev.loicmoreaux.jpa.service;

import java.util.List;

import dev.loicmoreaux.jpa.dao.ClientJpaDAO;
import dev.loicmoreaux.jpa.model.ClientJpa;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientJpaService {

	@Inject
	private ClientJpaDAO clientDAO;
	
	/**
	 * Create or update client into database
	 * @param client
	 * @return ClientJpa
	 */
	public ClientJpa save(ClientJpa client) {
		System.out.println("Save Client into Database");
		return clientDAO.save(client);
	}
	
	/**
	 * Get a client by id into database
	 * @param id
	 * @return ClientJpa
	 */
	public ClientJpa getClientById(Integer id) {
		System.out.println("Search Client by id = " + id + " into Database");
		return clientDAO.getClientById(id);
	}
	
	/**
	 * Get all clients into database
	 * @return List<ClientJpa>
	 */
	public List<ClientJpa> getClients(){
		return clientDAO.getClients();
	}
	
	/**
	 * Delete Client into the database
	 * @param id
	 */
	public void delete(Integer id) {
		System.out.println("Delete order by id = " + id);
		clientDAO.delete(id);
	}
}
