package Tp_solo_07_04_inject;

import jakarta.ejb.Stateless;

@Stateless
public class JourFerieService {
    public String calculerJourFerie(int jour, int mois, int annee) {
        // Code de calcul du jour férié
        // implémenter  ici d'autres methodes        
        // Exemple : Vérifier si c'est un samedi ou un dimanche
        if (estWeekend(jour, mois, annee)) {
            return "C'est le week-end !";
        } else {
            return "C'est jour travaillé";
        }
    }
    
    private boolean estWeekend(int jour, int mois, int annee) {
        // Implémentation de la logique pour vérifier si c'est un samedi ou un dimanche
        // utiliser des classes pour effectuer cette vérification
        
        return false; // Exemple, à compléter avec votre propre logique
    }
}
