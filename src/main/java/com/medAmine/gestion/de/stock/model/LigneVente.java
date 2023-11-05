package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ligneVente")
public class LigneVente extends AbstracetEntity{

    @ManyToOne
    @JoinColumn(name="idVente")
    private Ventes vente;

    @Column(name="quntite")
    private BigDecimal quntite;
    @Column(name="prixUnitaire")
    private BigDecimal prixUnitaire;


}
