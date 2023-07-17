package tp.rest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import tp.jpa.ClientModel;
import jakarta.validation.constraints.NotNull;

public class ExpectedClient {
	@NotNull
	@Size(min = 3, max = 40)
	private String companyName;

	@NotNull
	@Size(min = 3, max = 40)
	private String firstName;

	@NotNull
	@Size(min = 3, max = 40)
	private String lastName;

	@NotNull
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
	@Min(0)
	@Max(2)
	private Integer state;

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
