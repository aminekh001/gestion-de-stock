package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ligneCommandeClient")
public class LigneCommandeClient extends AbstracetEntity{
    @ManyToOne
    @JoinColumn(name="idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name="idCommandeClient")
    private CommandeClient commandeClient;

}
