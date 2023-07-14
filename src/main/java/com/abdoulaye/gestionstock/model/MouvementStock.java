package com.abdoulaye.gestionstock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mouvementstock")
public class MouvementStock extends AbstratEntity{
    @ManyToOne()
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "datemvt")
    private Instant dateMvt;

    @Column(name = "type_mvt")
    @Enumerated(EnumType.STRING)
    private TypeMouvementStock typeMvt;

    @Column(name = "sourcemvt")
    @Enumerated(EnumType.STRING)
    private SourceMouvementStock sourceMvt;

    @Column(name = "identreprise")
    private Integer idEntreprise;
}
