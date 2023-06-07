package com.abdoulaye.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDto {
    private int id;
    private String nomRole;
    private UtilisateurDto utilisateur;
}
