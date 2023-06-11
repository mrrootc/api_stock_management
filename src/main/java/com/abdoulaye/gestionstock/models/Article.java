package com.abdoulaye.gestionstock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article")
public class Article extends AbstratEntity {

    @Column(name = "codearticle", nullable = false)
    private int codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prix")
    private BigDecimal prixUnitaire;
    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "datefab")
    private Instant dateFab;

    @Column(name = "dateexp")
    private Instant dateExp;

    @ManyToOne()
    @JoinColumn(name = "idcategorie")
    private Categorie categorie;

}
