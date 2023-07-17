package fr.maboite.REST;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class monDto {
	
	@NotNull
	private long id;
	
	@Size(min=3, max=5)
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
