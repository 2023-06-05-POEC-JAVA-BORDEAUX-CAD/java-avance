package fr.groupe2.tpapi.service;

import java.util.List;

import fr.groupe2.tpapi.dao.ClientDao;
import fr.groupe2.tpapi.model.Client;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {

	@Inject 
	ClientDao clientDao;
	

	public Client getClientById(Integer id) {
		return this.clientDao.find(id);
	}
	
	public List<Client> getAllClients() {
		return this.clientDao.getAllClients();
	}
	
	public Client save(Client client) {
		return this.clientDao.save(client);
	}
	
	public void deleteById(Integer id) {
		this.clientDao.delete(id);
	}
	
}
