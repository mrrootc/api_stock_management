package com.abdoulaye.gestionstock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    @JoinColumn(name = "id_article")
    private Article article;
    @ManyToOne()
    @JoinColumn(name = "id_vente")
    private Vente vente;

    private BigDecimal quantite;
}
