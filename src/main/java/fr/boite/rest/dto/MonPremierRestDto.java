package fr.boite.rest.dto;

public class MonPremierRestDto {
	public MonPremierRestDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public MonPremierRestDto() {
		super();
	}


	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
