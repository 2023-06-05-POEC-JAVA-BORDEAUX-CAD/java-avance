package fr.nicolas.jpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.nicolas.jpa.Enum.Status;

@Entity
@Table(name="orders")
public class Order {

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="client_id")
	@JsonIgnoreProperties("orders")
	private Client client;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="type_presta")
	private String typePresta;
	
	private String designation;

	@Enumerated(EnumType.STRING)
    private Status status;
	
	public Integer getId() {
		return id;
	}

	public String getTypePresta() {
		return typePresta;
	}

	public String getDesignation() {
		return designation;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
