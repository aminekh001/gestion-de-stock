package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "client")
public class Client extends AbstracetEntity{
    private String nom;
    private String prenom;
    @Embedded
    private Adresse adresse;
    private String photo;
    private String mail;

    private String numTel;

    @OneToMany(mappedBy ="client")
    private List <CommandeClient> commandeClientList;

}
