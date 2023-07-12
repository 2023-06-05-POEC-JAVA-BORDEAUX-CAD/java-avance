package fr.maboite.ebru.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class OrderJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="type_presta")
	private String type_presta;

	@Column(name = "designation")
	private String designation;

	@Column(name = "client_id")
	private Integer client_id;
	
	@Column(name="state")
	@Enumerated(EnumType.ORDINAL) // ici on choisit ORDINAL car on veut recuperer un Integer recupere l index des options: ici: 0 , 1 ou 2
	private EtatCommande etat; // EtatCommande est un primitif
	

	public Integer getId() {
		return id;
	}

	public EtatCommande getEtat() {
		return etat;
	}

	public void setEtat(EtatCommande etat) {
		this.etat = etat;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type_presta;
	}

	public void setType(String type) {
		this.type_presta = type;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

}
