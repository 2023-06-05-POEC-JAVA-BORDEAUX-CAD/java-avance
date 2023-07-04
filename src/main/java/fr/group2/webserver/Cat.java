package fr.group2.webserver;

import jakarta.annotation.ManagedBean;


public class Cat {
	String name;
	Integer id;
	
	public Cat() {}
	
	public Cat(Integer id, String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
