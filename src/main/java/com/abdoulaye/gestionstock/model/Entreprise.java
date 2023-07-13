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
@Table(name = "entreprise")
public class Entreprise extends AbstratEntity{
    @Column(name = "nom")
    private String nom;

    @Column(name = "descriptiom")
    private String description;

    @Embedded
    private Adresse adresse;

    @Column(name = "codefiscal")
    private String codeFiscal;

    @Column(name = "image")
    private String image;

    @Column(name = "email")
    private String email;

    @Column(name = "numtel")
    private String phone;

    @Column(name = "siteweb")
    private String steWeb;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurList;
}
