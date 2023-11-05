package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "commandeFournisser")
public class CommandeFournisser extends AbstracetEntity{
    @Column(name="code")
    private String code;

    @ManyToOne
    @JoinColumn(name ="idFournisser")
    private Fournisser fournisser;
    @OneToMany(mappedBy = "commandeFournisser")
    private List<LigneCommandeFournisser> ligneCommandeFournissers;


}
