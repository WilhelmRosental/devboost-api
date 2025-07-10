package dev.nathanhallouin.devboost.controller;

import dev.nathanhallouin.devboost.model.Formation;
import dev.nathanhallouin.devboost.repository.FormationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indique que cette classe est un contrôleur REST
@RequestMapping("/api/formations") // Préfixe pour toutes les routes de ce contrôleur
public class FormationController {

    private final FormationRepository formationRepository;

    // Injection du repository via le constructeur
    public FormationController(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    // Récupère toutes les formations
    @GetMapping
    public List<Formation> getAll() {
        return formationRepository.findAll();
    }

    // Crée une nouvelle formation
    @PostMapping
    public Formation create(@RequestBody Formation formation) {
        return formationRepository.save(formation);
    }

    // Récupère une formation par son id
    @GetMapping("/{id}")
    public Formation getById(@PathVariable Long id) {
        return formationRepository.findById(id).orElseThrow();
    }
}
