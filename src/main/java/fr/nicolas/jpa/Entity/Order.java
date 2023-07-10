package fr.nicolas.jpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="type_presta")
	private String typePresta;
	
	private String designation;
	
	@Column(name="client_id")
	private Integer clienID;

	public Integer getId() {
		return id;
	}

	public String getTypePresta() {
		return typePresta;
	}

	public String getDesignation() {
		return designation;
	}

	public Integer getClienID() {
		return clienID;
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

	public void setClienID(Integer clienID) {
		this.clienID = clienID;
	}
	
}
