package fr.fabien.tpjsf.jpamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "type_presta")
	private String typePresta;
	
	private String designation;
	
	@Column(name = "client_id")
	private Integer clientId;
	
	@Column(name = "nb_days")
	private Integer nbDays;
	
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "unit_price")
	private Integer unitPrice;

	private Byte state;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "client_id")
	private Client client;
	
	
	// Getter / Setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType_presta() {
		return typePresta;
	}

	public void setType_presta(String type_presta) {
		this.typePresta = type_presta;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getClient_id() {
		return clientId;
	}

	public void setClient_id(Integer client_id) {
		this.clientId = client_id;
	}

	public Integer getNb_days() {
		return nbDays;
	}

	public void setNb_days(Integer nb_days) {
		this.nbDays = nb_days;
	}

	public Integer getUnit_price() {
		return unitPrice;
	}

	public void setUnit_price(Integer unit_price) {
		this.unitPrice = unit_price;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}


}
