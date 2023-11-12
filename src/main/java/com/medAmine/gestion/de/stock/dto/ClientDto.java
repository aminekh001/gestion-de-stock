package com.medAmine.gestion.de.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medAmine.gestion.de.stock.model.Client;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder

public class ClientDto {
    private Long id;
    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private String mail;
    private String numTel;

    private Integer idEntreprise;
    @JsonIgnore
    private List<CommandeClientDto> commandeClientList;
    public static ClientDto fromEntity(Client client){
        if (client==null){
            //exp to do
            return null;

        } return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .idEntreprise(client.getIdEntreprise())
                .build();

    }
    public static Client toEntity(ClientDto clientDto){
        if (clientDto==null){
            //exp to do
            return null;
        }
        Client client= new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
        client.setMail(clientDto.getMail());
        client.setNumTel(clientDto.getNumTel());
        client.setIdEntreprise(clientDto.getIdEntreprise());
        return client;
    }
}
