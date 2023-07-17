package fr.maboite.ebru.rest.dto;

import fr.maboite.ebru.jpa.entity.EtatCommande;
import jakarta.validation.constraints.NotEmpty;


public class OrdersDto {

	private Integer id;
	
	@NotEmpty
	private String typePresta;

	private Integer clientId;
	
	@NotEmpty
	private String designation;
	
	private EtatCommande etat;
	

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

	public EtatCommande getEtat() {
		return etat;
	}

	public void setEtat(EtatCommande etat) {
		this.etat = etat;
	} 
	
	
}
