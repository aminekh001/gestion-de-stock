package com.medAmine.gestion.de.stock.dto;


import com.medAmine.gestion.de.stock.model.LigneCommandeFournisser;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisserDto {
    private Long id;

    private ArticleDto article;

    private CommandeFournisserDto commandeFournisser;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

    public static LigneCommandeFournisserDto fromEntity(LigneCommandeFournisser ligneCommandeFournisseur) {
        if (ligneCommandeFournisseur == null) {
            return null;
        }
        return LigneCommandeFournisserDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .idEntreprise(ligneCommandeFournisseur.getIdEntreprise())
                .build();
    }

    public static LigneCommandeFournisser toEntity(LigneCommandeFournisserDto dto) {
        if (dto == null) {
            return null;
        }

        LigneCommandeFournisser ligneCommandeFournisser = new LigneCommandeFournisser();
        ligneCommandeFournisser.setId(dto.getId());
        ligneCommandeFournisser.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneCommandeFournisser.setPrixUnitaire(dto.getPrixUnitaire());
        ligneCommandeFournisser.setQuantite(dto.getQuantite());
        ligneCommandeFournisser.setIdEntreprise(dto.getIdEntreprise());
        return ligneCommandeFournisser;
    }
}
