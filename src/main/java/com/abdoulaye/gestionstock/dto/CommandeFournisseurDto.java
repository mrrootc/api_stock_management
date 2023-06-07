package com.abdoulaye.gestionstock.dto;




import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeFournisseurDto {
    private int id;
    private String code;
    private Instant dateCommande;
    private FournisseurDto fournisseurDto;
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseursDto;
}
