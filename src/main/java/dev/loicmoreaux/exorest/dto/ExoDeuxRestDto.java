package dev.loicmoreaux.exorest.dto;

public class ExoDeuxRestDto {
	private Integer id;
	private String description;
	private Boolean state;
	
	
	/**
	 * Constructors
	 */
	public ExoDeuxRestDto() {
		super();
	}

	/**
	 * @param id
	 * @param description
	 * @param state
	 */
	public ExoDeuxRestDto(Integer id, String description, Boolean state) {
		super();
		this.id = id;
		this.description = description;
		this.state = state;
	}
	
	/**
	 * Getters and Setters
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	
}
