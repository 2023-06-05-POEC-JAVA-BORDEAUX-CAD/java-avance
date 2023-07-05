package fr.habillage;

public class Hauts implements Vetements {

  String nomHaut;
  
public Hauts (String nomHaut){
  this.nomHaut=nomHaut;
 
}
public String getNomHaut() {
  return nomHaut;  
}
public void setNomHaut(String nomHaut) {
  this.nomHaut = nomHaut;
}
@Override
public void affiche() {
  System.out.println("haut : " + nomHaut);  
}
}
