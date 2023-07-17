package fr.rest;

import jakarta.validation.constraints.NotNull;

public class ClientsRestDto {
  private Integer id;
  private String name;

  public Integer getId() {
    return id;
  }

  @NotNull (message = "Le nom doit avoir une valeur.")
  public String getName() {
    return name;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }

}
