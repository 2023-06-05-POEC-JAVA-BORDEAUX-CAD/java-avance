package fr.maboite.jsf.controller;

import jakarta.enterprise.context.RequestScoped;

//import java.time.LocalDate;


import jakarta.inject.Named;

@Named
@RequestScoped
public class MonPremierFaceBean {

  private String message = "Ce message vient du Controller";
  
  public String getMessage() {
    return message;
    //return LocalDate.now().toString();
  }
  public void setMessage(String message) {
    this.message = message;
  }
}
