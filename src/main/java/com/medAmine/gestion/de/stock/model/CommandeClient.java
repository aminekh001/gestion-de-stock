package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;
}
