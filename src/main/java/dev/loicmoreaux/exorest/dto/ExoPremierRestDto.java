package dev.loicmoreaux.exorest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ExoPremierRestDto {
	
	@NotNull(message="id ne peut être nul")
	private Integer id;
	
	@NotEmpty(message="name ne peut être vide")
	@Size(min=3, max=20, message="name doit avoir une longueur comprise entre 3 et 20")
	private String name;
	
	public ExoPremierRestDto() {}
	
	public ExoPremierRestDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
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
