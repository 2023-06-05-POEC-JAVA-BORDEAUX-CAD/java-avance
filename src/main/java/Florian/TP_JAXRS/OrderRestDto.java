package Florian.TP_JAXRS;

public class OrderRestDto {
	private Integer id;
	private String typePresta;
	private String designation;
	private Integer clientId;
	private Integer nbDays;
	private Integer unitPrice;
	private Integer state;

	// Constructeur
	public OrderRestDto() {

	}

	public OrderRestDto(Integer id, String typePresta, String designation, Integer clientId, Integer nbDays,
			Integer unitPrice, Integer state) {
		this.id = id;
		this.typePresta = typePresta;
		this.designation = designation;
		this.clientId = clientId;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
	}

	// Getters Setters
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	// To entity
	public OrderRestDto toEntity() {
		OrderRestDto entity = new OrderRestDto();
		entity.setId(this.id);
		entity.setTypePresta(this.typePresta);
		entity.setDesignation(this.designation);
		entity.setClientId(this.clientId);
		entity.setNbDays(this.nbDays);
		entity.setUnitPrice(this.unitPrice);
		entity.setState(this.state);
		return entity;
	}
}
