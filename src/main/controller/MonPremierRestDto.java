package fr.maboite.correction.rest.controller;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MonPremierRestDto {
private int id;
@NotNull
@NotEmpty
@Size(min = 5, max = 15)
private String name;
public MonPremierRestDto() {
	super();
}
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
