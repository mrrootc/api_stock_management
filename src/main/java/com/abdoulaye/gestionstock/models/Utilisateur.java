package com.abdoulaye.gestionstock.models;

import jakarta.persistence.*;
import jdk.jshell.execution.Util;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur extends AbstratEntity{

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "date_naissance")
    private Instant dateDeNaissance;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "image")
    private String image;
    @Embedded
    private Adresse adresse;
    @Column(name = "motdepasse")
    private String motDePasse;
    @OneToMany(mappedBy = "utilisateur")
    private List<Role> roles;
    @ManyToOne()
    @JoinColumn(name = "id_entreprise")
    private Entreprise entreprise;
}
