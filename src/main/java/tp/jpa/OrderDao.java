package tp.jpa;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class OrderDao {
	@PersistenceContext
	protected EntityManager entityManager;

	public void save(OrderModel client) {
		this.entityManager.merge(client);
	}
}
