package fr.boite.rest.dto;

public class OrderRestDto {
	private Integer id;
    private String typePresta;
    private String designation;
    private Integer clientId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypePresta() {
		return typePresta;
	}
	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
}
