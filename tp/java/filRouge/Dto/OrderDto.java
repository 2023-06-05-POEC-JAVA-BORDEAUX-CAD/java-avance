package filRouge.Dto;

import java.util.List;

import filRouge.model.Order;
import filRouge.model.Product;
import jakarta.validation.constraints.NotNull;

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
private List<Product> productList;

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

public List<Product> getProductList() {
	return productList;
}

public void setProductList(List<Product> productList) {
	this.productList = productList;
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

