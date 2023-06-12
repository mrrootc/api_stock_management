package com.abdoulaye.gestionstock.dto;

import com.abdoulaye.gestionstock.models.LigneCommandeFournisseur;
import com.abdoulaye.gestionstock.models.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {
    private Long id;
    private VenteDto vente;
    private ArticleDto article;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;
    public static LigneVenteDto fromEntity(LigneVente ligneVente){
        if(ligneVente == null){
            return null;
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .vente(VenteDto.fromEntity(ligneVente.getVente()))
                .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                .idEntreprise(ligneVente.getIdEntreprise())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if(ligneVenteDto == null){
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        ligneVente.setVente(VenteDto.toEntity(ligneVenteDto.getVente()));
        ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
        ligneVente.setIdEntreprise(ligneVenteDto.getIdEntreprise());

        return ligneVente;
    }
}
