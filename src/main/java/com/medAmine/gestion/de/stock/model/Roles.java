package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "Roles")
public class Roles extends AbstracetEntity{
    @Column(name="roleName")
    private String roleName;
    @ManyToOne
    @JoinColumn(name="idUtilisater")
    private Utilisateur utilisateur;

}
