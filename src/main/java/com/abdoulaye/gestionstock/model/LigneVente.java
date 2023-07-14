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
@Table(name = "lignevente")
public class LigneVente extends AbstratEntity{

    @ManyToOne()
    @JoinColumn(name = "idvente")
    private Vente vente;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "identreprise")
    private Integer idEntreprise;
}
