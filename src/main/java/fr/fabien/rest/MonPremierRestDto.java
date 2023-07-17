package fr.fabien.rest;

public class MonPremierRestDto {
	private int id;
	private String name;

	public MonPremierRestDto(int id, String name) {
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