package tp.jpa;

import java.util.List;
import java.util.ArrayList;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientDao {
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Load all ClientModel
	 * 
	 * @return List<ClientModel>
	 */
	public List<ClientModel> getAll() {
		String QLS = "select o from ClientModel o";
		TypedQuery<ClientModel> request = this.entityManager.createQuery(QLS, ClientModel.class);
		return request.getResultList();
	}

	/**
	 * Load a ClientModel by this identifier
	 * 
	 * @param id the ClientModel identifier
	 * @return ClientModel
	 */
	public ClientModel load(Integer id) {
		return this.entityManager.find(ClientModel.class, id);
	}

	public List<ClientModel> getAllByCompanyName(String name) {
		String QLS = "select o from ClientModel o where o.companyName = :name";
		TypedQuery<ClientModel> request = this.entityManager.createQuery(QLS, ClientModel.class);
		request.setParameter("name", name);
		return request.getResultList();
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
