package dev.loicmoreaux.pojoservlet;

public class Pojo {

	private String name;
	private Integer id;

	public Pojo() {
	}

	public Pojo(Integer id, String name) {
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