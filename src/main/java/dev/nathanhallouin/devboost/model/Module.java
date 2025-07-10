package dev.nathanhallouin.devboost.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // Indique que cette classe est une entité JPA
@Data // Génère getters, setters, equals, hashCode, toString
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génération auto de l'id
    private Long id;

    private String titre; // Titre du module

    private String contenu; // Contenu du module

    // Plusieurs modules peuvent appartenir à une catégorie
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
