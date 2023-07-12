package fr.habillage;

public class ClientsHabits {

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
 ClientsHabits client = new ClientsHabits();
 client.parle();
  
 }} 
