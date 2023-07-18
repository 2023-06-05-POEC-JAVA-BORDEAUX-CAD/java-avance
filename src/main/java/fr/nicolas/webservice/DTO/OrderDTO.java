package fr.nicolas.webservice.DTO;

import fr.nicolas.jpa.Entity.Client;
import fr.nicolas.jpa.Entity.Order;
import fr.nicolas.jpa.Enum.Status;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;



public class OrderDTO {

	@NotEmpty
	private Client client;
	private Integer id;
	@NotEmpty
	@Size(min=4)
	private String typePresta;
	@NotEmpty
	@Size(min=4)
	private String designation;
    private Status status;
    
    public OrderDTO entityTODTO(Order order) {
    	OrderDTO orderDTO = new OrderDTO();
    	orderDTO.setClient(order.getClient());
    	orderDTO.setId(order.getId());
    	orderDTO.setTypePresta(order.getTypePresta());
    	orderDTO.setDesignation(order.getDesignation());
    	orderDTO.setStatus(order.getStatus());
    	
    	return orderDTO;
    }
    
    
    public Order dtoToEntity(OrderDTO orderDTO) {
    	Order order = new Order();
    	order.setClient(orderDTO.getClient());
    	order.setId(orderDTO.getId());
    	order.setTypePresta(orderDTO.getTypePresta());
    	order.setDesignation(orderDTO.getDesignation());
    	order.setStatus(orderDTO.getStatus());
    	
    	return order;
    }
    
    
    
	public Client getClient() {
		return client;
	}
	public Integer getId() {
		return id;
	}
	
	public String getTypePresta() {
		return typePresta;
	}
	
	
	public String getDesignation() {
		return designation;
	}
	
	public Status getStatus() {
		return status;
	}
	
	
	public void setClient(Client client) {
		this.client = client;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
