package com.abdoulaye.gestionstock.dto;

import com.abdoulaye.gestionstock.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.util.List;
@Builder
@Data
public class ClientDto {
    private int id;
    private AdresseDto adresse;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private String image;
    private Integer idEntreprise;
    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }

        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .email(client.getEmail())
                .phone(client.getPhone())
                .image(client.getImage())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .idEntreprise(client.getIdEntreprise())
                .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return  null;

        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setImage(clientDto.getImage());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
        client.setIdEntreprise(clientDto.getIdEntreprise());

        return client;
    }
}
