package main.webapp.fr.farid.tpv7;

import java.time.LocalDate;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

import jakarta.inject.Named;

@Named
@RequestScoped
public class ClientFormBean2 {
    private String nom = "Farid";
    private Integer age = 37;
    private String ville = "Merignac";
    private Integer dpt = 33;
    private Boolean homme = true;
    private Integer annee = 2023;
    private LocalDate date = LocalDate.now();
    private String loadId = "loadId";
    private String message = "message statique pour test tp vendredi am";

    // Contructeur vide.
    public ClientFormBean2() {

    }

    // méthode ClientFaceBean.save() qui afficher une ligne dans la console (et
    // renvoie une String null ).
    public String ClientFaceBean() {
        System.out.println("----------------une ligne------------");
        return "null";
    }
    // 1 - _________________________

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = "Farid";
    }

    // 2 - _________________________

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = "Merignac";
    }

    // 3 - _________________________

    public String getLoadId() {
        return loadId;
    }

    public void setLoadId(String loadId) {
        this.loadId = "loadId";
    }

    // 4 - _________________________

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // 5 - _________________________

    public Integer getDpt() {
        return dpt;
    }

    public void setDpt(Integer dpt) {
        this.dpt = dpt;
    }

    // 6 - _________________________

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    // 7 - _________________________

    public Boolean getHomme() {
        return homme;
    }

    public void setHomme(Boolean homme) {
        this.homme = homme;
    }

    // 8 - _________________________

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // _________________________

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // _________________________

    // _________________________

    // _________________________

    // _________________________

    // _________________________

    // _________________________

    // _________________________

    // _________________________

    // _________________________

}
