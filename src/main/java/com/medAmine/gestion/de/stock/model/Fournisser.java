package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "fournisser")
public class Fournisser extends AbstracetEntity{
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Embedded
    private Adresse adresse;
    private Integer idEntreprise;
    @Column(name="photo")
    private String photo;
    @Column(name="mail")
    private String mail;
    @Column(name="numTel")
    private String numTel;
    @OneToMany(mappedBy = "fournisser")
    private List<CommandeFournisser> commandeFournissers;

}
