package fr.groupe3.tpfilrouge.orders;

public class OrdersDto {
  
private Integer id;
 
  private String typePresta;  
  private String designation;
  private Long clientId;
  private Integer nbDays;
  private Integer unitPrice;
  private Integer state;

  public OrdersDto(Orders order) {
    this.id = order.getId();
		this.designation = order.getDesignation();
		this.clientId = order.getClient() != null ? order.getClient().getId() :null;
		this.nbDays = order.getNbDays();
		this.unitPrice = order.getUnitPrice();
		this.typePresta = order.getTypePresta();
		this.state = order.getState();
}

public OrdersDto(){}

 public Integer getId() {
    return id;
  }
  
  public String getTypePresta() {
    return typePresta;
  }
 
  public String getDesignation() {
    return designation;
  }
 public Long getClientId() {
   return clientId;
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

  public void setId(Integer id) {
    this.id = id;
  }

   public void setTypePresta(String typePresta) {
    this.typePresta = typePresta;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }
  
 public void setClientId(Long clientId) {
   this.clientId = clientId;
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

  public Orders toEntity(){
    Orders orderEntity = new Orders();
    orderEntity.setId(this.id);
    orderEntity.setTypePresta(this.typePresta);
    orderEntity.setDesignation(this.designation);    
    orderEntity.setNbDays(this.nbDays);
    orderEntity.setUnitPrice(this.unitPrice);
    orderEntity.setState(this.state);
    //orderEntity.setClientId(this.clientId);
    return orderEntity;

  }
  
}