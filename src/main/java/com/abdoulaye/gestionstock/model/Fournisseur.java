package com.abdoulaye.gestionstock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fournisseur")
public class Fournisseur extends AbstratEntity{
    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "image")
    private String image;

    @Embedded //cette annotation veut dire que Adresse est un champ composé
    private Adresse adresse;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
