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

	
	// Constructeur vide ==> pour rendre compatible avec le javabean
	
	public Client() {
		
	}	
	
	// Constructeur

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

	// Getters

	public String getcompanyName() {
		return companyName;
	}

	public String getfirstName() {
		return firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public String getemail() {
		return email;
	}

	public Integer getphone() {
		return phone;
	}

	public String getadress() {
		return adress;
	}

	public String getzipCode() {
		return zipCode;
	}

	public String getcity() {
		return city;
	}

	public String getcountry() {
		return country;
	}

	public Integer getstate() {
		return state;
	}

	// Setters

	public void setcompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public void setphone(Integer phone) {
		this.phone = phone;
	}

	public void setadress(String adress) {
		this.adress = adress;
	}

	public void setzipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public void setcountry(String country) {
		this.country = country;
	}

	public void setstate(Integer state) {
		this.state = state;
	}

}
