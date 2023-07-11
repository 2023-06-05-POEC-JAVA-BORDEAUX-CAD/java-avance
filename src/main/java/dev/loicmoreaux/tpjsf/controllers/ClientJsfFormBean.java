package dev.loicmoreaux.tpjsf.controllers;

import dev.loicmoreaux.tpjsf.model.ClientJsf;

public class ClientJsfFormBean {
	/*
	 * Attributes of Client
	 */
	private Integer id;
	private String company_name;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String address;
	private String zip_code;
	private String city;
	private String country;
	private boolean state;
	
	/*
	 * Constructors
	 */
	public ClientJsfFormBean() {};
	
	public ClientJsfFormBean(Integer id, String company_name, String first_name, String last_name, String email,
			String phone, String address, String zip_code, String city, String country, boolean state) {
		super();
		this.id = id;
		this.company_name = company_name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.zip_code = zip_code;
		this.city = city;
		this.country = country;
		this.state = state;
	}
	
	/*
	 * Getters and Setters
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
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

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public ClientJsf toClient() {
		ClientJsf newClient = new ClientJsf();
		newClient.setId(id);
		newClient.setCompany_name(company_name);
		newClient.setFirst_name(first_name);
		newClient.setLast_name(last_name);
		newClient.setEmail(email);
		newClient.setPhone(phone);
		newClient.setAddress(address);
		newClient.setZip_code(zip_code);
		newClient.setCity(city);
		newClient.setCountry(country);
		newClient.setState(state);
		return newClient;
	}
}
