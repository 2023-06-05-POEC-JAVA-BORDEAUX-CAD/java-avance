package fr.noellie.rest.dto;

import fr.noellie.jpa.model.ClientJPA;
import fr.noellie.jpa.model.EtatCommande;
import fr.noellie.jpa.model.OrderJPA;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Dto de présentation des Orders par REST
 */
public class OrderRestDto {
	@NotNull
	private Long id;

	@NotEmpty
	private String typePresta;

	private String designation;

	@NotNull
	private ClientJPA client;

	@NotNull
	private EtatCommande state;

	public Long getId() {
		return id;
	}

	public String getTypePresta() {
		return typePresta;
	}

	public String getDesignation() {
		return designation;
	}

	public ClientJPA getClient() {
		return client;
	}

	public EtatCommande getState() {
		return state;
	}

	public OrderRestDto() {

	}

	public OrderRestDto(OrderJPA order) {
		this.id = order.getId();
		this.typePresta = order.getTypePresta();
		this.designation = order.getDesignation();
		this.client = order.getClient();
		this.state = order.getState();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setClient(ClientJPA client) {
		this.client = client;
	}

	public void setState(EtatCommande state) {
		this.state = state;
	}

	public OrderJPA toEntity() {
		OrderJPA entity = new OrderJPA();
		entity.setId(this.id);
		entity.setTypePresta(this.typePresta);
		entity.setDesignation(this.designation);
		entity.setClient(this.client);
		entity.setState(this.state);
		return entity;
	}

}