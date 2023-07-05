package fr.groupe2.tpcrm.model;

public class Order {
private Integer id;
private String type_presta;
private String designation;
private Integer nb_days;
private Integer unit_price;
private Integer state;


public Order(Integer id, String type_presta, String designation, Integer nb_days, Integer unit_price, Integer state) {
	super();
	this.id = id;
	this.type_presta = type_presta;
	this.designation = designation;
	this.nb_days = nb_days;
	this.unit_price = unit_price;
	this.state = state;
}
public Order() {
	
};

public String getType_presta() {
	return type_presta;
}
public void setType_presta(String type_presta) {
	this.type_presta = type_presta;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public Integer getNb_days() {
	return nb_days;
}
public void setNb_days(Integer nb_days) {
	this.nb_days = nb_days;
}
public Integer getUnit_price() {
	return unit_price;
}
public void setUnit_price(Integer unit_price) {
	this.unit_price = unit_price;
}
public Integer getState() {
	return state;
}
public void setState(Integer state) {
	this.state = state;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
;

}
