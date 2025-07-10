package dev.nathanhallouin.devboost.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity // Indique que cette classe est une entité JPA
@Data // Génère getters, setters, equals, hashCode, toString
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génération auto de l'id
    private Long id;

    private String nom; // Nom de la catégorie

    // Plusieurs catégories peuvent appartenir à une formation
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    // Une catégorie possède plusieurs modules
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Module> modules;
}
