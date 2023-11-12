package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "commandeClient")
public class CommandeClient extends AbstracetEntity{
    @Column(name="code")
    private String code;
    @Column(name="dateCommande")
    private Instant dateCommande;
    @ManyToOne
    @JoinColumn(name="idClient")
    private Client client;
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;
    private Integer idEntreprise;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;
}
