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

public String createNew() {
//..opérations Java ici
System.out.println("commande");
return "commande";
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
}
