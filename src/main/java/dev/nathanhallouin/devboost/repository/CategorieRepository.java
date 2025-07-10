package dev.nathanhallouin.devboost.repository;

import dev.nathanhallouin.devboost.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

// Ce repository permet d'effectuer des opérations CRUD sur l'entité Categorie.
// Il hérite de JpaRepository, ce qui fournit automatiquement les méthodes de base (findAll, findById, save, delete, etc.).
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    // Vous pouvez ajouter ici des méthodes personnalisées si besoin, par exemple :
    // List<Categorie> findByNom(String nom);
}
