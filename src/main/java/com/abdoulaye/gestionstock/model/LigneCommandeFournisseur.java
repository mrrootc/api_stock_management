package com.abdoulaye.gestionstock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lignecommandefournisseur")
public class LigneCommandeFournisseur extends AbstratEntity{

    @ManyToOne()
    @JoinColumn(name = "idarticle")
    private Article article;
    @ManyToOne()
    @JoinColumn(name = "idcommandefournisser")
    private CommandeFournisseur commandeFournisseur;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;
}
