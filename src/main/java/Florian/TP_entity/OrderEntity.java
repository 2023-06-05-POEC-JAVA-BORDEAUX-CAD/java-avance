package Florian.TP_entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/*@Enumerated(EnumType.STRING)
	@Column(name = "type_presta")
	private OrderEnum typePresta;
	*/
	
	@Column(name = "type_presta", length = 40, nullable = false)
	private String typePresta;	

	@Column(length = 90, nullable = false)
	private String designation;

	@Column(name = "client_id", nullable = false)
	private Integer clientId;

	@Column(name = "nb_days")
	private Integer nbDays;

	@Column(name = "unit_price")
	private Integer unitPrice;

	private Integer state;

	// Getters Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	/*public OrderEnum getTypePresta() {
		return typePresta;
	}

	public void setTypePresta(OrderEnum typePresta) {
		this.typePresta = typePresta;
	}*/
	
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

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
