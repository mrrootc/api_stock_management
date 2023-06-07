package com.abdoulaye.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class  LigneCommandeFournisseurDto {
    private int id;
    private ArticleDto article;
    private CommandeFournisseurDto commandeFournisseurDto;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
}
