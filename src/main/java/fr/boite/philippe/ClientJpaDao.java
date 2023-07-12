package fr.boite.philippe;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Stateless
public class ClientJpaDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	public ClientJpa save(ClientJpa clientJpa) {
		return this.entityManager.merge(clientJpa);
	}

	public ClientJpa load(Integer id) {
		return this.entityManager.find(ClientJpa.class, id);
		
	}
		
		public List<ClientJpa> findByCompanyName(String companyName){
			TypedQuery<ClientJpa> jpqlQuery = this.entityManager.createQuery(
					"select c " 
					+ "from ClientJpa c "
					+ "where c.companyName = :companyName", ClientJpa.class );
	jpqlQuery.setParameter("companyName", companyName);
	return jpqlQuery.getResultList();

			
		}
	

}
