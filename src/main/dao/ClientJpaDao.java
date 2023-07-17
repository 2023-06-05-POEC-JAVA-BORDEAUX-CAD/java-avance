package fr.maboite.correction.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import fr.maboite.correction.jpa.model.Client;
import fr.maboite.correction.jpa.model.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClientJpaDao {
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
		List<Client> allClients = new ArrayList<>() ;

		 return allClients;

	}
	
	public List<Order> findByCompanyName(String companyNameParameter) {
		Query createdQuery = this.entityManager.createQuery("select c from Client c where c.companyName = :companyNameParameter ", Order.class);
		createdQuery.setParameter("companyNameParameter", companyNameParameter);
		return createdQuery.getResultList();
	}
	
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
