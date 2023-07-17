package tp.rest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import tp.jpa.OrderModel;
import jakarta.validation.constraints.NotNull;

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

	@Min(0)
	@Max(1)
	private Integer state;

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

	public OrderModel tOrderModel() {
		OrderModel order = new OrderModel();
		order.setTypePresta(typePresta);
		order.setDesignation(designation);
		order.setClientId(clientId);
		order.setNbDays(nbDays);
		order.setUnitPrice(unitPrice);
		switch (state) {
			case 0:
				order.setState(OrderModel.State.ACTIVE);
				break;
			case 1:
				order.setState(OrderModel.State.INACTIVE);
				break;
		}
		return order;
	}
}