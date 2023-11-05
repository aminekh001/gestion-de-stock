package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ligneCommandeFourisser")
public class LigneCommandeFournisser extends AbstracetEntity{

    @ManyToOne
    @JoinColumn(name = "idarticle" )
    private Article article;

    @ManyToOne
    @JoinColumn(name="idcommandeFournisser")
    private CommandeFournisser commandeFournisser;

}

