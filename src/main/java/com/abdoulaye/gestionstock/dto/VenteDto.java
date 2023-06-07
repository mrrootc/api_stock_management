package com.abdoulaye.gestionstock.dto;


import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class VenteDto   {
    private int id;
    private String code;
    private Instant dateVente;
    private String commentaire;
}
