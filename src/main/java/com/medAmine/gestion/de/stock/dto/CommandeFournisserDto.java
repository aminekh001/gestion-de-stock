package com.medAmine.gestion.de.stock.dto;


import com.medAmine.gestion.de.stock.model.CommandeFournisser;
import com.medAmine.gestion.de.stock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisserDto {
    private Long id;

    private String code;


    private Instant dateCommande;

    private EtatCommande etatCommande;

    private FournisserDto fournisser;

    private Integer idEntreprise;

    private List<LigneCommandeFournisserDto> ligneCommandeFournissers;

    public static CommandeFournisserDto fromEntity(CommandeFournisser commandeFournisser){
        if (commandeFournisser==null){
            //expo to do
            return null;

        } return CommandeFournisserDto.builder()
                .id(commandeFournisser.getId())
                .code(commandeFournisser.getCode())
                .fournisser(FournisserDto.fromEntity(commandeFournisser.getFournisser()))
                .dateCommande(commandeFournisser.getDateCommande())
                .idEntreprise(commandeFournisser.getIdEntreprise())

                .build();

    }
    public static CommandeFournisser toEntity(CommandeFournisserDto commandeFournisserDto) {
    if (commandeFournisserDto==null){
        //expo to do
        return null;
    }
    CommandeFournisser commandeFournisser =new CommandeFournisser();
    commandeFournisser.setId(commandeFournisserDto.getId());
    commandeFournisser.setCode(commandeFournisserDto.getCode());
    commandeFournisser.setFournisser(FournisserDto.toEntity(commandeFournisserDto.getFournisser()));
    commandeFournisser.setDateCommande(commandeFournisserDto.getDateCommande());
    commandeFournisser.setIdEntreprise(commandeFournisserDto.getIdEntreprise());
    commandeFournisser.setEtatCommande(commandeFournisserDto.getEtatCommande());
    return commandeFournisser;
    }
}
