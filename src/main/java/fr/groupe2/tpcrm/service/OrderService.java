package fr.groupe2.tpcrm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.groupe2.tpcrm.dao.OrderDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class OrderService {
	
	@Inject
	private OrderDAO orderDao; 

	public String getOrderByIdToString(Integer id) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this.orderDao.getOrderById(id)); 
	}
	
	public String getOrdersToString() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this.orderDao.getOrders());
	}
	
}
