package dev.nathanhallouin.devboost.repository;

import dev.nathanhallouin.devboost.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;

// Ce repository permet d'effectuer des opérations CRUD sur l'entité Module.
// Il hérite de JpaRepository, ce qui fournit automatiquement les méthodes de base (findAll, findById, save, delete, etc.).
public interface ModuleRepository extends JpaRepository<Module, Long> {
    // Vous pouvez ajouter ici des méthodes personnalisées si besoin, par exemple :
    // List<Module> findByTitre(String titre);
}
