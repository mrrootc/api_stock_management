package com.abdoulaye.gestionstock.dto;

import com.abdoulaye.gestionstock.models.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDto {
    private int id;
    private String nomRole;
    private UtilisateurDto utilisateur;

    public static RoleDto fromEntity(Role role){
        if(role == null){
            return null;
        }
        return RoleDto.builder()
                .id(role.getId())
                .nomRole(role.getNomRole())
                .build();
    }
    public static Role toEntity(RoleDto roleDto){
        if(roleDto.equals(null)){
            return null;
        }

        Role role = new Role();
        role.setId(roleDto.getId());
        role.setNomRole(roleDto.getNomRole());
        role.setUtilisateur(UtilisateurDto.toEntity(roleDto.getUtilisateur()));

        return role;
    }
}
