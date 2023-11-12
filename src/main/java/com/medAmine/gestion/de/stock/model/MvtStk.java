package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "mvtstk")
public class MvtStk extends AbstracetEntity{
    @ManyToOne
    @JoinColumn(name="idArticle")
    private Article article;
    @Column(name="dateMvt")
    private Instant dateMvt;
    @Column(name="qantite")
    private BigDecimal quantite;
    @Column(name="typeMvt")
    @Enumerated(EnumType.STRING)
    private TypeMvtstk typeMvtstk;
    @Column(name = "sourcemvt")
    @Enumerated(EnumType.STRING)
    private SourceMvtStk sourceMvt;
    private Integer idEntreprise;

}
