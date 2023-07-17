package fr.nicolas.webservice.DAOMoke;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class EntityDAOMoke {

	
	private Integer id;
	
	@NotEmpty
	@Size(min=4, max=12)
	private String name;
	
	
	public EntityDAOMoke() {}
	
	public EntityDAOMoke(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
