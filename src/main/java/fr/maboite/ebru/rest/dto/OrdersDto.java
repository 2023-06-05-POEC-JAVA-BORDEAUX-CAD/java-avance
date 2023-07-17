package fr.maboite.ebru.rest.dto;

import fr.maboite.ebru.jpa.entity.EtatCommande;
import fr.maboite.ebru.jpa.entity.OrderJPA;
import fr.maboite.ebru.jpa.entity.OrderJpaService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotEmpty;

@Stateless
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
	

	public OrderJPA toOrderJPA(OrdersDto dto) {
		OrderJPA order = new OrderJPA();
		order.setType(dto.getTypePresta());
		order.setDesignation(dto.getDesignation());
//		order.setClient(dto.GET);
		order.setEtat(EtatCommande.CANCELLED);
		
		return order;
	} 
	
}
