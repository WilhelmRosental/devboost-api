package dev.nathanhallouin.devboost.repository;

import dev.nathanhallouin.devboost.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

// Ce repository permet d'effectuer des opérations CRUD sur l'entité Formation.
// Il hérite de JpaRepository, ce qui fournit automatiquement les méthodes de base (findAll, findById, save, delete, etc.).
public interface FormationRepository extends JpaRepository<Formation, Long> {
    // Vous pouvez ajouter ici des méthodes personnalisées si besoin, par exemple :
    // List<Formation> findByTitreContaining(String titre);
}
