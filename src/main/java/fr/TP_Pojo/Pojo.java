package fr.TP_Pojo;

public class Pojo {
	private int id;
	private String pojo;

	// Constructeur
	public Pojo() {

	}

	public Pojo(Integer id, String pojo) {
		this.id = id;
		this.pojo = pojo;
	}

	// Getter
	public int getId() {
		return id;
	}

	public String getName() {
		return pojo;
	}

	// Setter
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.pojo = name;
	}
}
