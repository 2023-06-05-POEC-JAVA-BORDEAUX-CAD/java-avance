package fr.maboite.correction.rest.dto;

import fr.maboite.correction.jpa.model.Client;

/**
 * Dto de présentation des Clients par REST
 */
public class ClientRestDto {
	
	private Long id;
	private String companyName;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String zipCode;
	private String city;
	private String country;
	private Boolean state;
	
	public ClientRestDto() {
		
	}

	public ClientRestDto(Client client) {
		this.id = client.getId();
		this.address = client.getAddress();
		this.city = client.getCity();
		this.companyName = client.getCompanyName();
		this.country = client.getCountry();
		this.email = client.getEmail();
		this.firstName = client.getFirstName();
		this.lastName = client.getLastName();
		this.phone = client.getPhone();
		this.zipCode = client.getZipCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Client toEntity() {
		Client entity = new Client();
		entity.setId(this.id);
		entity.setAddress(this.address);
		entity.setCity(this.city);
		entity.setCompanyName(this.companyName);
		entity.setCountry(this.country);
		entity.setEmail(this.email);
		entity.setFirstName(this.firstName);
		entity.setLastName(this.lastName);
		entity.setPhone(this.phone);
		entity.setState(this.state);
		entity.setZipCode(this.zipCode);
		return entity;
	}

}
