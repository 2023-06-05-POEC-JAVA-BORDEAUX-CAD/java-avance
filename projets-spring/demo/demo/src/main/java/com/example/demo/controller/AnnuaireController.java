package com.example.demo.controller;

import com.example.demo.business.Annuaire;
import com.example.demo.business.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("api")  >> va créer un route api dans l'url. il faudra mettre /api avant la route, ici /personnes 
// donc http://.../api/personnes
public class AnnuaireController {

    @Autowired
    Annuaire annuaire;

    @GetMapping("hello")
    public String sayHello() {
        return "Coucou";
    }

    @GetMapping("personnes")
    public List<Personne> getPersonnes() {
        /*
         * Personne p = new Personne("Jean", "Rodriguez");
         * Personne p2 = new Personne("Marie", "Dupont");
         * 
         * List<Personne> personnes = new ArrayList<>();
         * personnes.add(p);
         * personnes.add(p2);
         * 
         * return personnes;
         */

        return annuaire.getPersonnes();
    }

    @PostMapping("personnes")
    public void postPersonne(@RequestBody Personne newPersonne) {
        System.out.println(newPersonne);

        annuaire.addPersonne(newPersonne);
    }
}