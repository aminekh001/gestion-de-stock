package com.medAmine.gestion.de.stock.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;



@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "ligneCommandeFourisser")
public class LigneCommandeFournisser extends AbstracetEntity{

    @ManyToOne
    @JoinColumn(name = "idarticle" )
    private Article article;

    @ManyToOne
    @JoinColumn(name="idcommandeFournisser")
    private CommandeFournisser commandeFournisser;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

}

