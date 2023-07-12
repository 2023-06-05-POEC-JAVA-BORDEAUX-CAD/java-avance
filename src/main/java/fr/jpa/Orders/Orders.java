package fr.jpa.Orders;

import fr.jpa.Clients.Clients;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "orders")
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column (name ="type_presta")
  private String typePresta;

  
  private String designation;

  @Column (name ="client_id")
  private int clientId;

  @Column (name ="nb_days")
  private int nbDays;

  @Column (name ="unit_price")
  private int unitPrice;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "CLIENTS_ID")
  private Clients client;

  private int state;

//   @Enumerated(EnumType.STRING)
//   @Column (name ="type_presta")
//     private OrdersEnum typePresta;  
  
  //Getters
  
  public int getId() {
      return id;
  }

  public String getTypePresta() {
      return typePresta;
  }

  public String getDesignation() {
      return designation;
  }

  public int getClientId() {
      return clientId;
  }

  public int getNbDays() {
      return nbDays;
  }

  public int getUnitPrice() {
      return unitPrice;
  }

  public int getState() {
      return state;
  }

//  public OrdersEnum getTypePresta() {
//    return typePresta;
//  }

 public Clients getClient() {
   return client;
 }
  
  //SETTERS
  
  public void setId(int id) {
      this.id = id;
  }
  
public void setTypePresta(String typePresta) {
      this.typePresta = typePresta;
  }
  
  public void setDesignation(String designation) {
      this.designation = designation;
  }
  
  public void setClientId(int clientId) {
      this.clientId = clientId;
  }
  
  public void setNbDays(int nbDays) {
      this.nbDays = nbDays;
  }
  
  public void setUnitPrice(int unitPrice) {
      this.unitPrice = unitPrice;
  }
  
  public void setState(int state) {
      this.state = state;
  }

 //public void setTypePresta(OrdersEnum string) {
   //this.typePresta = string;
 //}

 public void setClient(Clients client) {
   this.client = client;
 }
}
