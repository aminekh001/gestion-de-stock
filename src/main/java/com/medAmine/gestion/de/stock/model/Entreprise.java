package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "entreprise")
public class Entreprise extends AbstracetEntity{
    @Column(name="nom")
    private String nom;
    @Column(name="siteWeb")
    private String siteWeb;
    @Column(name="description")
    private String description;

    @Embedded
    private Adresse adresse;
    @Column(name="codeFiscal")
    private String codeFiscal;
    @Column(name="photo")
    private String photo;
    @Column(name="email")
    private String email;
    @Column(name="numTel")
    private  String numTel;
    @Column(name="utilisateurs")
    private List<Utilisateur> utilisateurs;
}
