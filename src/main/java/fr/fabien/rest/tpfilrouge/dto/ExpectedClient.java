package fr.fabien.rest.tpfilrouge.dto;

import fr.fabien.tpjsf.jpamodel.ClientModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ExpectedClient {
	@Positive
	private Integer id;

	@NotNull
	@Size(min = 3, max = 40)
	private String companyName;

	@NotNull
	@Pattern(regexp = "[a-zA-Z]{3,40} [a-zA-Z]{3,40}", message = "Invalid name format (<FirstName> <LastName>) or Character length (min:3 max:40")
	private String name;

//	@NotNull
//	@Size(min = 3, max = 40)
//	private String firstName;

//	@NotNull
//	@Size(min = 3, max = 40)
//	private String lastName;

	@NotNull
	@Email
	@Size(min = 3, max = 90)
	private String email;

	@NotNull
	@Size(min = 10, max = 10)
	private String phone;

	@NotNull
	@Size(min = 3, max = 255)
	private String adress;

	@NotNull
	@Size(min = 3, max = 10)
	private String zipCode;

	@NotNull
	@Size(min = 3, max = 40)
	private String city;

	@NotNull
	@Size(min = 3, max = 60)
	private String country;

	@NotNull
	@Pattern(regexp = "(CANCELED|OPTION|CONFIRMED)", message = "unknown value for ClientModel.State enum (CANCELED, OPTION or CONFIRMED)")
	private String state;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ClientModel toClientModel() {
		ClientModel client = new ClientModel();
		if (id != null) {
			client.setId(id);
		}
		client.setCompanyName(companyName);
		String[] splitedName = name.split(" ");
		client.setFirstName(splitedName[0]);
		client.setLastName(splitedName[1]);
		client.setEmail(email);
		client.setPhone(phone);
		client.setAdress(adress);
		client.setZipCode(zipCode);
		client.setCity(city);
		client.setCountry(country);
		switch (state) {
		case "CANCELED":
			client.setState(ClientModel.State.CANCELED);
			break;
		case "OPTION":
			client.setState(ClientModel.State.OPTION);
			break;
		case "CONFIRMED":
			client.setState(ClientModel.State.CONFIRMED);
			break;
		}
		return client;
	}
}