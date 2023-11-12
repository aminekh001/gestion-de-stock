package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "ligneVente")
public class LigneVente extends AbstracetEntity{

    @ManyToOne
    @JoinColumn(name="idVente")
    private Ventes vente;

    private Article article;
    @Column(name="quntite")
    private BigDecimal quantite;
    @Column(name="prixUnitaire")
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;


}
