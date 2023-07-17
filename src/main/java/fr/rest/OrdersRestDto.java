package fr.rest;



public class OrdersRestDto {

  private Integer id;
 
  private String typePresta;  
  private String designation;
  private Integer clientId;
  private int nbDays;
  private int unitPrice;
  private int state;

  public OrdersRestDto(Integer id, String typePresta, String designation, Integer clientId, Integer nbDays, Integer unitPrice, Integer state) {
    this.id = id;
    this.typePresta = typePresta;
    this.designation = designation;
    this.clientId = clientId;
    this.nbDays = nbDays;
    this.unitPrice = unitPrice;
    this.state = state;
}

public OrdersRestDto(){}

 public Integer getId() {
    return id;
  }
  
  public String getTypePresta() {
    return typePresta;
  }
 
  public String getDesignation() {
    return designation;
  }
 public Integer getClientId() {
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

  public void setId(Integer id) {
    this.id = id;
  }

   public void setTypePresta(String typePresta) {
    this.typePresta = typePresta;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }
  
 public void setClientId(Integer clientId) {
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

  public OrdersRestDto toEntity(){
    OrdersRestDto orderEntity = new OrdersRestDto();
    orderEntity.setId(this.id);
    orderEntity.setTypePresta(this.typePresta);
    orderEntity.setDesignation(this.designation);
    orderEntity.setClientId(this.clientId);
    orderEntity.setNbDays(this.nbDays);
    orderEntity.setUnitPrice(this.unitPrice);
    orderEntity.setState(this.state);
    return orderEntity;

  }
  
}
