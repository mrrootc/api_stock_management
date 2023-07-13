package com.abdoulaye.gestionstock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorie")
public class Categorie extends AbstratEntity{

    @Column(name = "codecategorie")
    private String codeCategorie;

    @Column(name = "description")
    private String description;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "categorie")
    private List<Article> article;



}