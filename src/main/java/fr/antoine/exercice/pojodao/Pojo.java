package fr.antoine.exercice.pojodao;

public class Chien {

	private Integer id;

	private String name;

	private Boolean valid;

	public Chien() {
		super();
	}

	public Chien(Integer id, String name, Boolean valid) {
		this.id = id;
		this.name = name;
		this.valid = valid;
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

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

}
