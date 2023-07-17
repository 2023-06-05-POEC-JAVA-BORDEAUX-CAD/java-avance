package Florian.TP_JAXRS;

import jakarta.validation.constraints.NotNull;

public class MonPremierRestDto {

	private int id;
	@NotNull
	private String name;

	// Constructeur

	public MonPremierRestDto() {

	}

	public MonPremierRestDto(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getters Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
