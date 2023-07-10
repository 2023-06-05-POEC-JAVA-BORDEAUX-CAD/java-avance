package fr.nicolas.jpa.Controller;


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
	
public void onLoad() {
		
		if(id !=null) {
			try {
				Integer id = Integer.valueOf(this.id);
				Order ord = this.orderService.getOrderById(id);
				System.out.println(ord);
				ord.setDesignation("Angular");
				this.orderService.save(ord);
			}
			catch(NumberFormatException e) {
				
			}
			catch(NullPointerException e) {
				System.out.println("Client invalide avec cet id : " + this.id +"");
			}
		} 
		
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
	
}
