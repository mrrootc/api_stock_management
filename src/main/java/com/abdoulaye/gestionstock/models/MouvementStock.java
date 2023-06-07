package com.abdoulaye.gestionstock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mouvementstock")
public class MouvementStock extends AbstratEntity{
    @ManyToOne()
    @JoinColumn(name = "id_article")
    private Article article;
    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "datemvt")
    private Instant dateMvt;
    @Column(name = "type_mvt")
    private TypeMouvementStock typeMvt;
}
