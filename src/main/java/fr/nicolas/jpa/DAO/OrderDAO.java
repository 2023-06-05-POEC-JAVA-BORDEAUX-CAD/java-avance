package fr.nicolas.jpa.DAO;

import java.util.List;

import fr.nicolas.jpa.Entity.Order;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class OrderDAO {
	@PersistenceContext
	protected EntityManager entityManger;

	public Order find(Integer id) {
		return this.entityManger.find(Order.class, id);
	}
	
	public List<Order> getAllOrders() {
		Query query = this.entityManger.createQuery("select o from Order o", Order.class) ;
		return query.getResultList();
	}
	
	public Order save(Order order) {
		return this.entityManger.merge(order);
	}
	
	public void delete(Integer id) {
		Order orderTODelete = this.find(id);
		this.entityManger.remove(orderTODelete);
	}
}
