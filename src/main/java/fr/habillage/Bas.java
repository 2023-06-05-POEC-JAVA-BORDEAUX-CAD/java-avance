package fr.habillage;

public class Bas implements Vetements {

  private String nomBas;
  private Boolean longueur;
public Bas (String nomBas, Boolean longueur){
  this.nomBas=nomBas;
  this.longueur=longueur;
}
public Boolean getLongueur() {
  return longueur;
}
public String getNomBas() {
  return nomBas;
}

public void setLongueur(Boolean longueur) {
  this.longueur = longueur;
}

public void setNomBas(String nomBas) {
  this.nomBas = nomBas;
}


@Override
public void affiche() {

  String longueurVetement;

  if (longueur == true) {

     longueurVetement = "Court(e)";
    
  } else {

      longueurVetement = "Long";
    
  }
  
  System.out.println("bas : " + nomBas + " " + longueurVetement);  
}
}
