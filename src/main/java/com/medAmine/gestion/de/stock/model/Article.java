package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "article")
public class Article extends AbstracetEntity {

    @Column(name="codeArticle")
    private String codeArticle;
    @Column(name="designation")
    private String designation;
    @Column(name="prixunitareHt")
    private BigDecimal prixunitareHt;
    @Column(name="tauxTva")
    private BigDecimal tauxTva;
    @Column(name="photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name="idCategory")
    private Category category;


}





