package fr.groupe2.tpapi.dto;

import java.util.ArrayList;
import java.util.List;

import fr.groupe2.tpapi.model.Client;
import fr.groupe2.tpapi.model.Order;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class ClientDto {
	private Integer id;
	@NotEmpty(message= "CompanyName ne peut être null ou vide")
	private String companyName;
	private String firstName;
	private String lastName;
	@Email(message= "Email invalide")
	private String email;
	private String phone;
	private String address;
	private String zipCode;
	private String city;
	private String country;
	private Boolean state;
	private List<OrderDto> orders = new ArrayList<>();
	
	/**
	 * Constructors
	 */
	public ClientDto() {}
	
	public ClientDto(Integer id, String companyName, String firstName, String lastName, String email, String phone,
			String address, String zipCode, String city, String country, Boolean state) {
		this.id = id;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.state = state;
	}
	
	public ClientDto(Client client) {
		this.id = client.getId();
		this.companyName = client.getCompanyName();
		this.firstName = client.getFirstName();
		this.lastName = client.getLastName();
		this.email = client.getEmail();
		this.phone = client.getPhone();
		this.address = client.getAddress();
		this.zipCode = client.getZipCode();
		this.city = client.getCity();
		this.country = client.getCountry();
		this.state = client.getState();
		this.orders = this.orderToOrderDto(client.getOrders());
	}
	
	/**
	 * Getters and Setters
	 */
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
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	
	public List<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}

	// Methods
	public Client toEntity() {
		Client entity = new Client();
		entity.setCompanyName(this.getCompanyName());
		entity.setFirstName(this.getFirstName());
		entity.setLastName(this.getLastName());
		entity.setEmail(this.getEmail());
		entity.setPhone(this.getPhone());
		entity.setAddress(this.getAddress());
		entity.setZipCode(this.getZipCode());
		entity.setCity(this.getCity());
		entity.setCountry(this.getCountry());
		entity.setState(this.getState());
		return entity;
	}
	
	public List<OrderDto> orderToOrderDto(List<Order> orders){
		List<OrderDto> ordersDto = new ArrayList<>();
		for(Order order : orders) {
			ordersDto.add(new OrderDto(order));
		}
		return ordersDto;
	}
}
