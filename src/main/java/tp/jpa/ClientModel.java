package tp.jpa;

import java.util.Set;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "clients")
public class ClientModel {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@NotNull
	@Size(min = 3, max = 40)
	@Column(name = "company_name", nullable = false, length = 40)
	private String companyName;

	@NotNull
	@Size(min = 3, max = 40)
	@Column(name = "first_name", nullable = false, length = 40)
	private String firstName;

	@NotNull
	@Size(min = 3, max = 40)
	@Column(name = "last_name", nullable = false, length = 40)
	private String lastName;

	@NotNull
	@Size(min = 3, max = 90)
	@Column(name = "email", nullable = false, length = 90)
	private String email;

	@NotNull
	@Size(min = 10, max = 10)
	@Column(name = "phone", nullable = false, length = 10)
	private String phone;

	@NotNull
	@Size(min = 3, max = 255)
	@Column(name = "address", nullable = false, length = 255)
	private String adress;

	@NotNull
	@Size(min = 3, max = 10)
	@Column(name = "zip_code", nullable = false, length = 10)
	private String zipCode;

	@NotNull
	@Size(min = 3, max = 40)
	@Column(name = "city", nullable = false, length = 40)
	private String city;

	@NotNull
	@Size(min = 3, max = 60)
	@Column(name = "country", nullable = false, length = 60)
	private String country;

	@Enumerated(EnumType.ORDINAL) // EnumType.STRING
	@Column(name = "state", nullable = false)
	private State state;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Set<OrderModel> orders;

	public ClientModel() {
	}

	public enum State {
		CANCELED,
		OPTION,
		CONFIRMED
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Set<OrderModel> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderModel> orders) {
		this.orders = orders;
	}
}