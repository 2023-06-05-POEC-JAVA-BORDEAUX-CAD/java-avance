package fr.nicolas.webservice.DTO;

import java.util.HashSet;
import java.util.Set;

import fr.nicolas.jpa.Entity.Order;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import fr.nicolas.jpa.Entity.Client;

public class ClientDTO {

	private Integer id;
	@NotEmpty
	@Size(min=4)
	private String companyName;
	@NotEmpty
	@Size(min=4)
	private String firstName;
	@NotEmpty
	@Size(min=4)
	private String lastName;
	@NotEmpty
	@Size(min=4)
	private String email;
	@NotEmpty
	@Size(min=4)
	private String phone;
	@NotEmpty
	@Size(min=4)
	private String address;
	@NotEmpty
	@Size(min=4)
	private String zipCode;
	@NotEmpty
	@Size(min=4)
	private String city;
	@NotEmpty
	@Size(min=4)
	private String country;
	private Set<Order> orders = new HashSet<>();
	
	
	public ClientDTO entityToDTO(Client client) {
		ClientDTO cliDTO = new ClientDTO();
		
		cliDTO.setId(client.getId());
		cliDTO.setCompanyName(client.getCompanyName());
		cliDTO.setFirstName(client.getFirstName());
		cliDTO.setLastName(client.getLastName());
		cliDTO.setEmail(client.getEmail());
		cliDTO.setPhone(client.getPhone());
		cliDTO.setAddress(client.getAddress());
		cliDTO.setZipCode(client.getZipCode());
		cliDTO.setCity(client.getCity());
		cliDTO.setCountry(client.getCountry());
		cliDTO.setOrders(client.getOrders());
		
		return cliDTO;
	}
	
	public Client DtoToEntity(ClientDTO cliDTO) {
		Client client = new Client();
		client.setId(cliDTO.getId());
		client.setCompanyName(cliDTO.getCompanyName());
		client.setFirstName(cliDTO.getFirstName());
		client.setLastName(cliDTO.getLastName());
		client.setEmail(cliDTO.getEmail());
		client.setPhone(cliDTO.getPhone());
		client.setZipCode(cliDTO.getZipCode());
		client.setCity(cliDTO.getCity());
		client.setCountry(cliDTO.getCountry());
		client.setOrders(cliDTO.getOrders());
		
		return client;
	}
	
	
	public Integer getId() {
		return id;
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
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCountry() {
		return country;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	

}
