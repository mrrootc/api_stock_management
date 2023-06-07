package com.abdoulaye.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {
    private int id;
    private VenteDto vente;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
}
