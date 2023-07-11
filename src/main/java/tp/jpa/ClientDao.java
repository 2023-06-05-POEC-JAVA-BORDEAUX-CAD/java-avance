package tp.jpa;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientDao {
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Load a ClientModel by this identifier
	 * 
	 * @param id the ClientModel identifier
	 * @return ClientModel
	 */
	public ClientModel load(Integer id) {
		return this.entityManager.find(ClientModel.class, id);
	}

	/**
	 * Save or update a ClientModel
	 * 
	 * @param client the ClientModel instance
	 * @return ClientModel
	 */
	public ClientModel save(ClientModel client) {
		return this.entityManager.merge(client);
	}

	/**
	 * Delete a ClientModel by this identifier
	 * 
	 * @param id the ClientModel identifier
	 * @return ClientModel
	 */
	public ClientModel delete(Integer id) {
		ClientModel client = load(id);
		if (client != null) {
			this.entityManager.remove(client);
		}
		return client;
	}
}
