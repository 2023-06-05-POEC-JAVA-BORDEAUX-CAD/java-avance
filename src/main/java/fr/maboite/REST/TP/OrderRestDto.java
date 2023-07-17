package fr.maboite.REST.TP;

import fr.maboite.exoJPA.Order.OrderEntity;

public class OrderRestDto {
	
	private Integer id;
	private String typePresta;
	private Integer clientId;
	private String designation;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypePresta() {
		return typePresta;
	}
	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public OrderRestDto(Integer id, String typePresta, Integer clientId, String designation) {
		
		this.id = id;
		this.typePresta = typePresta;
		this.clientId = clientId;
		this.designation = designation;
	}
	
	
	public OrderRestDto() {
		
	}
	
	public OrderEntity toEntity() {
		OrderEntity entity = new OrderEntity();
		//entity.setId(this.id);
		entity.setDesignation(this.designation);
		entity.setClientId(this.clientId);
		entity.setTypePresta(this.typePresta);
		return entity;
	}
	
}
