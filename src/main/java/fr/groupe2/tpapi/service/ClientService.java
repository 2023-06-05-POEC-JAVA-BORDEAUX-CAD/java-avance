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
	

	public Client getOrderById(Integer id) {
		return this.clientDao.find(id);
	}
	
	public List<Client> getAllOrders() {
		return this.clientDao.getAllOrders();
	}
	
	public Client save(Client order) {
		return this.clientDao.save(order);
	}
	
	public void deleteById(Integer id) {
		this.clientDao.delete(id);
	}
	
}
