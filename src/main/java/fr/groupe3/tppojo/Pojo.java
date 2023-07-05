package fr.groupe3.tppojo;

public class Pojo {
	private Integer id;
	private String pojo;

	public Pojo() {
	}
	
	public Pojo(Integer id, String pojo) {
		this.id = id;
		this.pojo = pojo;
	}

	// Getters
	public Integer getId() {
		return id;
	}

	public String getPojo() {
		return pojo;
	}

	// Setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setPojo(String pojo) {
		this.pojo = pojo;
	}
}