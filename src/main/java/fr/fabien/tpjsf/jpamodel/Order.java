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
	@ManyToOne(fetch = FetchType.LAZY)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type_presta")
	private String typePresta;

	private String designation;

	@Column(name = "client_id")
	private Long clientId;

	// @Column(name = "client_id")
	// private Client client;

	@Column(name = "nb_days")
	private Integer nbDays;

	@Column(name = "unit_price")
	private Integer unitPrice;

	private Byte state;

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

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
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

	// public Client getClient() {return client;}

	// public void setClient(Client client) {
	// this.client = client;}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

}
