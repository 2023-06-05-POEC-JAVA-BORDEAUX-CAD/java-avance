package fr.noellie.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MonPremierRestDto {

	private Long id;

	@NotNull
	@Size(min=3)
	private String name;
	
	public MonPremierRestDto() {
	}

	public MonPremierRestDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}