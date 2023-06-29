package model;

public class Haut implements Vetement {
private String nom;



@Override
public String toString() {
	return "Haut [nom=" + nom + "]";
}

public Haut(String nom) {
	super();
	this.nom = nom;
}

public void afficher() {
	System.out.println(this.toString());		
	
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}


}
