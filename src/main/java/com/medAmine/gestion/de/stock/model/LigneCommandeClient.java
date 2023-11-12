package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "ligneCommandeClient")
public class LigneCommandeClient extends AbstracetEntity{
    @ManyToOne
    @JoinColumn(name="idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name="idCommandeClient")
    private CommandeClient commandeClient;
    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

}
