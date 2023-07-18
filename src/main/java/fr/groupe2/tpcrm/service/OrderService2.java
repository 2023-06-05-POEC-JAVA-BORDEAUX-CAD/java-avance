package fr.groupe2.tpcrm.service;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.groupe2.tpcrm.dao.OrderDAO2;
import fr.groupe2.tpcrm.model.Order2;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService2 {
	
	@Inject
	private OrderDAO2 orderDao; 

	public String getOrderByIdToString(Integer id) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Order2 order = this.orderDao.getOrderById(id);
		if(order== null) return null;
		return objectMapper.writeValueAsString(order); 
	}
	
	public String getOrdersToString() throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<Integer, Order2> orders = this.orderDao.getOrders();
		if(orders == null) return null;
		return objectMapper.writeValueAsString(orders);
	}
	
}
