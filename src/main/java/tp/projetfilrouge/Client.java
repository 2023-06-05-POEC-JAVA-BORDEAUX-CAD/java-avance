package tp.projetfilrouge;

public class Client {
	Integer id;
	String companyName;
	String firstName;
	String lastName;
	String email;
	Integer phone;
	String adress;
	String zipCode;
	String city;
	String country;
	Integer state;

	public Client() {
	}

	public Client(String companyName, String firstName, String lastName, String email, Integer phone, String adress,
			String zipCode, String city, String country, Integer state) {
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.state = state;
	}

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

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
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
/*
 * public class Client {
 * Integer id;
 * String companyName;
 * String firstName;
 * String lastName;
 * String email;
 * Integer phone;
 * String adress;
 * String zipCode;
 * String city;
 * String country;
 * Integer state;
 * 
 * // Constructeur vide ==> pour rendre compatible avec le javabean
 * 
 * public Client() {
 * 
 * }
 * 
 * // Constructeur
 * 
 * public Client(String companyName, String firstName, String lastName, String
 * email, Integer phone, String adress,
 * String zipCode, String city, String country, Integer state) {
 * this.companyName = companyName;
 * this.firstName = firstName;
 * this.lastName = lastName;
 * this.email = email;
 * this.phone = phone;
 * this.adress = adress;
 * this.zipCode = zipCode;
 * this.city = city;
 * this.country = country;
 * this.state = state;
 * }
 * 
 * // Getters
 * 
 * public String getcompanyName() {
 * return companyName;
 * }
 * 
 * public String getfirstName() {
 * return firstName;
 * }
 * 
 * public String getlastName() {
 * return lastName;
 * }
 * 
 * public String getemail() {
 * return email;
 * }
 * 
 * public Integer getphone() {
 * return phone;
 * }
 * 
 * public String getadress() {
 * return adress;
 * }
 * 
 * public String getzipCode() {
 * return zipCode;
 * }
 * 
 * public String getcity() {
 * return city;
 * }
 * 
 * public String getcountry() {
 * return country;
 * }
 * 
 * public Integer getstate() {
 * return state;
 * }
 * 
 * // Setters
 * 
 * public void setcompanyName(String companyName) {
 * this.companyName = companyName;
 * }
 * 
 * public void setfirstName(String firstName) {
 * this.firstName = firstName;
 * }
 * 
 * public void setlastName(String lastName) {
 * this.lastName = lastName;
 * }
 * 
 * public void setemail(String email) {
 * this.email = email;
 * }
 * 
 * public void setphone(Integer phone) {
 * this.phone = phone;
 * }
 * 
 * public void setadress(String adress) {
 * this.adress = adress;
 * }
 * 
 * public void setzipCode(String zipCode) {
 * this.zipCode = zipCode;
 * }
 * 
 * public void setcity(String city) {
 * this.city = city;
 * }
 * 
 * public void setcountry(String country) {
 * this.country = country;
 * }
 * 
 * public void setstate(Integer state) {
 * this.state = state;
 * }
 * 
 * }
 */