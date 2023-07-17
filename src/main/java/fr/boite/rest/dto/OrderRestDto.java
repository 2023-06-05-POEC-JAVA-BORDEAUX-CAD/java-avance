package fr.boite.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class OrderRestDto {
	@NotEmpty()
	private Integer id;
	private String typePresta;
	@NotEmpty()
	@NotNull(message = "le designation ne doit pas etre null ou vide")
	@Size(min=5, max=50)
	private String designation;
	private Integer clientId;
/*
 * Getters and Setters
 */
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
}
