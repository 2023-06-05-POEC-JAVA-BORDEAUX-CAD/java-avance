package tp.jpa;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientDao {
	@PersistenceContext
	protected EntityManager entityManager;

	public void save(ClientModel client) {
		this.entityManager.merge(client);
	}
}
