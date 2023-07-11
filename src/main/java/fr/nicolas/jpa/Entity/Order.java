package fr.nicolas.jpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import fr.nicolas.jpa.Enum.Status;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="type_presta")
	private String typePresta;
	
	private String designation;
	
	@Column(name="client_id")
	private Integer clientId;	

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

	public Integer getClientId() {
		return clientId;
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

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
