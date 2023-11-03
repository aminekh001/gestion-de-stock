package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ligneCommandeFourisser")
public class LigneCommandeFournisser extends AbstracetEntity{

}

