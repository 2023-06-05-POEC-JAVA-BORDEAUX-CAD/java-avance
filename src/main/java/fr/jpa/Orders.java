package fr.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "orderstestjpa")
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


  private int state;
  
  public Orders() {
  }
  
  public Orders(Integer id, String typePresta, String designation, int clientId, int nbDays, int unitPrice, int state ) {
      this.id = id;
      this.typePresta = typePresta;
      this.designation = designation;
      this.clientId = clientId;
      this.nbDays = nbDays;
      this.unitPrice = unitPrice;
      this.state = state;
  }

  
  //Getters
  
  public int getId() {
      return id;
  }

  public String getTypPresta() {
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

  
}
