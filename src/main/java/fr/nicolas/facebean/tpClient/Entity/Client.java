package fr.nicolas.facebean.tpClient.Entity;

public class Client {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String companyName;
	
	public Client() {}
	
	public Client(Integer id, String firstName, String lastName, String companyName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
