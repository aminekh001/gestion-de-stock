package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ventes")
public class Ventes extends AbstracetEntity{
    @Column(name="code")
    private String code;
    @Column(name="dateVente")
    private Instant dateVente;
    @Column(name="commentaire")
    private String commentaire;


}
