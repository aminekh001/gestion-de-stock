package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Roles")
public class Roles extends AbstracetEntity{
    @Column(name="roleName")
    private String roleName;
    @ManyToOne
    @JoinColumn(name="idUtilisater")
    private Utilisateur utilisateur;

}
