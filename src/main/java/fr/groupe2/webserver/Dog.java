package fr.groupe2.webserver;

import jakarta.ejb.Stateless;

@Stateless
public class Dog {
	private String name;
	private Integer id;
	
	public Dog() {
		this.name = "Chien";
		this.id = 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
