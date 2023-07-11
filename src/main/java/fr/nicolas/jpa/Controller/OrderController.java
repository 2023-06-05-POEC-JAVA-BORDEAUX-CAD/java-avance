package fr.nicolas.jpa.Controller;


import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.nicolas.jpa.Entity.Order;
import fr.nicolas.jpa.Service.OrderService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrderController {

	@Inject
	private OrderService orderService;
	
	private String id;
	
	private Order order;
	
	private Map<String, String> ordersIds = new HashMap<>();
	
	private List<Order> orders;
	
	public void onLoad() {
		
		if(id !=null) {
			try {
				Integer id = Integer.valueOf(this.id);
				this.order = this.orderService.getOrderById(id);
				
			}
			catch(NumberFormatException e) {
				
			}
			catch(NullPointerException e) {
				System.out.println("Client invalide avec cet id : " + this.id +"");
			}
		} else {
			try {
				
				Order nOrder = new Order();
				nOrder.setDesignation("Angular");
				nOrder.setTypePresta("Formation");
				nOrder.setClientId(1);
				
				this.orderService.save(nOrder);
				
				this.orders = this.orderService.getAllOrders();
				for(Order order: this.orders) {
					String sId = String.valueOf(order.getId());
					this.ordersIds.put("Command N° : " + sId,"1");
				}
				
				Integer orderTODeleteID = this.orders.get(1).getId();
				this.orderService.deleteById(orderTODeleteID);
				
				
			} catch(NullPointerException e) {
				System.out.println("Null object in controller layer at orders " + e.getMessage());
			}
		}
		
	}
	
	public String catchButtonSelect() {
		//System.out.println(this.getId());
		return "orders_clients.xhtml?faces-redirect=true&id="+this.getId();
		
	}

	public OrderService getClientService() {
		return orderService;
	}

	public String getId() {
		return id;
	}

	public void setClientService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Map<String, String> getOrdersIds() {
		return ordersIds;
	}

	public void setOrdersIds(Map<String, String> ordersIds) {
		this.ordersIds = ordersIds;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
