package fr.maboite.jsf.controller;

public class ClientFormBean {

  private Integer id;
  private String companyName;
  private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String adress;
	private String zipCode;
	private String city;
	private String country;
	private Integer state;
 

  //Getters
  public Integer getId() {
    return id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getAdress() {
    return adress;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhone() {
    return phone;
  }

  public Integer getState() {
    return state;
  }

  public String getZipCode() {
    return zipCode;
  }
  // Setters
  public void setId(Integer id) {
    this.id = id;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public void setCity(String city) {
    this.city = city;
  }
  public void setCountry(String country) {
    this.country = country;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
public void setState(Integer state) {
  this.state = state;
}

public void setZipCode(String zipCode) {
  this.zipCode = zipCode;
}
  
  
}
