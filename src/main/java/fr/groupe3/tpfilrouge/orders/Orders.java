package fr.groupe3.tpfilrouge.orders;


import fr.groupe3.tpfilrouge.clients.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Stateless
@Entity
@Table (name = "orders")
public class Orders {
  

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column (name ="type_presta")
  private String typePresta;
  
  private String designation;

  @Column (name ="nb_days")
  private Integer nbDays;

  @Column (name ="unit_price")
  private Integer unitPrice;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "client_id")
  private Client client;

  private Integer state;
  
  //Getters
  
  public Integer getId() {
      return id;
  }

  public String getTypePresta() {
      return typePresta;
  }

  public String getDesignation() {
      return designation;
  }

  public Integer getNbDays() {
      return nbDays;
  }

  public Integer getUnitPrice() {
      return unitPrice;
  }

  public Integer getState() {
      return state;
  }

 public Client getClient() {
   return client;
 }  
  
 //SETTERS
  
  public void setId(Integer id) {
      this.id = id;
  }
  
public void setTypePresta(String typePresta) {
      this.typePresta = typePresta;
  }
  
  public void setDesignation(String designation) {
      this.designation = designation;
  }
  
  public void setNbDays(Integer nbDays) {
      this.nbDays = nbDays;
  }
  
  public void setUnitPrice(Integer unitPrice) {
      this.unitPrice = unitPrice;
  }
  
  public void setState(Integer state) {
      this.state = state;
  }

 public void setClient(Client client) {
   this.client = client;
 }
}