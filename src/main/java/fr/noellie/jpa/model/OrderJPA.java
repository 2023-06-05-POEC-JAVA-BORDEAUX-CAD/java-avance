package fr.noellie.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "type_presta")
	private String typePresta;

	private String designation;

	@Column(name = "client_id")
	private Integer clientId;

	@Enumerated(EnumType.ORDINAL)
	private EtatCommande state;

	public Long getId() {
		return Id;
	}

	public String getTypePresta() {
		return typePresta;
	}

	public String getDesignation() {
		return designation;
	}

	public Integer getClientId() {
		return clientId;
	}

	public EtatCommande getState() {
		return state;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public void setState(EtatCommande state) {
		this.state = state;
	}

}