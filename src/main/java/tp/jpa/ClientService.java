package tp.jpa;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ClientService {
	@Inject
	private ClientDao clidao;

	/**
	 * Load a ClientModel by this identifier
	 * 
	 * @param id the ClientModel identifier
	 * @return ClientModel
	 */
	public ClientModel load(Integer id) {
		return clidao.load(id);
	}

	/**
	 * Save or update a ClientModel
	 * 
	 * @param client the ClientModel instance
	 * @return ClientModel
	 */
	public ClientModel save(ClientModel client) {
		return clidao.save(client);
	}
	
	/**
	 * Delete a ClientModel by this identifier
	 * 
	 * @param id the ClientModel identifier
	 * @return ClientModel
	 */
	public ClientModel delete(Integer id) {
		return clidao.delete(id);
	}
}
