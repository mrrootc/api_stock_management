package com.abdoulaye.gestionstock.dto;

import com.abdoulaye.gestionstock.models.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class UtilisateurDto {
    private int id;
    private String nom;
    private String prenom;
    private Instant dateDeNaissance;
    private String email;
    private Integer phone;
    private String image;
    private AdresseDto adresse;
    private String motDePasse;
    private List<RoleDto> role;
    private EntrepriseDto entreprise;

    public  static UtilisateurDto fromEntity(Utilisateur utilisateur){
         if(utilisateur == null){
             return null;
         }

         return UtilisateurDto.builder()
                 .id(utilisateur.getId())
                 .nom(utilisateur.getNom())
                 .prenom(utilisateur.getPrenom())
                 .dateDeNaissance(utilisateur.getDateDeNaissance())
                 .phone(utilisateur.getPhone())
                 .image(utilisateur.getImage())
                 .motDePasse(utilisateur.getMotDePasse())
                 .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                 .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                 .role(
                         utilisateur.getRoles() != null?
                                 utilisateur.getRoles()
                                         .stream()
                                         .map(RoleDto::fromEntity)
                                         .collect(Collectors.toList()) : null
                 )
                 .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if(utilisateurDto == null){
            return null;

        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setPhone(utilisateurDto.getPhone());
        utilisateur.setImage(utilisateurDto.getImage());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));


        return utilisateur;
    }
}
