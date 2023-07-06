package fr.TpFilRouge.DAO;

import java.util.HashMap;
import java.util.Map;

import fr.TpFilRouge.Objet.Commande;
import jakarta.ejb.Stateless;

@Stateless
public class CommandeDao {

    private Map<Integer, Commande> commandeMap;

    public CommandeDao() {
        commandeMap = new HashMap<>();
        commandeMap.put(1, new Commande(1, "Formation", "Angular init", 2, 3, 1200, 0 ));
        commandeMap.put(2, new Commande(2, "Formation", "React avancé", 2, 3, 1000, 2 ));
        commandeMap.put(3, new Commande(3, "Coaching", "React Techlead", 1, 20, 900, 2 ));
        commandeMap.put(4, new Commande(4, "Coaching", "Nest.js Techlead", 1, 50, 800, 1 ));        
    }

    public Commande getCommande(Integer id) {
        return commandeMap.get(id);
    }
    
    public Map<Integer, Commande> getCommandeMap() {
        return commandeMap;
    }
}
