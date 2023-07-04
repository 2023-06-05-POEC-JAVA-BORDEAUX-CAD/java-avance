package fr.groupe3.TPpojo;

public class Pojo {
	private Integer id;
	private String name;

	public Pojo() {
	}
	
	public Pojo(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getters
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setPojo(String name) {
		this.name = name;
	}
}