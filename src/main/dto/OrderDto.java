package fr.maboite.dto;

import fr.maboite.correction.jpa.model.Client;
import fr.maboite.correction.jpa.model.Order;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class OrderDto {
private Integer id;
@NotNull
//@NotEmpty
//@Size(min = 5, max = 15)
private String typePresta;
private String designation;
private Integer clientId;
private int nbDays;
private int unitPrice;
private int state;

public Order toEntity() {
	Order entity = new Order();
	
	entity.setId(this.id);
	entity.setDesignation(this.designation);
	//entity.setClientId(this.clientId);
	entity.setNbDays(this.nbDays);
	entity.setUnitPrice(this.unitPrice);
	entity.setState(this.state);
	return entity;
	
}

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

public int getNbDays() {
	return nbDays;
}
public void setNbDays(int nbDays) {
	this.nbDays = nbDays;
}
public int getUnitPrice() {
	return unitPrice;
}
public void setUnitPrice(int unitPrice) {
	this.unitPrice = unitPrice;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public OrderDto() {
	super();
}








}
