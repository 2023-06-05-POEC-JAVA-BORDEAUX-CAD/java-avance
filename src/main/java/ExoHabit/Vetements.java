package ExoHabit;

interface Vetement {
    void affiche();
}

class Haut implements Vetement {
    private String nomHaut;

    public Haut(String nomHaut) {
        this.nomHaut = nomHaut;
    }

    public String getNomHaut() {
        return nomHaut;
    }

    public void setNomHaut(String nomHaut) {
        this.nomHaut = nomHaut;
    }

    @Override
    public void affiche() {
        System.out.println("Haut : " + nomHaut);
    }
}

class Tshirt extends Haut {
    public Tshirt(String nomHaut) {
        super(nomHaut);
    }
}

class Chemise extends Haut {
    public Chemise(String nomHaut) {
        super(nomHaut);
    }
}

class Bas implements Vetement {
    private String nomBas;
    private boolean longueur;

    public Bas(String nomBas, boolean longueur) {
        this.nomBas = nomBas;
        this.longueur = longueur;
    }

    public String getNomBas() {
        return nomBas;
    }

    public void setNomBas(String nomBas) {
        this.nomBas = nomBas;
    }

    public boolean isLongueur() {
        return longueur;
    }

    public void setLongueur(boolean longueur) {
        this.longueur = longueur;
    }

    @Override
    public void affiche() {
        String longueurStr = longueur ? "long" : "court";
        System.out.println("Bas : " + nomBas + ", Longueur : " + longueurStr);
    }
}

class Pantalon extends Bas {
    public Pantalon(String nomBas, boolean longueur) {
        super(nomBas, longueur);
    }
}

class Jupe extends Bas {
    public Jupe(String nomBas, boolean longueur) {
        super(nomBas, longueur);
    }
}

class Client {
    private String nomClient;
    private String prenomClient;
    private Haut haut;
    private Bas bas;

    public Client(String nomClient, String prenomClient) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public Haut getHaut() {
        return haut;
    }

    public void setHaut(Haut haut) {
        this.haut = haut;
    }

    public Bas getBas() {
        return bas;
    }

    public void setBas(Bas bas) {
        this.bas = bas;
    }

    public void parle() {
        System.out.println("Nom : " + nomClient + " " + prenomClient);
        if (haut != null && bas != null) {
            haut.affiche();
            bas.affiche();
        } else {
            System.out.println("Client non habillé");
        }
    }
}

public class Vetements {
    public static void main(String[] args) {
        Client client1 = new Client("Doe", "John");
        Client client2 = new Client("Smith", "Alice");

        Tshirt tshirt = new Tshirt("T-shirt");
        Chemise chemise = new Chemise("Chemise");
    }
}