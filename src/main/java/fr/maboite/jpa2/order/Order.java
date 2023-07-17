package fr.maboite.jpa2.order;

import fr.maboite.jpa2.client.Client;
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

	@Column(name = "nb_days")
	private Integer nbDays;

	@Column(name = "unit_price")
	private Integer unitPrice;
	private Integer state;

	// TEST
	@Column(name = "client_id")
	private Integer clientId;
	//

	public OrderDto fromOrderToDtoOrder() {
		OrderDto orderDto = new OrderDto();
		orderDto.setId(this.id);
		orderDto.setTypePresta(this.typePresta);
		orderDto.setDesignation(this.designation);
		orderDto.setNbDays(this.nbDays);
		orderDto.setUnitPrice(this.unitPrice);
		orderDto.setState(this.state);
		return orderDto;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Column(name = "client_id")
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

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

//	public int getClient_id() {
//		return client_id;
//	}
//
//	public void setClient_id(int client_id) {
//		this.client_id = client_id;
//	}

	public int getNbDays() {
		return nbDays;
	}

	public void setNbDays(Integer nbDays) {
		this.nbDays = nbDays;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	// TEST
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	//

}
