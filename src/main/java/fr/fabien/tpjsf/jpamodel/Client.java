package fr.fabien.tpjsf.jpamodel;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")

public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	private String email;

	private Integer phone;

	private String adress;

	@Column(name = "zip_code")
	private Integer zipCode;

	private String city;

	private String country;

	private Byte state;

	// Getter
	public Long getId() {
		return id;
	}

	public String getCompany_Name() {
		return companyName;
	}

	public String getFirst_Name() {
		return firstName;
	}
	public String getLast_Name() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Integer getPhone() {
		return phone;
	}

	public String getAdress() {
		return adress;
	}

	public Integer getZip_Code() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public Byte getState() {
		return state;
	}

	// Setter
	public void setId(Long id) {
		this.id = id;
	}

	public void setCompany_Name(String company_Name) {
		this.companyName = company_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.firstName = first_Name;
	}

	public void setLast_Name(String first_Name) {
		this.lastName = first_Name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setZipCode(Integer zip_Code) {
		this.zipCode = zip_Code;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public List<Client> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
