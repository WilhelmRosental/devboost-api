package dev.nathanhallouin.devboost.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity // Indique que cette classe est une entité JPA
@Data // Génère getters, setters, equals, hashCode, toString
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génération auto de l'id
    private Long id;

    private String titre; // Titre de la formation

    private String description; // Description de la formation

    // Une formation possède plusieurs catégories
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categorie> categories;
}
