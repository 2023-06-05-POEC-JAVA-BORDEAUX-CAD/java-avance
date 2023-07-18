package fr.maboite.correction.rest.dto;

import fr.maboite.correction.jpa.model.Order;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class OrderRestDto {

	private Long id;

	@NotNull
	private String typePresta;

	@NotNull
	private String designation;

	@NotNull
	private Long clientId;

	@Positive
	private Integer nbDays;

	@PositiveOrZero
	private Integer unitPrice;

	private Boolean state;

	public OrderRestDto() {

	}

	public OrderRestDto(Order order) {
		this.id = order.getId();
		this.designation = order.getDesignation();
		this.clientId = order.getClient() != null ? order.getClient().getId() : null;
		this.nbDays = order.getNbDays();
		this.unitPrice = order.getUnitPrice();
		this.typePresta = order.getTypePresta();
		this.state = order.getState();
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

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
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

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "OrderRestDto [id=" + id + ", typePresta=" + typePresta + ", designation=" + designation + ", clientId="
				+ clientId + ", nbDays=" + nbDays + ", unitPrice=" + unitPrice + ", state=" + state + "]";
	}

	public Order toEntity() {
		Order order = new Order();
		order.setId(this.id);
		order.setDesignation(this.designation);
		order.setNbDays(this.nbDays);
		order.setState(this.state);
		order.setTypePresta(this.typePresta);
		order.setUnitPrice(this.unitPrice);
		return order;
	}

}