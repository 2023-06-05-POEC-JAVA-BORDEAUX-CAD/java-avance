package fr.fabien.tpjsf.jpaservice;

import fr.fabien.tpjsf.jpadao.ClientDao;
import fr.fabien.tpjsf.jpamodel.Client;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {
	
	@Inject
	private ClientDao clientDao;

	/**
	 * 
	 * @param order
	 * @return
	 */

	public Client getOrderById(Long id) {
		return this.clientDao.find(id);
	}

	public void save(Client order) {
		System.out.println("Sauvegarde de : " + order);
		this.clientDao.save(order);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public void delete(Long id) {
		Client clientToDelete = this.clientDao.find(id);
		this.clientDao.delete(clientToDelete);
	}
}
