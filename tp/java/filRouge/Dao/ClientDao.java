package filRouge.Dao;

import java.util.ArrayList;
import java.util.List;

import filRouge.model.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class ClientDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Client save(Client client) {
		System.out.println("TRIGGER save");
	return 	this.entityManager.merge(client);
		
	}
	
	
	public Client find(int id) {
		System.out.println(this.entityManager.find(Client.class, id));
		return this.entityManager.find(Client.class, id);
	}
	

	public void delete(int i) {
		this.entityManager.remove(i);
	}

	
	public List<Client> findAll(){
		   TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
	        List<Client> clients = query.getResultList();
		 return clients;

	}

	
	
	
	/*public List<Order> findByCompanyName(String companyNameParameter) {
		Query createdQuery = this.entityManager.createQuery("select c from Client c where c.companyName = :companyNameParameter ", Order.class);
		createdQuery.setParameter("companyNameParameter", companyNameParameter);
		return createdQuery.getResultList();
	}*/
	
	/*public List<Client> findAll(){
		int id=1;
		List<Client> allClients = new ArrayList<>() ;
		while(this.entityManager.find(Client.class, id) !=null) {
			allClients.add(this.entityManager.find(Client.class, id)) ;
			id++;
			
		}
		 return allClients;
	}*/
	

}
