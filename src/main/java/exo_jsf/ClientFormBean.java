package exo_jsf;


public class ClientFormBean {
	public void save(ClientFormBean form) {
		System.out.println("Je sauvegarde le formulaire");
		System.out.println("Je sauvegarde le formulaire");
		
	}

	private Integer clientId;
	private String companyName;
	private String firstName;
	private String lastName;
	private String email;
	private Integer phone;
	private String adress;
	private Integer zipCode;
	private String city;
	private String country;
	private Boolean state;
	
	// Getter


	public int getClientId() {
		return clientId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public int getPhone() {
		return phone;
	}
	public String getAdress() {
		return adress;
	}
	public int getZipCode() {
		return zipCode;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public boolean isState() {
		return state;
	}

	
	
	// Setter

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	

	public void setId(String loadId) {
		// TODO Auto-generated method stub
		
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}





}
