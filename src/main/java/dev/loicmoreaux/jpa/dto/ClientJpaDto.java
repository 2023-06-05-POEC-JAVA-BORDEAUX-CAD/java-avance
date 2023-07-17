package dev.loicmoreaux.jpa.dto;

import dev.loicmoreaux.jpa.model.ClientJpa;
import jakarta.validation.constraints.NotEmpty;

public class ClientJpaDto {
	
	private Integer id;
	@NotEmpty(message= "CompanyName ne peut être null ou vide")
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
	
	/**
	 * Constructors
	 */
	public ClientJpaDto() {}
	
	public ClientJpaDto(Integer id, String companyName, String firstName, String lastName, String email, String phone,
			String address, String zipCode, String city, String country, Boolean state) {
		this.id = id;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.state = state;
	}
	
	public ClientJpaDto(ClientJpa client) {
		this.id = client.getId();
		this.companyName = client.getCompanyName();
		this.firstName = client.getFirstName();
		this.lastName = client.getLastName();
		this.email = client.getEmail();
		this.phone = client.getPhone();
		this.address = client.getAddress();
		this.zipCode = client.getZipCode();
		this.city = client.getCity();
		this.country = client.getCountry();
		this.state = client.getState();
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
	
}
