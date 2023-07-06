package fr.maboite.correction.pojojsonservlet.pojo;

/**
 * POJO :Plain Old Java Object.
 * CLasse avec un constructeur sans argument, et 
 * un getter et un setter par attribut de la classe.
 */
public class Pojo {

	private Integer id;

	private String name;

	private Boolean valid;

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
