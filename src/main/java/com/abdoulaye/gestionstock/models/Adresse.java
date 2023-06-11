package com.abdoulaye.gestionstock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Adresse {
    @Column(name = "adresse1")
    private String adresse1;
    @Column(name = "adresse2")
    private String adresse2;
    @Column(name = "ville")
    private String ville;
    @Column(name = "code_postal")
    private String codePostal;
}
