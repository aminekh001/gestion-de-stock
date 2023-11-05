package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
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
@Table(name = "fournisser")
public class Fournisser extends AbstracetEntity{
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
    @OneToMany(mappedBy = "fournisser")
    private List<CommandeFournisser> commandeFournissers;

}
