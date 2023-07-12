package fr.maboite.jpa;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="clients")
public class ClientJpa {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	

	@Column(name="company_name")
	public String companyName;
	
	@Column(name="first_name")
	public String firstName;
		
	@Column(name="last_name")
	public String lastName;
	
	@OneToMany(mappedBy="clientJpa",fetch=FetchType.EAGER)
	private Set<OrderJpa> orders=new HashSet<>();

	

	public Set<OrderJpa> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderJpa> orders) {
		this.orders = orders;
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
	
	public ClientJpa() {
		super();
	}

	public ClientJpa(Integer id, String companyName, String firstName, String lastName) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

}
