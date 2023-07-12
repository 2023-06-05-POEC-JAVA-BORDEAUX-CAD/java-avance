package fr.noellie.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private ClientJPA client;

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

	public ClientJPA getClient() {
		return client;
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

	public void setClient(ClientJPA client) {
		this.client = client;
	}

	public void setState(EtatCommande state) {
		this.state = state;
	}

}