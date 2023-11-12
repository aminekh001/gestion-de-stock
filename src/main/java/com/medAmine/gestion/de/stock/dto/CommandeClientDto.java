package com.medAmine.gestion.de.stock.dto;


import com.medAmine.gestion.de.stock.model.CommandeClient;
import com.medAmine.gestion.de.stock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder
public class CommandeClientDto {

    private Long id;

    private String code;
    private Instant dateCommande;

    private EtatCommande etatCommande;

    private ClientDto client;
    private Integer idEntreprise;
    private List<LigneCommandeClientDto> ligneCommandeClients;

    public CommandeClientDto fromEntity(CommandeClient commandeClient){
        if(commandeClient==null){
            //expt to do
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .etatCommande(commandeClient.getEtatCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .idEntreprise(commandeClient.getIdEntreprise())
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto dto){
        if (dto == null){
            //exp to do
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(dto.getId());
        commandeClient.setCode(dto.getCode());
        commandeClient.setDateCommande(dto.getDateCommande());
        commandeClient.setEtatCommande(dto.getEtatCommande());
        commandeClient.setIdEntreprise(dto.getIdEntreprise());
        return commandeClient;

    }
}
