package com.abdoulaye.gestionstock.dto;

import com.abdoulaye.gestionstock.models.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class EntrepriseDto {
    private Long id;
    private String nom;
    private String description;
    private AdresseDto adresse;
    private String codeFiscal;
    private String image;
    private String email;
    private String steWeb;
    private String phone;

    private List<UtilisateurDto> utilisateurList;

    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise == null){
            return null;
        }

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .codeFiscal(entreprise.getCodeFiscal())
                .image(entreprise.getImage())
                .email(entreprise.getImage())
                .phone(entreprise.getPhone())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .steWeb(entreprise.getSteWeb())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto == null){
            return  null;

        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setPhone(entrepriseDto.getPhone());
        entreprise.setImage(entrepriseDto.getImage());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
        entreprise.setSteWeb(entreprise.getSteWeb());

        return entreprise;
    }

}
