package fr.fabien.rest.tpfilrouge;

import fr.fabien.jpa.model.Order;
/**
 * Dto infos clients
 * utilise l'Api Rest
 */
public class OrdersRestDto {
	
	private Long id;
	private String typePresta;
	private String designation;
	private Long clientId;
	private Integer nbDays;
	private Integer unitPrice;
	private Boolean state;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypePresta() {
		return typePresta;
	}
	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Integer getNbDays() {
		return nbDays;
	}
	public void setNbDays(Integer nbDays) {
		this.nbDays = nbDays;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	
public Order toEntity() {
	Order entity = new Order();
	entity.setId(this.id);
	entity.setTypePresta(this.typePresta);
	entity.setDesignation(this.designation);
	entity.setClientId(this.clientId);
	entity.setNbDays(this.nbDays);
	entity.setUnitPrice(this.unitPrice);
	
	return entity;
}
	
	
}
