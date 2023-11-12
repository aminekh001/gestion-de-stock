package com.medAmine.gestion.de.stock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "category")
public class Category extends AbstracetEntity{
    @Column(name="code")
    private String code;
    @Column(name="designation")
    private  String designation;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;


}
