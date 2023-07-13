package dev.loicmoreaux.exorest.dto;

public class ExoPremierRestDto {
	
	private Integer id;
	private String name;
	
	public ExoPremierRestDto() {}
	
	public ExoPremierRestDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
