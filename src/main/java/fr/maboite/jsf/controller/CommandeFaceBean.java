package fr.maboite.jsf.controller;


import java.time.LocalDate;

import jakarta.enterprise.context.RequestScoped;
//import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
//@SessionScoped
@RequestScoped
public class CommandeFaceBean {
   private String message = "Ceci est le message provenant du controller Commande !";
   private Integer numero = 15;
   private Boolean paye = true;
   private String date;
   private String loadId;

public String createNew() {
//..opérations Java ici
System.out.println("commande");
return "commande";
}



public void onLoad() {  
  System.out.println(loadId);
}
   
   public String getMessage() {
     return message;
   }

   public Integer getNumero() {
     return numero;
   }

   public Boolean getPaye() {
     return paye;
   }
   public String getLoadId() {
     return loadId;
   }
   public String getDate() {
      date = LocalDate.now().toString();
      return date;
   }

   public void setDate(String date) {
     this.date = date;
   }

   public void setMessage(String message) {
     this.message = message;
   }

   public void setNumero(Integer numero) {
     this.numero = numero;
   }

   public void setPaye(Boolean paye) {
     this.paye = paye;
   }
   public void setLoadId(String loadId) {
     this.loadId = loadId;
   }
  }
