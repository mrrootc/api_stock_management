package com.abdoulaye.gestionstock.dto;



import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FournisseurDto {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Integer phone;
    private String image;
    private AdresseDto adresseDto;
    private List<CommandeFournisseurDto> commandeFournisseursDto;
}
