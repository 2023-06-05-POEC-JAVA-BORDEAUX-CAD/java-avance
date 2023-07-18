package fr.groupe3.tpfilrouge.clients;

import jakarta.ejb.Stateless;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Stateless
public class ClientDto {

	/**
	 * Dto de présentation des Clients par REST
	 */

	@NotNull
	private Long id;

	@Size(min = 3)
	private String companyName;

	@NotNull
	@Size(min = 3)
	private String firstName;

	@NotNull
	@Size(min = 3)
	private String lastName;

	@NotNull
	@Email
	private String email;

	@NotNull
	private String phone;

	@NotNull
	private String adress;

	@NotNull
	private String zipCode;

	@NotNull
	private String city;

	@Size(min = 3)
	private String country;

	@NotNull
	private Integer state;
	//private EtatClient state;

	public ClientDto() {

	}

	public ClientDto(Client client) {
		this.id = client.getId();
		this.adress = client.getAdress();
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	/*public EtatClient getState() {
		return state;
	}

	public void setState(EtatClient state) {
		this.state = state;
	}
	*/
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
	public Client toEntity() {
		Client entity = new Client();
		entity.setId(this.id);
		entity.setAdress(this.adress);
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
