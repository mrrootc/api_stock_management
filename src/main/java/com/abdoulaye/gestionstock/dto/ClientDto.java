package com.abdoulaye.gestionstock.dto;

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
    private List<CommandeClientDto> commandeClients;
}
