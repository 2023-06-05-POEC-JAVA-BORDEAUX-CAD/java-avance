package fr.fabien.rest.tpfilrouge.dto;

import fr.fabien.tpjsf.jpamodel.Order;

/**
 * Dto infos clients utilise l'Api Rest
 */
public class OrderDto {

	private Long id;
	private String typePresta;
	private String designation;
	private Long clientId;
	private Integer nbDays;
	private Integer unitPrice;
	private Boolean state;

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

	public Order toEntity() {
		Order entity = new Order();
		entity.setId(this.id);
		entity.setType_presta(this.typePresta);
		entity.setDesignation(this.designation);
		entity.setClientId(this.clientId);
		entity.setNb_days(this.nbDays);
		entity.setUnit_price(this.unitPrice);

		return entity;
	}

}
