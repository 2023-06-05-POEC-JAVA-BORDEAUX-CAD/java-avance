package filRouge.service;

import java.util.List;

import filRouge.Dao.OrderDao;
import filRouge.model.Order;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {

	@Inject
	private OrderDao orderDao;
	

	public Order save(Order order) {
		return orderDao.save(order);
	}

	public Order load(int id) {
		return orderDao.find(id);
	}
	
	public List<Order> findAll(){
		return orderDao.findAll();
	}
	public List<Order> findAllCommandByClient(Integer id){
		return orderDao.findAllCommandByClient(id);
	}
	
	
	public void deleteById(int id) {
		Order OrderToDelete = orderDao.find(id);
		System.out.println("suppression order: id " + OrderToDelete.getId() + " designation = " + OrderToDelete.getDesignation()  );
		orderDao.delete(id);
	}
}
