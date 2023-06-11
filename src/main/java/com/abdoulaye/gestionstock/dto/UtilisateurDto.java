package com.abdoulaye.gestionstock.dto;

import com.abdoulaye.gestionstock.models.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

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
                 .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if(utilisateurDto == null){
            return null;

        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setPhone(utilisateurDto.getPhone());
        utilisateur.setImage(utilisateurDto.getImage());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());

        return utilisateur;
    }
}
