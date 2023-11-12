package com.medAmine.gestion.de.stock.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medAmine.gestion.de.stock.model.Fournisser;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class FournisserDto {
    private Long id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private Integer idEntreprise;

    private String photo;

    private String mail;

    private String numTel;

    @JsonIgnore
    private List<CommandeFournisserDto> commandeFournissers;


    public static FournisserDto fromEntity(Fournisser fournisser){
        if(fournisser==null){
            //exp to do
            return null;
        } return FournisserDto.builder()
                .id(fournisser.getId())
                .nom(fournisser.getNom())
                .prenom(fournisser.getPrenom())
                .adresse(AdresseDto.fromEntity(fournisser.getAdresse()))
                .photo(fournisser.getPhoto())
                .mail(fournisser.getMail())
                .numTel(fournisser.getNumTel())
                .build();
    }
    public static Fournisser toEntity(FournisserDto dto){
        if ( dto==null){
            //exp to do
            return null;
        }
        Fournisser fournisser = new Fournisser();
        fournisser.setId(dto.getId());
        fournisser.setNom(dto.getNom());
        fournisser.setPrenom(dto.getPrenom());
        fournisser.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        fournisser.setPhoto(dto.getPhoto());
        fournisser.setMail(dto.getMail());
        fournisser.setNumTel(dto.getNumTel());
        fournisser.setIdEntreprise(dto.getIdEntreprise());
        return fournisser;
    }
}
