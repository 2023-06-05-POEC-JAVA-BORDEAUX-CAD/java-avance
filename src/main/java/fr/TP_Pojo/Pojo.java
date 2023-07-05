package fr.TP_Pojo;

public class Pojo {

	private Integer id;
	private String pojo;

	public Pojo(Integer id, String pojo) {
		this.id = id;
		this.pojo = pojo;
	}


	public Pojo() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPojo() {
		return pojo;
	}

	public void setPojo(String pojo) {
		this.pojo = pojo;
	}

}
