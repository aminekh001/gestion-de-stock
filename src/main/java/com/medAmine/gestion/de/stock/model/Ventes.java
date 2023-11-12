package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ventes")
public class Ventes extends AbstracetEntity{
    @Column(name="code")
    private String code;
    @Column(name="dateVente")
    private Instant dateVente;
    @Column(name="commentaire")
    private String commentaire;
    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;


}
