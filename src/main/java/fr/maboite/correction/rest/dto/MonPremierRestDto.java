package fr.maboite.correction.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MonPremierRestDto {

	private Long id;

	@NotNull
	@Size(min = 5, max = 20)
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

	@Override
	public String toString() {
		return "MonPremierRestDto [id=" + id + ", name=" + name + "]";
	}

}
