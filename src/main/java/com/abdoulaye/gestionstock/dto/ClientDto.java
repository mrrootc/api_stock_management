package com.abdoulaye.gestionstock.dto;

import com.abdoulaye.gestionstock.models.Client;
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
    private Integer phone;
    private String image;
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

        return client;
    }
}
