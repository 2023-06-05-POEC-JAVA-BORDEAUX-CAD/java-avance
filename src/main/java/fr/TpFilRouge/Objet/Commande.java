package fr.TpFilRouge.Objet;

public class Commande {
    private Integer id;
    private String type_presta;
    private String designation;
    private int client_id;
    private int nb_days;
    private int unit_price;
    private int state;
    
    public Commande() {
    }
    
    public Commande(Integer id, String type_presta, String designation, int client_id, int nb_days, int unit_price, int state ) {
        this.id = id;
        this.type_presta = type_presta;
        this.designation = designation;
        this.client_id = client_id;
        this.nb_days = nb_days;
        this.unit_price = unit_price;
        this.state = state;
    }

    
    //Getters
    
    public int getId() {
        return id;
    }

    public String getType_presta() {
        return type_presta;
    }

    public String getDesignation() {
        return designation;
    }

    public int getClient_id() {
        return client_id;
    }

    public int getNb_days() {
        return nb_days;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public int getState() {
        return state;
    }

    
    
    //SETTERS
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setType_presta(String type_presta) {
        this.type_presta = type_presta;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
    
    public void setNb_days(int nb_days) {
        this.nb_days = nb_days;
    }
    
    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }
    
    public void setState(int state) {
        this.state = state;
    }

}