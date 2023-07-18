package fr.groupe2.tpapi.dto;

import fr.groupe2.tpapi.model.Order;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class OrderDto {
	private Integer id;
	@NotEmpty(message="TypePresta ne peut être null ou vide")
	private String typePresta;
	@NotEmpty(message=" ne peut être null ou vide")
	private String designation;
	@NotNull
	private Integer clientId;
	@Positive
	private Integer nbDays;
	@PositiveOrZero
	private Float unitPrice;
	private Integer state;
	
	
	/*
	 * Constructors
	 */
	public OrderDto() {
	}
	
	public OrderDto(Order order) {
		this.id = order.getId();
		this.typePresta = order.getTypePresta();
		this.designation = order.getDesignation();
		this.clientId = order.getClient().getId();
		this.nbDays = order.getNbDays();
		this.unitPrice = order.getUnitPrice();
		this.state = order.getState();
	}
	
	public OrderDto(Integer id, String typePresta, String designation, Integer clientId, Integer nbDays, Float unitPrice, Integer state) {
		this.id = id;
		this.typePresta = typePresta;
		this.designation = designation;
		this.clientId = clientId;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
	}	
	
	/**
	 * Getters and Setters
	 */
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Integer getNbDays() {
		return nbDays;
	}
	public void setNbDays(Integer nbDays) {
		this.nbDays = nbDays;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	// Methods
	public Order toEntity() {
		Order entity = new Order();
		entity.setTypePresta(this.getTypePresta());
		entity.setDesignation(this.getDesignation());
		entity.setNbDays(this.getNbDays());
		entity.setUnitPrice(this.getUnitPrice());
		entity.setState(this.getState());
		return entity;
	}	
}
