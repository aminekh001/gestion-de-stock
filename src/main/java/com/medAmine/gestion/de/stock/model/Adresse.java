package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Embeddable
public class Adresse {
    @Column(name="adresse1")
    private String adress1;
    @Column(name="adresse2")
    private String adress2;
    @Column(name="ville")
    private String ville;
    @Column(name="pays")
    private  String pays;

}
