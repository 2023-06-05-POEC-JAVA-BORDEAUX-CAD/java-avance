package fr.nicolas.jpa.Service;

import java.util.List;

import fr.nicolas.jpa.DAO.ClientDAO2;
import fr.nicolas.jpa.Entity.Client;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService2 {

	
	@Inject 
	ClientDAO2 clientDAO;
	

	public Client getClientById(Integer id) {
		return this.clientDAO.find(id);
	}
	
	public List<Client> getAllClients() {
		return this.clientDAO.getAllOrders();
	}
	
	public void save(Client order) {
		this.clientDAO.save(order);
	}
	
	public void deleteById(Integer id) {
		this.clientDAO.delete(id);
	}
}
