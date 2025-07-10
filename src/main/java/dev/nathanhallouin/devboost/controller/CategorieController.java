package dev.nathanhallouin.devboost.controller;

import dev.nathanhallouin.devboost.model.Categorie;
import dev.nathanhallouin.devboost.model.Formation;
import dev.nathanhallouin.devboost.repository.CategorieRepository;
import dev.nathanhallouin.devboost.repository.FormationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indique que cette classe est un contrôleur REST
@RequestMapping("/api/categories") // Préfixe pour toutes les routes de ce contrôleur
public class CategorieController {

    private final CategorieRepository categorieRepository;
    private final FormationRepository formationRepository;

    // Injection des repositories via le constructeur
    public CategorieController(CategorieRepository categorieRepository, FormationRepository formationRepository) {
        this.categorieRepository = categorieRepository;
        this.formationRepository = formationRepository;
    }

    // Récupère toutes les catégories
    @GetMapping
    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    // Ajoute une catégorie à une formation existante
    @PostMapping("/formation/{formationId}")
    public Categorie addToFormation(@PathVariable Long formationId, @RequestBody Categorie categorie) {
        Formation formation = formationRepository.findById(formationId).orElseThrow();
        categorie.setFormation(formation);
        return categorieRepository.save(categorie);
    }
}
