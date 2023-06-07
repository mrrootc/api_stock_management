package com.abdoulaye.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class EntrepriseDto {
    private int id;
    private String nom;
    private String description;
    private AdresseDto adresseDto;
    private String codeFiscal;
    private String image;
    private String email;

    private String phone;

    private List<UtilisateurDto> utilisateurList;

}
