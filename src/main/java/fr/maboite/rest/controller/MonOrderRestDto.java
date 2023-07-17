package fr.maboite.rest.controller;

import jakarta.ejb.Stateless;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Stateless
public class MonOrderRestDto {
	
	private Long id;
	
	@NotNull
	private String typePresta;
	
	private String designation;
	
	
	private Integer clientId;
	
		
	public MonOrderRestDto(Long id, String typePresta, String designation, Integer clientId) {
		super();
		this.id = id;
		this.typePresta = typePresta;
		this.designation = designation;
		this.clientId = clientId;
	}
	public MonOrderRestDto() {
		super();
	}
	
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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

	

}
