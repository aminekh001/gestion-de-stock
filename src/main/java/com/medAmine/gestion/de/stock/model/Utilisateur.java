package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends AbstracetEntity{
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="email")
    private String email;
    @Column(name="moteDePasse")
    private String moteDePasse;
    @Column(name="adresse")
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name= "identreprise")
    private Entreprise entreprise;
    @OneToMany(mappedBy = "utilisateur")
    private List<Roles> roles;

}
