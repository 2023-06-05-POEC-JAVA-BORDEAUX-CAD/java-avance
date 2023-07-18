package filRouge.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import filRouge.model.Client;
import filRouge.model.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
@Stateless
public class OrderDao {
	
	@PersistenceContext
	protected EntityManager entityManager;

	public void test() {
		System.out.println(entityManager);
	}
	

	public Order save(Order order) {
		System.out.println("TRIGGER save");
	return 	this.entityManager.merge(order);
		
	}
	
	
	public Order find(int id) {
		System.out.println(this.entityManager.find(Order.class, id));
		return this.entityManager.find(Order.class, id);
	}
	

	public void delete(int id) {
        Order order = entityManager.find(Order.class, id);
        if (order != null) {
            entityManager.remove(order);
        }
    }

	public List<Order> findAll(){
		 TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
		 List<Order> allOrders  = query.getResultList();
		return allOrders;
	}
	public List<Order> findAllCommandByClient(Integer id){
		TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o WHERE o.client.id = :clientId", Order.class);
		query.setParameter("clientId", id);
		List<Order> allOrders  = query.getResultList();
		return allOrders;
	}
	
	
	
	
	
}