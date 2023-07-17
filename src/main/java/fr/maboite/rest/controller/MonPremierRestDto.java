package fr.maboite.rest.controller;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MonPremierRestDto {
	
	private Long id;
	
	@NotNull
	//@Size(min=3 ,max=10)
	private  String name;
	
	
	public MonPremierRestDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public MonPremierRestDto() {
		super();
	}


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
