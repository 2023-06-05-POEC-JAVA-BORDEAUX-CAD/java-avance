package dev.loicmoreaux.jpa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "type_presta", nullable=false)
	private String typePresta;
	
	@Column(nullable=false)
	private String designation;
	
	@Column(name= "client_id", nullable=false)
	private Integer clientId;
	
	@Basic(optional = true) // Annotation facultative
	@Column(name= "nb_days")
	private Integer nbDays = null;
	
	@Basic(optional = true)
	@Column(name= "unit_price")
	private Float unitPrice = null;
	
	@Basic(optional = true)
	private Integer state = null;
	
	
	/*
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
}
