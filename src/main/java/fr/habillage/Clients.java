package fr.habillage;

public class Clients {

  public void parle(){
    Chemises chemise = new Chemises();
    String nomHaut = chemise.getNomHaut();
    Pantalons pantalon = new Pantalons();
    String nomBas= pantalon.getNomBas();
    Boolean longueur = pantalon.getLongueur();


    Hauts haut = new Hauts(nomHaut);
    Bas bas = new Bas(nomBas, longueur);


      bas.affiche();
      haut.affiche();

  }

 public static void main(String[] args) {
 Clients client = new Clients();
 client.parle();
  
 }} 
