package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "mvtstk")
public class MvtStk extends AbstracetEntity{
    @ManyToOne
    @JoinColumn(name="idArticle")
    private Article article;
    @Column(name="dateMvt")
    private Instant dateMvt;
    @Column(name="qantites")
    private BigDecimal quantites;
    @Column(name="typeMvStk")
    private TypeMvtstk typeMvtstk;

}
