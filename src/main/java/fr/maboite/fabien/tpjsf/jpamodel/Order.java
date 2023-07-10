package fr.maboite.fabien.tpjsf.jpamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name= "orders")

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type_presta;
	private String designation;
	private Integer client_id;
	private Integer nb_days;
	private Integer unit_price;
	private Byte state;
	
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id; 
	}

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

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
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

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	
}
