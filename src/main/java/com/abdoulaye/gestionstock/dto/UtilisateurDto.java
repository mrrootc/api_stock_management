package com.abdoulaye.gestionstock.dto;

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
}
