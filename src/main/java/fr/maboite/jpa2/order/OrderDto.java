package fr.maboite.jpa2.order;

public class OrderDto {

	private Long id;
	private String typePresta;
	private String designation;
	private Integer clientId;
	private Integer nbDays;
	private Integer unitPrice;
	private Integer state;

	public OrderDto(Long id, String typePresta, String designation, Integer clientId, Integer nbDays, Integer unitPrice,
			Integer state) {
		super();
		this.id = id;
		this.typePresta = typePresta;
		this.designation = designation;
		this.clientId = clientId;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
	}

	public Order fromOrderDtoToOrder() {
		Order order = new Order();
		order.setId(this.id);
		order.setTypePresta(this.typePresta);
		order.setDesignation(this.designation);
		order.setNbDays(this.nbDays);
		order.setUnitPrice(this.unitPrice);
		order.setState(this.state);

		return order;
	}

	public OrderDto() {
		super();
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

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

}
