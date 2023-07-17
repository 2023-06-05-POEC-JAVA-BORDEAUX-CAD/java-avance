package fr.fabien.rest;

import jakarta.validation.constraints.NotNull;

public class MonPremierRestDto {
	@NotNull(message = "Id ne peut pas etre null")
	private Integer id;
	@NotNull(message = "Le nom ne peut pas etre Null")
	private String name;

	public MonPremierRestDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public MonPremierRestDto() {
		super();
		
	}

	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}