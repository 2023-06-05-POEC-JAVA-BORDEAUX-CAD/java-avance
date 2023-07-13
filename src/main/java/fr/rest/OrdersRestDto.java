package fr.rest;

public class OrdersRestDto {

  private Integer id;
 
  private String typePresta;  
  private String designation;

 public Integer getId() {
    return id;
  }
  
  public String getTypePresta() {
    return typePresta;
  }
 
  public String getDesignation() {
    return designation;
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
  
  
}
