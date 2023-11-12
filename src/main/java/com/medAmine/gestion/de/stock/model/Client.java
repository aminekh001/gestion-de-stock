package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "client")
public class Client extends AbstracetEntity{

    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Embedded
    private Adresse adresse;
    @Column(name="photo")
    private String photo;

    @Column(name="mail")
    private String mail;
    @Column(name="numTel")
    private String numTel;
    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy ="client")
    private List <CommandeClient> commandeClientList;

}
