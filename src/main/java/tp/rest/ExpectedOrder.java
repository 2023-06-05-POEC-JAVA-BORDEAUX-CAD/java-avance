package tp.rest;

import tp.jpa.OrderModel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ExpectedOrder {
	@NotNull
	@Size(min = 3, max = 40)
	private String typePresta;

	@NotNull
	@Size(min = 3, max = 90)
	private String designation;

	@NotNull
	@Min(0)
	private Integer clientId;

	@Min(0)
	private Integer nbDays;

	@Min(0)
	private Integer unitPrice;

	@Pattern(regexp = "(ACTIVE|INACTIVE)", message = "unknown value for OrderModel.State enum (ACTIVE or INACTIVE)")
	private String state;

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

	public OrderModel tOrderModel() {
		OrderModel order = new OrderModel();
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