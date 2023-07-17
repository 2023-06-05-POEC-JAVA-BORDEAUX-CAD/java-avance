package fr.boite.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MonPremierRestDto {
	public MonPremierRestDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public MonPremierRestDto() {
		super();
	}


	private Long id;
	@NotEmpty()
	@NotNull(message = "le nom ne doit pas etre null")
	@Size(min=5, max=20)
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
