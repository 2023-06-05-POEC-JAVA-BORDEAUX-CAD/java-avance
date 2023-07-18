package fr.fabien.rest.tpfilrouge.dto;

import fr.fabien.tpjsf.jpamodel.OrderModel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ExpectedOrder {
	@Positive
	private Integer id;

	@NotNull
	@Size(min = 3, max = 40)
	private String typePresta;

	@NotNull
	@Size(min = 3, max = 90)
	private String designation;

	@NotNull
	@Min(0)
	private Integer clientId;

	@Min(1)  // ou @Positive >> il y obligatoirement 1 jour ou +
	private Integer nbDays;

	@Min(0) // ou 	@PositiveOrZero >> le prix ne peut pas etre negatif (0 ou +)
	private Integer unitPrice;

	@Pattern(regexp = "(ACTIVE|INACTIVE)", message = "unknown value for OrderModel.State enum (ACTIVE or INACTIVE)")
	private String state;

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

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public OrderModel toOrderModel() {
		OrderModel order = new OrderModel();
		if (id != null) {
			order.setId(id);
		}
		order.setTypePresta(typePresta);
		order.setDesignation(designation);
		order.setClientId(clientId);
		order.setNbDays(nbDays);
		order.setUnitPrice(unitPrice);
		switch (state) {
			case "ACTIVE":
				order.setState(OrderModel.State.ACTIVE);
				break;
			case "INACTIVE":
				order.setState(OrderModel.State.INACTIVE);
				break;
		}
		return order;
	}
}