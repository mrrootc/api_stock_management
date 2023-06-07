package com.abdoulaye.gestionstock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "entreprise")
public class Entreprise extends AbstratEntity{
    @Column(name = "nom")
    private String nom;
}
