package com.abdoulaye.gestionstock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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

    @OneToMany(mappedBy = "categorieId")
    private List<Article> article;



}
