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
@Table(name = "commandeFournisser")
public class CommandeFournisser extends AbstracetEntity{
    @Column(name="code")
    private String code;

    private Instant dateCommande;
    @ManyToOne
    @JoinColumn(name ="idFournisser")
    private Fournisser fournisser;
    private EtatCommande etatCommande;

    private Integer idEntreprise;
    @OneToMany(mappedBy = "commandeFournisser")
    private List<LigneCommandeFournisser> ligneCommandeFournissers;


}
