package fr.jpa.Clients;

import java.util.List;
import fr.jpa.Orders.Orders;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Clients {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column (name = "company_name")
  private String companyName;

  //@Enumerated (EnumType.ORDINAL)
  //@Column (name = "company_name")
  //private ClientsEnum companyName;

  @Column (name = "first_name")
  private String firstName;

  @Column (name ="last_name")
  private String lastName;

  private String email;

  private String phone;

  private String address;

  @Column (name = "zip_code")
  private String zipCode;

  private String city;

  private String country;

  private Integer state;

  @OneToMany(mappedBy = "clients", fetch = FetchType.LAZY)
  private List<Orders> orders;
  
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

// public ClientsEnum getCompanyName() {
//   return companyName;
// }

// public void setCompanyName(ClientsEnum companyName) {
//   this.companyName = companyName;
// }

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

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

public List<Orders> getOrders() {
  return orders;
}

public void setOrders(List<Orders> orders) {
  this.orders = orders;
}
  
}
