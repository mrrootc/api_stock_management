package com.abdoulaye.gestionstock.dto;


import com.abdoulaye.gestionstock.models.Vente;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class VenteDto   {
    private Long id;
    private String code;
    private Instant dateVente;
    private String commentaire;
    private Integer idEntreprise;

    private List<LigneVenteDto> ligneVentes;
    public static VenteDto fromEntity(Vente vente){
        if (vente.equals(null)){
            return null;
        }

        return VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdEntreprise())
                .build();
    }

    public static Vente toEntity(VenteDto venteDto){
        if(venteDto == null){
            return null;
        }

        Vente vente = new Vente();
        vente.setId(venteDto.getId());
        vente.setCode(vente.getCode());
        vente.setDateVente(venteDto.getDateVente());
        vente.setCommentaire(venteDto.getCommentaire());
        vente.setIdEntreprise(venteDto.getIdEntreprise());

        return vente;
    }
}
