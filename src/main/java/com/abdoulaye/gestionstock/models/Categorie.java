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
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorie")
public class Categorie extends AbstratEntity{

    @Column(name = "codecategorie")
    private int codeCategorie;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "categorie")
    private List<Article> article;
}
